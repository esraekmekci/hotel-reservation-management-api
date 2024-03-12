package com.upod.upodhotel.dao;

import com.upod.upodhotel.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    @Query("SELECT f FROM Room r JOIN r.features f WHERE r.id = :roomId")
    List<Feature> findAllByRoomId(Long roomId);
}
