package com.nick.domain.chapter6;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BillingDetails {

    @NotNull
    protected String owner;
}
