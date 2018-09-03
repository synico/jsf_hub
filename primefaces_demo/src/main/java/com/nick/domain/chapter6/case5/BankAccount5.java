package com.nick.domain.chapter6.case5;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "bank_account_c5")
@DiscriminatorValue("BA")
public class BankAccount5 extends BillingDetails5 {

    @NotNull
    protected String account;

    @NotNull
    protected String bankName;

    @NotNull
    protected String swift;

}
