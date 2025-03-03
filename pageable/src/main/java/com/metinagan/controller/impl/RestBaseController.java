package com.metinagan.controller.impl;

import org.springframework.data.domain.Pageable;

import com.metinagan.utils.PagerUtil;
import com.metinagan.utils.RestPageableRequest;

public class RestBaseController {

	public Pageable toPAgeable(RestPageableRequest request) {
		return PagerUtil.toPageable(request);
	}
	
}
