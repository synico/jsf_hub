package com.nick.repository;

import com.nick.domain.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, String> {

    List<Attribute> findByName(String name);

    @Query("select a from Attribute a join a.attrDescSet attrDesc where attrDesc.name like %?1%")
    List<Attribute> findByAttrDesc(String descName);

}
