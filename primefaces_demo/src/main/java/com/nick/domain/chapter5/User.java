package com.nick.domain.chapter5;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hia_users")
public class User {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    @Column(name = "first_name", columnDefinition = "CHAR(32)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "CHAR(32")
    private String lastName;

    protected Address homeAddress;

}
