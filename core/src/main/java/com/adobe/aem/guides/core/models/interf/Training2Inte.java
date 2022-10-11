package com.adobe.aem.guides.core.models.interf;

import java.util.Iterator;
import java.util.List;

import com.day.cq.wcm.api.Page;

public interface Training2Inte {

	public String getId();
	public String getLinkURL();
	public String getTitle1();
	public String getTitle2();
	public String getCurrentPageTitle();
	public int getValue();
	public String getRequestAttribute();
	public String getUsPage();
	public String getModifiedBy();
	public Iterator<Page> getPagesList();
	public List<String> getPageTitleList();
	public String getNameFromService();
	public String getNameFromServiceB();
	public String getNameWithReferenceTarget();
}
