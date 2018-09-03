package com.nick.domain.chapter6.case5;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorValue("CC")
@SecondaryTable(
    name = "credit_card_c5",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "credit_card_id")
)
public class CreditCard5 extends BillingDetails5 {

    @NotNull
    @Column(table = "credit_card_c5", nullable = false)
    protected String cardNumber;

    @Column(table = "credit_card_c5", nullable = false)
    protected String expMonth;

    @Column(table = "credit_card_c5", nullable = false)
    protected String expYear;

}
