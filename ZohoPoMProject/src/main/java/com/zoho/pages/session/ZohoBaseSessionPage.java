package com.zoho.pages.session;

import com.zoho.base.pages.ZohoBase;
import com.zoho.pages.components.common.session.Header;

public class ZohoBaseSessionPage extends ZohoBase{
	Header header;
	
	public ZohoBaseSessionPage()
	{
		header=new Header(getCurrentDriver());
	}
	
	public Header getHeader()
	{
		return header;
	}
}
