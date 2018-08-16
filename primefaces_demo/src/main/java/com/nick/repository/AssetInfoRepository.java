package com.nick.repository;

import com.nick.domain.AssetInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssetInfoRepository extends CrudRepository<AssetInfo, Integer> {

    List<AssetInfo> findByName(String name);
}
