package com.nick.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "attributeUid")
    private Set<AttrDesc> attrDescSet;

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

}
