package com.nick.service;

import com.nick.domain.chapter6.case1.BankAccount1;
import com.nick.domain.chapter6.case1.CreditCard1;
import com.nick.domain.chapter6.case2.BankAccount2;
import com.nick.domain.chapter6.case2.BillingDetails2;
import com.nick.domain.chapter6.case2.CreditCard2;
import com.nick.repository.chapter6.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingInheritanceServce {

    public void c6case1(String idx) {
        BankAccount1 ba = new BankAccount1();
        ba.setAccount("account_" + idx);
        ba.setBankName("ICBC");
        ba.setSwift("swift_" + idx);
        ba.setOwner("owner_" + idx);
        bankAccountRepository1.save(ba);

        CreditCard1 cc = new CreditCard1();
        cc.setOwner(ba.getOwner());
        cc.setCardNumber("620123456_" + idx);
        cc.setExpYear("2023");
        cc.setExpMonth("12");
        creditCardRepository1.save(cc);
    }

    public void c6case2(String idx) {
        BankAccount2 ba = new BankAccount2();
        ba.setAccount("account_" + idx);
        ba.setBankName("ICBC");
        ba.setSwift("swift_" + idx);
        ba.setOwner("owner_" + idx);
        bankAccountRepository2.save(ba);

        CreditCard2 cc = new CreditCard2();
        cc.setOwner(ba.getOwner());
        cc.setCardNumber("620123456_" + idx);
        cc.setExpMonth("12");
        cc.setExpYear("2023");
        creditCardRepository2.save(cc);
    }

    public void c6case2Find() {
        List<BillingDetails2> list2 = billingDetailsRepository2.findAll();
        list2.stream().forEach(System.out::println);
    }

    @Autowired
    private BankAccountRepository1 bankAccountRepository1;

    @Autowired
    private CreditCardRepository1 creditCardRepository1;

    @Autowired
    private BankAccountRepository2 bankAccountRepository2;

    @Autowired
    private CreditCardRepository2 creditCardRepository2;

    @Autowired
    private BillingDetailsRepository2 billingDetailsRepository2;
}
