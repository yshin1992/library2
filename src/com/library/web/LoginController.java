package com.library.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.constants.SysConstants;
import com.library.entity.LoginUserInfo;
import com.library.service.LoginService;
import com.library.util.LogUtil;
import com.library.util.StringUtil;
import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
public class LoginController {

	@Resource
	private ImageCaptchaService imageCaptchaService;

	@Resource
	private LoginService<LoginUserInfo> managerLoginService;

	@RequestMapping(value = "/login.html")
	public String login(HttpServletRequest request) {
		// 获取传递的参数
		String managerID = request.getParameter("userId");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");

		if (!StringUtil.isEmpty(managerID, password, verifyCode)) {
			// 校验验证码
			try {
				String sessionId = request.getSession().getId();
				if (!imageCaptchaService.validateResponseForID(sessionId,
						verifyCode)) {
					request.setAttribute("verifyError", "验证码错误!");
					return "login";
				}
			} catch (Exception ex) {
				LogUtil.getLogger(this).debug("校验验证码异常：", ex);
				return "login";
			}

			// 校验用户名和密码
			LoginUserInfo loginUserInfo = managerLoginService.login(managerID,
					password, request);
			if (null != loginUserInfo) {
				request.getSession()
						.setAttribute(SysConstants.SESSION_KEY_LOGIN_USER_INFO,
								loginUserInfo);
				return "welcome";
			} else {
				request.setAttribute("error", "用户名密码错误!");
				LogUtil.getLogger(this).debug("用户名密码错误!");
			}

		} else {
			request.setAttribute("error", "用户名或密码不能为空!");
			LogUtil.getLogger(this).debug("用户名或密码不能为空!");
		}
		return "login";
	}

	@RequestMapping(value = "/loginout.html")
	public String loginout(HttpServletRequest request) {
		managerLoginService.loginout("正常退出", request);
		// 销毁session
		request.getSession().invalidate();
		return "login";
	}

}
