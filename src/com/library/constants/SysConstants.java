package com.library.constants;

public class SysConstants
{
    /**
     * 用户登陆后放入Session中的用户信息键值
     */
	public static final String SESSION_KEY_LOGIN_USER_INFO = "curUser";
    
    public static final String ACCESS_URL = "url";

    /**
     * 默认字符串中的分隔符
     */
    public static final String DEFAULT_SEPARATOR = ",";

    public static final String SEPARATOR = ";";

    /**
     * 默认文件名分隔符（即文件名中不同含义的字符的连接符）
     */
    public static final String FILE_NAME_SEPARATOR = "-";

    /**
     * 路径分隔符
     */
    public static final String PATH_SEPARATOR = "/";

    /**
     * “+”连接符
     */
    public static final String ADD_SEPARATOR = "+";

    /**
     * 登录失败后放入Session中的键值
     */
    public static final String LOGIN_FAIL_INFO = "loginerror";

    /**
     * 更新失败后放入Session中的键值
     */
    public static final String UPDATE_ERROR_INFO = "updateerror";
    
    /**
     * 默认每页大小
     */
    public static final int DEFAULT_PAGA_SIZE=10;
}
