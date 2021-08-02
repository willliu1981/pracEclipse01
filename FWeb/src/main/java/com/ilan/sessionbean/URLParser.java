package com.ilan.sessionbean;

import org.junit.Test;

import com.ilan.bean.URLParserBean;

public class URLParser implements IURLParser {
	private URLParserBean bean;

	@Override
	public void setBean(URLParserBean bean) {
		this.bean=bean;
		
	}

	@Override
	public String getParsedURL() {
		String url=bean.getUri();
		String param=bean.getParam();
		String result=null;
		int charidx=-1;
		if((charidx=bean.getUri().indexOf('?'))!=-1) {
			result=bean.getUri().substring(0,charidx);
		}else {
			result=bean.getUri();
		}
		
		if(bean.getParam()!=null || !bean.getParam().equals("")) {
			result+="?"+bean.getParam();
		}
		
		return result;
	}
	
	@Test
	public void test() {
		URLParserBean bean=new URLParserBean();
		bean.setUri("http://aaa,bbb?sss=rrr");
		bean.setParam("sdfdsf=aaa");
		this.setBean(bean);
		System.out.println(getParsedURL());
	}

}
