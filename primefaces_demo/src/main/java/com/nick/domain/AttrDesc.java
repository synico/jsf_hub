package com.nick.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "attr_desc")
public class AttrDesc implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name="id", columnDefinition = "CHAR(32)")
    private String id;

    //mappedto attribute.id
    @Column(name = "attribute_id", columnDefinition = "CHAR(32)", nullable = false)
    private String attributeId;

    @Column(name = "name", columnDefinition = "VARCHAR(64)", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(255)")
    private String description;

    @Column(name = "required", nullable = false)
    private Boolean required;

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Attribute attribute;

}
