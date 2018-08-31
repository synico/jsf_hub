package com.nick.domain.chapter6.case4;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "credit_card_c4")
@PrimaryKeyJoinColumn(name = "credit_card_id")
public class CreditCard4 extends BillingDetails4 {

    @NotNull
    protected String cardNumber;

    @NotNull
    protected String expMonth;

    @NotNull
    protected String expYear;

}
