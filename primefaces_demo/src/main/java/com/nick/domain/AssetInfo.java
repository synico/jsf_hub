package com.nick.domain;

import com.nick.domain.com.nick.domain.SharedAssetReqDetail;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "asset_info")
@Getter
public class AssetInfo implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "name")
    private String name;

    @Column(name = "depart_num")
    private String departNum;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_info_id", referencedColumnName = "uid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<SharedAssetReqDetail> sharedAssetReqDetailSet;

    public String toString() {
        sharedAssetReqDetailSet.forEach(System.out::println);
        return "uid: " + uid
                + ", name: " + name
                + ", departNum: " + departNum;
    }

}
