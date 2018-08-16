package com.nick.repository;

import com.nick.domain.AttrValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttrValueRepository extends JpaRepository<AttrValue, String> {

    List<AttrValue> findByValue(String value);

}
