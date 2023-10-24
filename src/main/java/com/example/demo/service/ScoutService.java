package com.example.demo.service;

import com.example.demo.model.Scout;
import com.example.demo.repository.ScoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoutService {

    @Autowired
    private ScoutRepository scoutRepository;

    public List<Scout> getAllScouts() {
        return scoutRepository.findAll();
    }

    public Scout getScoutById(Long id) {
        Optional<Scout> scoutOptional = scoutRepository.findById(id);
        if (scoutOptional.isPresent()) {
            return scoutOptional.get();
        }
        return null;
    }

    public Scout createScout(Scout scout) {
        return scoutRepository.save(scout);
    }

    public Scout updateScout(Long id, Scout scout) {
        if (scoutRepository.existsById(id)) {
            scout.setId(id);
            return scoutRepository.save(scout);
        }
        return null;
    }

    public void deleteScout(Long id) {
        scoutRepository.deleteById(id);
    }
}
