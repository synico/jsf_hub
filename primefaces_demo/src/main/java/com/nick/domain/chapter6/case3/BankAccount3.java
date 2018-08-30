package com.nick.domain.chapter6.case3;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorValue("BA")
public class BankAccount3 extends BillingDetails3 {

    @NotNull
    private String account;

    @NotNull
    private String bankName;

    @NotNull
    private String swift;

}
