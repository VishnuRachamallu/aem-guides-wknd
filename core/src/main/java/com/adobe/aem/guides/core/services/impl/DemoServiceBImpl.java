package com.adobe.aem.guides.core.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.aem.guides.core.services.DemoServiceA;
import com.adobe.aem.guides.core.services.DemoServiceB;
import com.adobe.aem.guides.core.services.MultiService;
import com.day.cq.wcm.api.Page;


@Component(service = DemoServiceB.class,immediate = true)
public class DemoServiceBImpl implements DemoServiceB {

	@Reference
	DemoServiceA demoServiceA;
	
	
	@Override
	public List<String> getPages() {
		// TODO Auto-generated method stub
		List<String> listPages=new ArrayList<String>();
		
		try {
			
			Iterator<Page> pages= demoServiceA.getPages();
			while (pages.hasNext()) {
				listPages.add(pages.next().getTitle());		
			}
			return listPages;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
