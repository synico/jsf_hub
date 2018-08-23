package com.nick.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shared_asset_req_detail")
@Data
public class SharedAssetReqDetail {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "asset_info_id")
    private String assetInfoId;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_number")
    private String assetNumber;

    public String toString() {
        return "id: " + id +
                ", asset_info_id: " + assetInfoId +
                ", asset_name: " + this.assetName +
                ", asset_number: " + this.assetNumber;
    }

}
