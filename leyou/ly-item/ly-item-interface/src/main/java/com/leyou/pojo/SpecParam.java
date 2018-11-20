package com.leyou.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_spec_param")
public class SpecParam implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long groupId;
    private Long cid;
    private String name;
    @Column(name = " 'numeric' ")
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSegments(String segments) {
        this.segments = segments;
    }

    public void setSearching(Boolean searching) {
        this.searching = searching;
    }

    public void setNumeric(Boolean numeric) {
        this.numeric = numeric;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setGeneric(Boolean generic) {
        this.generic = generic;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCid() {
        return cid;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public String getSegments() {
        return segments;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Boolean getGeneric() {
        return generic;
    }

    public Boolean getNumeric() {
        return numeric;
    }

    public Boolean getSearching() {
        return searching;
    }
}
