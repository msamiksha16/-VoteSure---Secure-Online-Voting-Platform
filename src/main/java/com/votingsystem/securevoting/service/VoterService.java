package com.votingsystem.securevoting.service;

import com.votingsystem.securevoting.model.Voter;
import com.votingsystem.securevoting.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {
    private final VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public Voter saveVoter(Voter voter) {
        return voterRepository.save(voter);
    }
}
