package com.upod.upodhotel.controllers;

import com.upod.upodhotel.entities.Feature;
import com.upod.upodhotel.services.FeatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/features")
public class FeatureController {
    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public List<Feature> getAllFeatures(@RequestParam Optional<Long> roomId) {
        return featureService.getAllFeatures(roomId);
    }

    @PostMapping
    public Feature createFeature(@RequestBody Feature newFeature) {
        return featureService.saveFeature(newFeature);
    }

    @GetMapping("/{featureId}")
    public Feature getFeatureById(@PathVariable Long featureId) {
        return featureService.getFeatureById(featureId);
    }

    @PutMapping("/{featureId}")
    public Feature updateFeature(@PathVariable Long featureId, @RequestBody Feature updatedFeature) {
        return featureService.updateFeature(featureId, updatedFeature);
    }

    @DeleteMapping("/{featureId}")
    public void deleteFeature(@PathVariable Long featureId) {
        featureService.deleteFeature(featureId);
    }
}
