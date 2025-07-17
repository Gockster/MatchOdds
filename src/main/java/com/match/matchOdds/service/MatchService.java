package com.match.matchOdds.service;

import com.match.matchOdds.exception.ResourceNotFoundException;
import com.match.matchOdds.model.Match;
import com.match.matchOdds.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id: " + id));
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match matchDetails) {
        Match match = getMatchById(id);
        match.setDescription(matchDetails.getDescription());
        match.setMatchDate(matchDetails.getMatchDate());
        match.setMatchTime(matchDetails.getMatchTime());
        match.setTeamA(matchDetails.getTeamA());
        match.setTeamB(matchDetails.getTeamB());
        match.setSport(matchDetails.getSport());
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        Match match = getMatchById(id);
        matchRepository.delete(match);
    }

}
