package com.rai.crimemanagementsystem.service;

import com.rai.crimemanagementsystem.entity.Crime;
import com.rai.crimemanagementsystem.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public List<Crime> getAllCrime() {
        return crimeRepository.findAll();
    }

    public void addCrime(Crime crime) {
        crimeRepository.save(crime);
    }

    public Crime getCrimeById(Long id) {
        return crimeRepository.findById(id).orElse(null);
    }

    public boolean deleteCrime(Long id) {
        if (!crimeRepository.existsById(id)) {
            return false;
        }
        crimeRepository.deleteById(id);
        return true;
    }

    //  service also need to have some of the change to test
}
