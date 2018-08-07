package com.nick.repositories;

import com.nick.domain.AssetInfo;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AssetInfoRepositories extends Repository<AssetInfo, String> {

    List<AssetInfo> findByName(String name);
}
