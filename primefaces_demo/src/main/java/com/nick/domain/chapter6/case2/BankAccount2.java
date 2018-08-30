package com.nick.domain.chapter6.case2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "bank_account_c2")
public class BankAccount2 extends BillingDetails2 {

    @NotNull
    private String account;

    @NotNull
    private String bankName;

    @NotNull
    private String swift;

}
