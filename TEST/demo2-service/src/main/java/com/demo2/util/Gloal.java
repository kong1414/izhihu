package com.demo2.util;

/**
 * 全局常量
 *
 * @author yangyx
 * @version 1.0
 */
public final class Gloal {

    /**
     * 学生导入模板
     */
    public static final String IMPORT_STUDENT_TEMPLATE = "student-import-template.xlsx";

    /**
     * 导入相关文件存储位置
     */
    public static final String IMPORT_TEMP_FILE_DIRECTORY = "/uddata/tempFile/studentImport/";

    /*
     * 问卷存储位置
     */
    public static final String IMPORT_FAILED_PATH = "/uddata/tempFile/questionnaireFile/";

    public static final String IMPORT_QUOTA_PATH = "/uddata/tempFile/quotaFile/";

    /**
     * 系统分隔符
     */
    public static final String SEPARATOR = System.getProperty("file.separator");

    /**
     * 字符集
     */
    public static final String ENCODING = "UTF-8";

    /**
     * json类型的content type
     */
    public static final String JONS_CONTENT_TYPE = "application/json";

    /**
     * url请求合法后缀（可被系统接收的）
     */
    public static final String URL_END_WITH = ".jhtml";

    /**
     * 资源文件前缀
     */
    public static final String MESSAGE_PRE = "messages_";

    /**
     * request头部存放token所用key
     */
    public static final String REQUEST_HEADER_TOKEN_KEY = "token";

    /**
     * token中携带用户信息所使用key
     */
    public static final String TOKEN_USER_INFO_KEY = "token_user";

    /**
     * token中携带学生信息所使用key
     */
    public static final String TOKEN_STUDENT_INFO_KEY = "token_student";

    /**
     * request中携带用户信息所使用key
     */
    public static final String REQUEST_USER_KEY = "request_user";

    /**
     * token有效时长（秒）
     */
    public static final Integer TOKEN_AGE = Math.toIntExact(1000L * 60 * 30);

    public static final String Wrap = "";

    /**
     * 小数位数
     */
    public static final Integer DECIMALDIGITS = 2;

    /**
     * 视图界面列表每页记录数
     */
    public static final Integer PAGE_SIZE_IN_VIEW = 5;
}
