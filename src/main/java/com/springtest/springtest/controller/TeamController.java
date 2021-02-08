package com.springtest.springtest.controller;

import com.springtest.springtest.entity.SuperHero;
import com.springtest.springtest.entity.Team;
import com.springtest.springtest.exception.ValidationException;
import com.springtest.springtest.service.SuperHeroService;
import com.springtest.springtest.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/teams ")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teamsave")
    public Team save (@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/team/{id}")
    public Team findById (@PathVariable("id") String id) {
        try {
            return TeamService.findTeamById(id);
        } catch (ValidationException e) {
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }


}
