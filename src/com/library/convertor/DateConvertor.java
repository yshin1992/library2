package com.library.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.library.util.LogUtil;
import com.library.util.StringUtil;

public class DateConvertor implements Converter<String, Date> {

	private static final String format = "yyyy-MM-dd HH:mm:ss";

	@Override
	public Date convert(String source) {
		if (!StringUtil.isEmpty(source)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			try {
				return dateFormat.parse(source);
			} catch (ParseException e) {
				LogUtil.getLogger(this).debug("日期类型转换异常", e);
			}
		}
		return null;
	}

}
