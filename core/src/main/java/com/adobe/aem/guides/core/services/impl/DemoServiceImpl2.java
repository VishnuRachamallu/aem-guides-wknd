package com.adobe.aem.guides.core.services.impl;

import org.osgi.service.component.annotations.Component;

import com.adobe.aem.guides.core.services.DemoService2;

@Component(service = DemoService2.class, immediate = true)
public class DemoServiceImpl2 implements DemoService2 {

	@Override
	public int add() {
		
		return 45;
	}

	@Override
	public int sub() {
		
		return -45;
	}

}
