package com.adobe.aem.guides.core.services.impl;

import java.util.Iterator;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.core.models.ResolverUtil;
import com.adobe.aem.guides.core.services.DemoServiceA;
import com.adobe.aem.guides.core.services.MultiService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = DemoServiceA.class,immediate = true)
public class DemoServiceAimpl implements DemoServiceA {

	private static final Logger LOG=LoggerFactory.getLogger(DemoServiceAimpl.class);
	@Reference
	ResourceResolverFactory resourceResolverFactory;
	
	
	@Reference (target = "(component.name=serviceB)") 
	MultiService multiService;
	 
	
	@Override
	public Iterator<Page> getPages() {
		
		try {
			ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Page page = pageManager.getPage("/content/we-retail/language-masters/en");
			Iterator<Page> pages = page.listChildren();
			return pages;
		} catch (LoginException e) {
			LOG.info("\n Login Exception {} ", e.getMessage());
			
		}
		return null;
	}

	@Override
	public String getNameWithReference() {
		// TODO Auto-generated method stub
		
		return "from reference with target "+multiService.getName();
		//return null;
	}

}
