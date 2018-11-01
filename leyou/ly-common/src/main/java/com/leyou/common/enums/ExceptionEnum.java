package com.leyou.common.enums;

public enum ExceptionEnum {

    BADREQUEST_NAME_CANNOT_BE_NULL(400,"名称不能为空!"),
    BADREQUEST_AGE_CANNOT_BE_NULL(400, "年龄不能为空!"),

    //商品分类
    NOT_FOUNT_ITEM_CATEGORY(404, "没找到商品分类"),
    BADREQUEST_CATEGORY_NAME_CANNOT_BE_NULL(400,"分类名称不能为空!"),
    BADREQUEST_CATEGORY_NAME_EXIST(400, "该分类已存在!");
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
