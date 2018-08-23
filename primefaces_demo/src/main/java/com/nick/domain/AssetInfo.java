package com.nick.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "asset_info")
@Data
public class AssetInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    @Column(name = "id")
    private Long id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "depart_num")
    private String departNum;

//    @OneToMany(fetch = FetchType.LAZY)
//    @Fetch(value = FetchMode.JOIN)
//    @JoinColumn(name = "asset_info_id", referencedColumnName = "uid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Transient
    private Set<SharedAssetReqDetail> sharedAssetReqDetailSet;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "shared_asset_type")
    @Transient
    private SharedAssetType sharedAssetType;

    private AssetInfo() {}

    public AssetInfo(Long id, String uid, String name, String departNum) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.departNum = departNum;
    }

    public String toString() {
//        sharedAssetReqDetailSet.forEach(System.out::println);
        return "uid: " + uid
                + ", name: " + name
                + ", departNum: " + departNum;
    }

}
