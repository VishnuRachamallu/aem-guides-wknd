/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;

import com.adobe.aem.guides.core.models.interf.Training2Inte;
import com.adobe.aem.guides.core.services.DemoServiceA;
import com.adobe.aem.guides.core.services.DemoServiceB;
import com.adobe.aem.guides.core.services.MultiService;
import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Model(adaptables = SlingHttpServletRequest.class)
public class Training2 implements Training2Inte {

	public static final Logger LOG=org.slf4j.LoggerFactory.getLogger(Training2.class);
	@SlingObject
	ResourceResolver resourceResolver;
	
	@OSGiService
	DemoServiceA demoServiceA;
	
	@Inject
	DemoServiceB demoServiceB;
	
	@OSGiService(filter = "(component.name=serviceA)")
	MultiService multiService;
	
	@OSGiService(filter = "(component.name=serviceB)")
	MultiService multiServiceB;
	
	@Self 
	SlingHttpServletRequest slingHttpServletRequest;
	
	@OSGiService
	QueryBuilder queryBuilder;
	
	@ScriptVariable
	Page currentPage;
	
	@Inject @Via("resource")
	@Default(values="2000")
    private String title1;
	
	//@Inject @Via("resource")  
	//insted of inject and via you can directly use @ValueMapValue
	@ValueMapValue
	@Default(values="200")
	private String id;
	
	
	@RequestAttribute(name="rAttribute") 
	private String reqAttribute="test ttt";
	 
	
	@Inject @Via("resource")
	@Default(values="http://google.com")
	@Named("linkURL")
	private String linkURL;
	
	@Inject@Via("resource")
	@Named("jcr:lastModifiedBy")
	String modifiedBy;
	
	@ResourcePath(path = "/content/wknd/us") @Via("resource")
	Resource resource;
	
	@Inject @org.apache.sling.models.annotations.Optional
	@Default(values="19")
	@Via("resource")
	private String title2;
		
	private int value;
	
    @PostConstruct
    protected void init() {
    	//value=100;
    	value=Integer.parseInt(title1)+Integer.parseInt(id)-Integer.parseInt(title2);
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getLinkURL() {
		// TODO Auto-generated method stub
		return linkURL;
	}

	@Override
	public String getTitle1() {
		// TODO Auto-generated method stub
		return title1;
	}

	@Override
	public String getTitle2() {
		// TODO Auto-generated method stub
		return title2;
	}

	@Override
	public String getCurrentPageTitle() {
		// TODO Auto-generated method stub
		return currentPage.getTitle();
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	
	@Override public String getRequestAttribute() { // TODO Auto-generated method stub
	  return reqAttribute; }

	@Override
	public String getUsPage() {
		// TODO Auto-generated method stub
		return resource.getName();
	}

	@Override
	public String getModifiedBy() {
		// TODO Auto-generated method stub
		return modifiedBy;
	}

	@Override
	public Iterator<Page> getPagesList() {
		// TODO Auto-generated method stub
		return demoServiceA.getPages();
	}

	@Override
	public List<String> getPageTitleList() {
		// TODO Auto-generated method stub
		return demoServiceB.getPages();
	}

	@Override
	public String getNameFromService() {
		// TODO Auto-generated method stub
		return multiService.getName();
	}

	@Override
	public String getNameFromServiceB() {
		// TODO Auto-generated method stub
		return multiServiceB.getName();
	}

	@Override
	public String getNameWithReferenceTarget() {
		// TODO Auto-generated method stub
		return demoServiceA.getNameWithReference();
	}
	
}
