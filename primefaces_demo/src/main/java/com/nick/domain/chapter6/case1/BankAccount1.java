package com.nick.domain.chapter6.case1;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "bank_account_c1")
public class BankAccount1 extends BillingDetails1 {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @NotNull
    @Column(name = "account")
    protected String account;

    @NotNull
    @Column(name = "bank_name")
    protected String bankName;

    @NotNull
    @Column(name = "swift")
    protected String swift;

}
