package hlinfo.api.wxlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WXLoginAction
 */
@WebServlet("/wxlogin.action")
public class WXLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXLoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getContextPath();int port = request.getServerPort();
		String basePath = (port==80 || port==443)?request.getScheme()+"://"+request.getServerName()+path+"/":request.getScheme()+"://"+request.getServerName()+":"+port+path+"/";
		WXLoginConfig wx=new WXLoginConfig();
		String state="";//state会原样返回
		String redirect_uri=basePath+"wxloginback.action";//回调地址
		redirect_uri=URLEncoder.encode(redirect_uri,"utf-8");
		String wxurl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wx.appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_userinfo&state="+state+"#wechat_clientstate";
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("  <head><title>微信授权登录中...</title><meta charset=\"UTF-8\"></head>");
		out.println("  <body>");
		out.print("<script>location.href='"+wxurl+"';</script>");
		out.println("  </body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
