package com.mongs.collection.repository;

import com.mongs.collection.entity.MapCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapCollectionRepository extends JpaRepository<MapCollection, Long> {
    List<MapCollection> findByMemberId(Long memberId);
    void deleteByMemberIdAndCode(Long memberId, String code);
}
