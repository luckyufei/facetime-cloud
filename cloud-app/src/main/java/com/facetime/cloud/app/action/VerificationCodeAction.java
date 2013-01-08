package com.facetime.cloud.app.action;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.service.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facetime.cloud.app.support.AppRESTurl;
import com.facetime.cloud.app.support.VerificationCodeUtils;

/**  
 * 验证码生成类  
 *  
 * 使用开源验证码项目patchca生成  
 * 依赖jar包：patchca-0.5.0.jar  
 * 项目网址：https://code.google.com/p/patchca/  
 */
@Controller
public class VerificationCodeAction {

	@RequestMapping(value = AppRESTurl.verifyCode, method = RequestMethod.GET)
	@ResponseBody
	public String verify(String key, String code, HttpServletRequest request) {
		String savedCode = (String) request.getSession().getAttribute("validationCode");
		return savedCode != null && code != null ? savedCode.equalsIgnoreCase(code) + "" : Boolean.FALSE.toString();
	}

	@RequestMapping(value = AppRESTurl.createVerifyCode, method = RequestMethod.GET)
	public String create(String key, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");

		HttpSession session = request.getSession(true);
		OutputStream outputStream = response.getOutputStream();

		// 得到验证码对象,有验证码图片和验证码字符串  
		Captcha captcha = VerificationCodeUtils.get().createCaptcha();
		// 取得验证码字符串放入Session  
		String validationCode = captcha.getChallenge();
		session.setAttribute(key, validationCode);
		// 取得验证码图片并输出  
		BufferedImage bufferedImage = captcha.getImage();
		ImageIO.write(bufferedImage, "png", outputStream);

		outputStream.flush();
		outputStream.close();
		return null;
	}
}
