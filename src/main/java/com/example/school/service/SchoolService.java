package com.example.school.service;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School school) {
        return schoolRepository.save(school);
    }

    public School fetchSchoolById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public List<School> fetchSchools() {
        return schoolRepository.findAll();
    }

}
