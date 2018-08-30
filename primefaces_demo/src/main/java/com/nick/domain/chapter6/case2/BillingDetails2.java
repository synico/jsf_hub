package com.nick.domain.chapter6.case2;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetails2 {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected  Long id;

    @NotNull
    protected String owner;
}
