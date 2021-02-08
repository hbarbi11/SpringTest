package com.springtest.springtest.service;

import com.springtest.springtest.entity.SuperHero;
import com.springtest.springtest.entity.Team;
import com.springtest.springtest.exception.ValidationException;
import com.springtest.springtest.repository.SuperHeroRepository;
import com.springtest.springtest.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository TeamRepository;

    @Autowired
    public TeamService(com.springtest.springtest.repository.TeamRepository teamRepository) {
        TeamRepository = teamRepository;
    }

    public Team createTeam (Team team) {
        return TeamRepository.save(team);
    }

    public List<Team> findAllTeam (Team team) {
        return TeamRepository.findAll();
    }

    public Team findTeamById (String id) throws ValidationException {
        return TeamRepository.findById(id).orElseThrow(() -> new ValidationException("No such an element with this ID"))
    }

    public Team modifyTeam (Team team) throws ValidationException {
        Team teamModified = findTeamById(team.getId());

        return TeamRepository.save(teamModified);
    }
}
