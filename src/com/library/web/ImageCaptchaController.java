package com.library.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.util.LogUtil;
import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
public class ImageCaptchaController {

	@Resource
	private ImageCaptchaService imageCaptchaService;

	@RequestMapping(value = "/verifyCode.do")
	public void getIcon(HttpServletRequest request, HttpServletResponse response) {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = null;
		OutputStream out = null;
		try {
			String captchaId = request.getSession().getId();
			BufferedImage challenge = imageCaptchaService
					.getImageChallengeForID(captchaId, request.getLocale());
			jpegOutputStream = new ByteArrayOutputStream();
			ImageIO.write(challenge, "jpg", jpegOutputStream);

			captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			// 得到输出流
			out = response.getOutputStream();
			out.write(captchaChallengeAsJpeg);
			out.flush();
		} catch (Exception ex) {
			LogUtil.getLogger(this).error("生成验证码图片异常：", ex);
		} finally {
			try {
				if (null != out) {
					out.close();
					out = null;
				}
			} catch (Exception ex) {
				LogUtil.getLogger(this).warn("关闭ServletOutputStream异常：", ex);
			}
			try {
				if (null != jpegOutputStream) {
					jpegOutputStream.close();
					jpegOutputStream = null;
				}
			} catch (Exception ex) {
				LogUtil.getLogger(this).warn("关闭ByteArrayOutputStream异常：", ex);
			}
		}
	}

}