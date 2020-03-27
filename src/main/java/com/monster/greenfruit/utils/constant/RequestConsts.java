package com.monster.greenfruit.utils.constant;

public class RequestConsts {


    public static final Integer REQUEST_SUCCESS = 200;

    public static final String MSG_SUCCESS = "操作成功";

    public static final Integer REQUEST_FAILURE_NORMAL = 201;

    public static final String MSG_FAILURE_NORMAL = "操作失败";

    public static final Integer REQUEST_FAILURE_FRONT = 100;

    public static final String MSG_FAILURE_FRONT = "客户端系统出错";

    public static final Integer REQUEST_FAILURE_SYS = 500;

    public static final String MSG_FAILURE_SYS = "系统出错";

    public static final Integer REQUEST_DATA_UPDATE_FAILURE = 501;

    public static final String MSG_DATA_UPDATE_FAILURE = "数据更新出错";

    public static final Integer REQUEST_FAILURE_AUTHORITY = 401;  //未登录就想进入内容界面

    public static final String MSG_FAILURE_AUTHORITY = "您无权访问";

    public static final Integer VALID_FAILURE = 400; //例如请求错误或域名不存在

    public static final String MSG_VALID_FAILURE = "输入的数据不合法，请输入合法的数据";
}
