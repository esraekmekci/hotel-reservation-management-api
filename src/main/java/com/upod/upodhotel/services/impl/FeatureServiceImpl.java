package com.upod.upodhotel.services.impl;

import com.upod.upodhotel.dao.FeatureRepository;
import com.upod.upodhotel.entities.Feature;
import com.upod.upodhotel.services.FeatureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public List<Feature> getAllFeatures(Optional<Long> roomId) {
        if (roomId.isEmpty()) {
            return featureRepository.findAll();
        }
        return featureRepository.findAllByRoomId(roomId.orElse(null));
    }

    @Override
    public Feature saveFeature(Feature newFeature) {
        return featureRepository.save(newFeature);
    }

    @Override
    public Feature getFeatureById(Long featureId) {
        return featureRepository.findById(featureId).orElse(null);
    }

    @Override
    public Feature updateFeature(Long featureId, Feature updatedFeature) {
        Optional<Feature> feature = featureRepository.findById(featureId);
        if (feature.isPresent()) {
            Feature foundFeature = feature.get();
            foundFeature.setName(updatedFeature.getName());
            featureRepository.save(foundFeature);
            return foundFeature;
        } else {
            return null;
        }
    }

    @Override
    public void deleteFeature(Long featureId) {
        featureRepository.deleteById(featureId);
    }
}
