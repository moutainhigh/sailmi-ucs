package com.sailmi.enterprise.feign;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sailmi.core.tool.api.R;
import com.sailmi.enterprise.service.impl.UserEnterpriseServiceImpl;
import com.sailmi.system.entity.UserEnterprise;
import com.sailmi.system.feign.IuserEnterRelationFeign;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class UserEnterpriseFeign implements IuserEnterRelationFeign {

	private UserEnterpriseServiceImpl userEnterpriseServiceImpl;

	@Override
	@GetMapping(API_PREFIX +"/userenterlist")
	public R<List<UserEnterprise>> detailInfo(@RequestParam (value="enterpriseId", required = true) String enterpriseId) {
		QueryWrapper<UserEnterprise> userEnterpriseQueryWrapper = new QueryWrapper<>();
		if(enterpriseId!=null && enterpriseId!="") {
			userEnterpriseQueryWrapper.eq("enterprise_id", enterpriseId);
		}
		List<UserEnterprise> list = userEnterpriseServiceImpl.list(userEnterpriseQueryWrapper);
		return R.data(list);
	}
}
