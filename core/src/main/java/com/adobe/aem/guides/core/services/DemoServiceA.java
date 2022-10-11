package com.adobe.aem.guides.core.services;

import java.util.Iterator;

import com.day.cq.wcm.api.Page;

public interface DemoServiceA {

	public Iterator<Page> getPages();
	public String getNameWithReference();
}
