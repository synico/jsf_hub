package com.nick.domain.chapter6;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "credit_card")
@AttributeOverride(
    name = "owner",
    column = @Column(name = "cc_owner", nullable = false)
)
public class CreditCard extends BillingDetails {

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
