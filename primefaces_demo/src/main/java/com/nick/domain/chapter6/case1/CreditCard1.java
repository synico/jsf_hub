package com.nick.domain.chapter6.case1;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "credit_card_c1")
@AttributeOverride(
    name = "owner",
    column = @Column(name = "cc_owner", nullable = false)
)
public class CreditCard1 extends BillingDetails1 {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @NotNull
    @Column(name = "card_number")
    protected String cardNumber;

    @NotNull
    @Column(name = "exp_month")
    protected String expMonth;

    @NotNull
    @Column(name = "exp_year")
    protected  String expYear;

}
