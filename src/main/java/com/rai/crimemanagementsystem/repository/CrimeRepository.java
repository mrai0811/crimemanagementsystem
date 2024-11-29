package com.rai.crimemanagementsystem.repository;

import com.rai.crimemanagementsystem.entity.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
