package com.nick.domain;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "attr_desc")
public class AttrDesc implements Serializable {

    @Id
    @Column(name = "attr_desc_uid", nullable = false)
    private String attrDescUid;

    //mappedto attribute.attribute_uid
    @Column(name = "attribute_uid", nullable = false)
    private String attributeUid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "required", nullable = false)
    private Boolean required;

    public AttrDesc(String attributeUid, String name, Boolean required) {
        this.attributeUid = attributeUid;
        this.name = name;
        this.required = required;
    }

    @PrePersist
    public void initializeUid() {
        if(StringUtils.isBlank(this.attrDescUid)) {
            this.attrDescUid = UUID.randomUUID().toString().replace("-", "");
        }
    }

    public String getAttrDescUid() {
        return attrDescUid;
    }

    public void setAttrDescUid(String attrDescUid) {
        this.attrDescUid = attrDescUid;
    }

    public String getAttributeUid() {
        return attributeUid;
    }

    public void setAttributeUid(String attributeUid) {
        this.attributeUid = attributeUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

}
