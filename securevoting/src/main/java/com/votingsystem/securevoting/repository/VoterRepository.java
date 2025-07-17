package com.votingsystem.securevoting.repository;

import com.votingsystem.securevoting.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
    Voter findByEmailAndPassword(String email, String password);
}
