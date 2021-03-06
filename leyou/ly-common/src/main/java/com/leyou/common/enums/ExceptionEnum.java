package com.leyou.common.enums;

public enum ExceptionEnum {

    //用户
    USER_NOT_EXIST_EXCEPTION(404, "用户不存在"),
    USERNAME_OR_PASSWORD_CANNOT_BE_NULL(403, "账号和密码不能为空"),


    BADREQUEST_NAME_CANNOT_BE_NULL(400,"名称不能为空!"),
    BADREQUEST_AGE_CANNOT_BE_NULL(400, "年龄不能为空!"),

    //商品分类
    NOT_FOUNT_ITEM_CATEGORY(404, "没找到商品分类"),
    BADREQUEST_CATEGORY_NAME_CANNOT_BE_NULL(400,"分类名称不能为空!"),
    BADREQUEST_CATEGORY_NAME_EXIST(400, "该分类已存在!"),

    //商品品牌
    BADREQUEST_ITEM_BRAND_NAME_CANNOT_BE_NULL(400, "商品名称不能为空"),

    //文件上传
    BADREQUEST_UPLOAD_IMAGE_CANNOT_BE_NULL(400,"文件不能为空!"),
    BADREQUEST_UPLOAD_IMAGE_FILE_TYPE_IS_NOT_ALLOWED(400,"文件类型错误!"),
    BADREQUEST_UPLOAD_IMAGE_FILE_SIZE_IS_TOO_LARGE(400,"文件大小超出范围!"),
    BADREQUEST_UPLOAD_IMAGE_FILE_CONTENT_IS_NOT_ALLOWED(400,"文件内容不符合要求!"),

    //规格参数组
    BADREQUEST_SPEC_GROUP_NAME_CANNOT_BE_NULL(400,"规格参数组名称不能为空!")
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
