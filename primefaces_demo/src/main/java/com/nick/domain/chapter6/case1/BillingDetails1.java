package com.nick.domain.chapter6.case1;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class BillingDetails1 {

    @NotNull
    protected String owner;
}
