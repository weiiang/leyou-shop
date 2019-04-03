package com.leyou.user.entity.ext;


import com.leyou.user.entity.Category;

import java.util.List;


public class CategoryNode extends Category {

    List<CategoryNode> children;

    public List<CategoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CategoryNode{" +
                "children=" + children +
                '}';
    }
}
