package com.nick.domain.chapter6.case4;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "billing_details_c4")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails4 {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @NotNull
    protected String owner;
    
}
