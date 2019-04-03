package com.leyou.user.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="xc_company")
public class XcCompany implements Serializable {
    private static final long serialVersionUID = -916357110051689786L;
    @Id
    @Column(length = 32)
    private String id;
    private String name;
    private String logo;
    private String intro;
    private String email;
    private String mobile;
    private String linkname;
    private String identitypic;
    private String worktype;
    private String businesspic;
    private String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }

    public String getIdentitypic() {
        return identitypic;
    }

    public void setIdentitypic(String identitypic) {
        this.identitypic = identitypic;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

    public String getBusinesspic() {
        return businesspic;
    }

    public void setBusinesspic(String businesspic) {
        this.businesspic = businesspic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "XcCompany{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", intro='" + intro + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", linkname='" + linkname + '\'' +
                ", identitypic='" + identitypic + '\'' +
                ", worktype='" + worktype + '\'' +
                ", businesspic='" + businesspic + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
