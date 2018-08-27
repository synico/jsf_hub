package com.nick.domain.chapter5;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
@Entity
@Table(name = "hia_address")
public class Address {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @NotNull
    @Column(name = "street", nullable = false)
    protected String street;

    @NotNull
    @Column(name = "zipcode", nullable = false, length = 5)
    protected String zipcode;

    @NotNull
    @Column(name = "city", nullable = false)
    protected String city;

    protected Address() {
    }

    public Address(String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }
}
