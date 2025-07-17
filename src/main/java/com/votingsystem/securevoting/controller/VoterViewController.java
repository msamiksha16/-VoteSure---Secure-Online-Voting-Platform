package com.votingsystem.securevoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpSession;
import com.votingsystem.securevoting.model.Voter;
import com.votingsystem.securevoting.repository.VoterRepository;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Controller
public class VoterViewController {

    @Autowired
    private VoterRepository repo;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("voter", new Voter());
        return "register";
    }
    @PostMapping("/register")
    public String registerVoter(@ModelAttribute Voter voter, Model model) {
        String password = voter.getPassword();

        // Regex to enforce strong password
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            model.addAttribute("error", "Password must be at least 8 characters and include uppercase, lowercase, number, and special character.");
            return "register"; // 👈 returns to the same page with error
        }

        repo.save(voter); // Save only if valid
        return "redirect:/register/success"; // success.html
    }

    @PostMapping("/voters/register")
    public String register(@ModelAttribute Voter voter, Model model) {
        repo.save(voter);
        model.addAttribute("message", "Registration successful!");
        return "redirect:/register/success";
    }
    @GetMapping("/register/success")
    public String showSuccess() {
        return "success";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("voter", new Voter());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Voter voter, HttpSession session, Model model) {
        Voter found = repo.findByEmailAndPassword(voter.getEmail(), voter.getPassword());
        if (found != null) {
            session.setAttribute("voterId", found.getId());
            return "redirect:/vote";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    @GetMapping("/vote")
    public String showVotePage(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("voterId");
        if (id == null) return "redirect:/login";

        Voter voter = repo.findById(id).orElse(null);
        if (voter == null || voter.isHasVoted()) {
            return "alreadyVoted";
        }

        model.addAttribute("voter", voter);
        return "vote";
    }

    @PostMapping("/vote")
    public String castVote(HttpSession session, @RequestParam("choice") String choice) {
        Long id = (Long) session.getAttribute("voterId");
        if (id == null) return "redirect:/login";

        Voter voter = repo.findById(id).orElse(null);
        if (voter == null || voter.isHasVoted()) {
            return "alreadyVoted";
        }

        voter.setHasVoted(true);
        repo.save(voter);

        return "voteSuccess";
    }
}
