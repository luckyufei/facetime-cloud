package com.facetime.cloud.app.action;

import static com.facetime.core.conf.SysLogger.cloudAppLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facetime.cloud.app.support.AppRESTurl;
import com.facetime.cloud.data.support.RequestConstants;
import com.facetime.spring.logic.RemoteLogic;

/**
 * 
 * 服务Action
 * 
 * @author yufei
 * @Create_by 2012-11-14
 * @Design_by eclipse  
 */
@Controller
public class ServiceAction {

	@Autowired
	private RemoteLogic remoteLogic;

	@RequestMapping(AppRESTurl.service)
	@ResponseBody
	public String execute(@RequestHeader(RequestConstants.SERVICE_URI) String serviceUri,
			@RequestHeader(RequestConstants.USER_TOKEN) String userToken,
			@RequestParam(RequestConstants.DATA) String json) {
		String result = remoteLogic.postToUri(userToken, serviceUri, json);
		cloudAppLogger.debug("ServiceAction, result=" + result);
		return result;
	}
}
