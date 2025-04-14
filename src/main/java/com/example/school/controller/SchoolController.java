package com.example.school.controller;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import com.example.school.service.SchoolService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/")
    public ResponseEntity<List<School>> fetchAllSchools() {
        return ResponseEntity.ok(schoolService.fetchSchools());
    }

    @PostMapping("/")
    public ResponseEntity<School> addSchool(@Valid @RequestBody School school) {
        School createdSchool = schoolService.addSchool(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> fetchSchoolById(@PathVariable Long id) {
        return ResponseEntity.ok(schoolService.fetchSchoolById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> editSchoolById(@PathVariable Long id, @Valid @RequestBody School school){
        School existingSchool = schoolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("School Not Found"));


        existingSchool.setName(school.getName());
        existingSchool.setLocation(school.getLocation());
        existingSchool.setPrincipalName(school.getPrincipalName());

        School updatedSchool = schoolRepository.save(existingSchool);
        return ResponseEntity.ok(updatedSchool);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchoolById(@PathVariable Long id) {
        schoolRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
