package com.library.convertor;

import org.springframework.core.convert.converter.Converter;

import com.library.util.StringUtil;

public class BooleanConvertor implements Converter<String, Boolean> {

	@Override
	public Boolean convert(String source) {
		if(!StringUtil.isEmpty(source)){
			if("0".equals(source)){
				return false;
			}else if("1".equals(source)){
				return true;
			}
		}
		return null;
	}

}
