package com.nick.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shared_asset_type")
@Data
public class SharedAssetType {

    @Id
    @Column(name = "id",columnDefinition = "CHAR(32)")
    private String id;

    @Column(name = "swap_name")
    private String swapName;

    @Column(name = "charging_type")
    private String chargingType;

    @Column(name = "unit_price")
    private Double unitPrice;

}
