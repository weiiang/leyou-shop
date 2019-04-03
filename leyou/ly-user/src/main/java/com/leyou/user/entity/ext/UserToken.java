package com.leyou.user.entity.ext;



public class UserToken{
    /**
     * 用户id
     */
    String userId;
    /**
     * 用户类型
     */
    String utype;
    /**
     * 用户所属企业信息
     */
    String companyId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


    @Override
    public String toString() {
        return "UserToken{" +
                "userId='" + userId + '\'' +
                ", utype='" + utype + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}

