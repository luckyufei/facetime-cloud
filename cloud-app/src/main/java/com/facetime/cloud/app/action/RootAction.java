package com.facetime.cloud.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facetime.cloud.app.support.AppRESTurl;

@Controller
public class RootAction {

	@RequestMapping(value = AppRESTurl.listRootFolder)
	public String file() {
		return "file/file_list";
	}

	@RequestMapping(value = AppRESTurl.chartView)
	public String chart() {
		return "chart/chart_list";
	}
}
