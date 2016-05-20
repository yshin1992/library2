
package com.library.convertor;

import org.springframework.core.convert.converter.Converter;

import com.library.util.LogUtil;
import com.library.util.StringUtil;

public class IntegerConvertor implements Converter<String, Integer>
{
    @Override
    public Integer convert(String source)
    {
        if (!StringUtil.isEmpty(source)) {
            try {
                return Integer.parseInt(source);
            } catch (Exception e) {
                LogUtil.getLogger(this).debug("整数类型转换异常", e);
            }
        }
        return null;
    }

}
