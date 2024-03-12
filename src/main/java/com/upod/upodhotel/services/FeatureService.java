package com.upod.upodhotel.services;

import com.upod.upodhotel.entities.Feature;

import java.util.List;
import java.util.Optional;

public interface FeatureService {
    List<Feature> getAllFeatures(Optional<Long> roomId);

    Feature saveFeature(Feature newFeature);

    Feature getFeatureById(Long featureId);

    Feature updateFeature(Long featureId, Feature updatedFeature);

    void deleteFeature(Long featureId);
}
