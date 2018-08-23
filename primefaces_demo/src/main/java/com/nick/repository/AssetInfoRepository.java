package com.nick.repository;

import com.nick.domain.AssetInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssetInfoRepository extends PagingAndSortingRepository<AssetInfo, Integer> {

    List<AssetInfo> findByName(String name);

//    @Query("select new com.nick.domain.AssetInfo(id, uid, name, departNum) from AssetInfo a, SharedAssetType b where a.sharedAssetType=b.id and b.swapName like %:swapname%")
    @Query(value = "select a.id, a.uid, a.name, a.depart_num from asset_info a join shared_asset_type b on a.shared_asset_type=b.id where b.swap_name like %:name%", nativeQuery = true)
    List<AssetInfo> findBySwapName(@Param("name") String name);
}
