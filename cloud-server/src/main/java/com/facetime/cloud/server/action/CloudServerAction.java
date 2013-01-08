package com.facetime.cloud.server.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facetime.cloud.data.bean.CloudServerBean;
import com.facetime.cloud.data.entity.CloudServerEntity;
import com.facetime.spring.action.Action;

@Controller
public class CloudServerAction extends Action {

	@RequestMapping("/list")
	public String list(ModelMap model) {
		List<CloudServerEntity> list = this.defaultLogic.findList(CloudServerEntity.class);
		System.out.println(list);
		model.put("list", list);
		return "test/list";
	}

	@RequestMapping("/add")
	public String add(CloudServerBean bean, ModelMap model) {
		
		this.getDefaultLogic().save(new CloudServerEntity(bean));
		return "redirect:/cloud/list";
	}

	@RequestMapping("/addUI")
	public String addUI() {
		return "test/add";
	}
}
