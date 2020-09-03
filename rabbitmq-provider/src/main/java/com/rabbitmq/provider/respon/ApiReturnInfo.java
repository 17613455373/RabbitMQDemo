package com.rabbitmq.provider.respon;

public class ApiReturnInfo<T> {

    private Integer code = ResultCodeEnum.RESULT_CODE_SUCCESS.getCode();
    private String message = ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage();
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
