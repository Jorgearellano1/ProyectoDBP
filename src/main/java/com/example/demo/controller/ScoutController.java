package com.example.demo.controller;

import com.example.demo.model.Scout;
import com.example.demo.service.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scouts")
public class ScoutController {

    @Autowired
    private ScoutService scoutService;

    @GetMapping
    public List<Scout> getAllScouts() {
        return scoutService.getAllScouts();
    }

    @GetMapping("/{id}")
    public Scout getScoutById(@PathVariable Long id) {
        return scoutService.getScoutById(id);
    }

    @PostMapping
    public Scout createScout(@RequestBody Scout scout) {
        return scoutService.createScout(scout);
    }

    @PutMapping("/{id}")
    public Scout updateScout(@PathVariable Long id, @RequestBody Scout scout) {
        return scoutService.updateScout(id, scout);
    }

    @DeleteMapping("/{id}")
    public void deleteScout(@PathVariable Long id) {
        scoutService.deleteScout(id);
    }
}
