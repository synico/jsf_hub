package com.nick.repository;

import com.nick.domain.AttrDesc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttrDescRepository extends JpaRepository<AttrDesc, String> {

    List<AttrDesc> findByName(String name);

}
