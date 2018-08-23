package com.nick.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "asset_info")
@Data
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
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "asset_info_id", referencedColumnName = "uid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<SharedAssetReqDetail> sharedAssetReqDetailSet;

    public Set<SharedAssetReqDetail> getSharedAssetReqDetailSet() {
        return sharedAssetReqDetailSet;
    }

    public void setSharedAssetReqDetailSet(Set<SharedAssetReqDetail> sharedAssetReqDetailSet) {
        this.sharedAssetReqDetailSet = sharedAssetReqDetailSet;
    }

    public String toString() {
        sharedAssetReqDetailSet.forEach(System.out::println);
        return "uid: " + uid
                + ", name: " + name
                + ", departNum: " + departNum;
    }

}
