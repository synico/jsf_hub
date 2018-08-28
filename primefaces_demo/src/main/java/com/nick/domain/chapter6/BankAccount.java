package com.nick.domain.chapter6;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetails {

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
