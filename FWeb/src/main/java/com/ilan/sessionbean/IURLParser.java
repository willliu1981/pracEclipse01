package com.ilan.sessionbean;

import com.ilan.bean.URLParserBean;

public interface IURLParser {
	void setBean(URLParserBean bean);
	String  getParsedURL();
}
