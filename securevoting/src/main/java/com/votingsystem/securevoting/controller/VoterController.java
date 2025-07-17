package com.votingsystem.securevoting.controller;

import com.votingsystem.securevoting.model.Voter;
import com.votingsystem.securevoting.service.VoterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @GetMapping
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }

    @PostMapping
    public Voter saveVoter(@RequestBody Voter voter) {
        return voterService.saveVoter(voter);
    }
}
