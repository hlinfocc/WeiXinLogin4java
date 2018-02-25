# WeiXinLogin4java
微信授权登录，微信公众号授权登录，获取openid，获取微信用户信息，JAVA版本
## 微信公众号条件
1.	要求：微信公众号是服务号，并且通过微信认证
2.	配置：在微信公众平台配置好网页授权回调域名
## 使用示例
1.	将程序部署在服务器（需要部署在配置好的网页授权回调域名下），配置好wxlogin.xml中的微信公众号AppID和AppSecret
2.	访问wxlogin.action（WXLoginAction）。
3.	在WXLoginBackAction中处理回调。
