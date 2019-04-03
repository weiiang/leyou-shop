package com.leyou.user.entity.ext;

public class UserBasicInfo {

    private String id;
    private String username;
    private String userpic;
    private String name;
    private String utype;
    /**
     * 所属企业信息
     */
    private String companyId;
    /**
     * jwt令牌
     */
    private String jwt_token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getJwt_token() {
        return jwt_token;
    }

    public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
    }

    @Override
    public String toString() {
        return "UserBasicInfo{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", userpic='" + userpic + '\'' +
                ", name='" + name + '\'' +
                ", utype='" + utype + '\'' +
                ", companyId='" + companyId + '\'' +
                ", jwt_token='" + jwt_token + '\'' +
                '}';
    }
}
