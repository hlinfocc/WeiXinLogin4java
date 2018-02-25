package hlinfo.api.wxlogin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.hlinfo.opt.HttpRequest;

/**
 * Servlet implementation class WXLoginBackAction
 */
@WebServlet("/wxloginback.action")
public class WXLoginBackAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXLoginBackAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//接收code和state参数
		String code=request.getParameter("code");
		String state=request.getParameter("state");
		WXLoginConfig wxc=new WXLoginConfig();
		//通过code换取access_token
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+wxc.appid+"&secret="+wxc.appSecret+"&code="+code+"&grant_type=authorization_code";
		HttpRequest http = new HttpRequest();
		String rstk=http.httpsget(url);
		JSONObject jsontk= JSON.parseObject(rstk);
		//判断是否获取access_token成功
		if(jsontk.containsKey("access_token")) {
			String access_token=jsontk.getString("access_token");
			String openid=jsontk.getString("access_token");
			//通过access_token和openid拉取用户信息(需scope为 snsapi_userinfo)
			String getuserurl="https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
			String rsUserInfo=http.httpsget(getuserurl);
			JSONObject jsonui= JSON.parseObject(rsUserInfo);
			//判断是否获取用户信息成功
			if(jsonui.containsKey("openid")) {
				//获取用户信息成功
				System.out.println("openid:"+jsonui.getString("openid"));
				System.out.println("nickname:"+jsonui.getString("nickname"));
				System.out.println("sex:"+jsonui.getString("sex"));
				System.out.println("province:"+jsonui.getString("province"));
				System.out.println("city:"+jsonui.getString("city"));
				System.out.println("country:"+jsonui.getString("country"));
				System.out.println("headimgurl:"+jsonui.getString("headimgurl"));
			}else {
				//获取用户信息失败
			}
		}else {
			//获取access_token失败
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
