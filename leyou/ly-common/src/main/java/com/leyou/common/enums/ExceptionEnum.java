package com.leyou.common.enums;

public enum ExceptionEnum {

    BADREQUEST_NAME_CANNOT_BE_NULL(400,"名称不能为空!"),
    BADREQUEST_AGE_CANNOT_BE_NULL(400, "年龄不能为空!")
    ;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String msg;

    private ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ExceptionEnum() {}

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
