package com.leyou.user.entity.ext;


import com.leyou.user.entity.XcMenu;
import com.leyou.user.entity.XcUser;

import java.util.List;

public class XcUserExt extends XcUser {

    //权限信息
    private List<XcMenu> permissions;

    //企业信息
    private String companyId;


    public List<XcMenu> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<XcMenu> permissions) {
        this.permissions = permissions;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "XcUserExt{" +
                "permissions=" + permissions +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
