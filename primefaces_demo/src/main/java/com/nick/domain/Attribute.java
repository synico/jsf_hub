package com.nick.domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "attribute")
public class Attribute implements Serializable {

    @Id
    @Column(name = "attribute_uid", nullable = false)
    private String attributeUid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @CreatedBy
    @Column(name = "create_by", nullable = false)
    private String createBy;

    @CreatedDate
    @Column(name = "create_date")
    private Date createDate;

    @LastModifiedBy
    @Column(name = "update_by", nullable = false)
    private String updateBy;

    @LastModifiedDate
    @Column(name = "update_date")
    private Date updateDate;

    public Attribute() {
    }

    public Attribute(String name, String createBy, String updateBy) {
        this.name = name;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    @PrePersist
    public void prePersistAction() {
        if(StringUtils.isBlank(this.attributeUid)) {
            this.attributeUid = UUID.randomUUID().toString().replaceAll("-", "");
        }
        if(createDate == null) {
            createDate = new Date();
        }
        updateDate = new Date();
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
