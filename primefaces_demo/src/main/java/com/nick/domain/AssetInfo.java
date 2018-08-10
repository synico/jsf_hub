package com.nick.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset_info")
@Getter
public class AssetInfo {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "depart_num")
    private String departNum;

    public String toString() {
        return "uid: " + uid + ", name: " + name + ", departNum: " + departNum;
    }

}
