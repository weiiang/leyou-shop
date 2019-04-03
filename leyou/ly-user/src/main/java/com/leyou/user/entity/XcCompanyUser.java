package com.leyou.user.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author admin
 */
@Entity
@Table(name="xc_company_user")
public class XcCompanyUser implements Serializable {
    private static final long serialVersionUID = -916357110051689786L;
    @Id
    @Column(length = 32)
    private String id;
    @Column(name="company_id")
    private String companyId;
    @Column(name="user_id")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "XcCompanyUser{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
