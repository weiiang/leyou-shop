package com.leyou.user.entity.ext;


import com.leyou.user.entity.XcMenu;

import java.util.List;

public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;

    public List<CategoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "XcMenuExt{" +
                "children=" + children +
                '}';
    }
}
