package com.adobe.aem.guides.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

import com.adobe.aem.guides.core.services.MultiService;

@Component(service = MultiService.class,immediate = true,name="serviceB")
@ServiceRanking(1001)
public class MultiserviceBImpl implements MultiService {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "MultiserviceBImpl";
	}

}
