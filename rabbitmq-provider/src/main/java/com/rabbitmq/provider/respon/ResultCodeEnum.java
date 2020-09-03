package com.rabbitmq.provider.respon;

/**
 * @Description: 调用状态枚举
 * @Author: muchunfa
 * @CreateDate: 2018/3/1 15:10
 */
public enum ResultCodeEnum {
    /**
     * 操作成功
     */
    RESULT_CODE_SUCCESS(200, "操作成功"),
    RESULT_CODE_NO_ACCOUNT(201, "未找到该账号"),
    RESULT_CODE_WRONG_PASS(202, "账号或密码错误"),
    RESULT_CODE_LOCKED_ACCOUNT(203, "账号已被锁定"),
    OLD_PASS_WRONG(204, "原来的密码输入有误，请核对后重新输入"),
    USERNAME_NULL(205, "用户名不可为空"),
    REAL_NAME_NULL(205, "真实姓名不可为空"),
    PASSWORD_NULL(205, "密码不可为空"),
    USERNAME_USERD(205, "用户名已经被注册"),
    NOT_LOGIN(206, "未知用户"),
    NEW_PASS_WRONG(207, "新密码两次输入不一致，请核对后重新输入"),
    NO_AUTHORITY(301, "您没有权限进行此操作"),
    NO_car_DATA(302, "抱歉，暂无您要查询的数据"),
    MODEL_ERROR(303, "文件或模板选择有误"),
    //系统异常
    NullPointerException(500, "空指针异常"),
    IllegalArgumentException(500, "请求参数类型不匹配"),
    ParamNull(500, "参数为空"),
    SQLException(500, "数据库访问异常"),
    ServerExceprion(500, "服务器异常,请联系管理员"),
    ERROR_STATUS(999, "系统异常，请联系管理员！"),
    System_Maintenance(601, "系统维护中"),
    NO_DATA(602, "暂无数据");

    /**
     *
     */


    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
