package com.match.matchOdds.service;

import com.match.matchOdds.exception.ResourceNotFoundException;
import com.match.matchOdds.model.Match;
import com.match.matchOdds.model.MatchOdds;
import com.match.matchOdds.repository.MatchOddsRepository;
import com.match.matchOdds.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchRepository matchRepository;
    private final MatchService matchService;

    @Autowired
    public MatchOddsService(MatchOddsRepository matchOddsRepository, MatchRepository matchRepository, MatchService matchService) {
        this.matchOddsRepository = matchOddsRepository;
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }

    public List<MatchOdds> getOddsByMatchId(Long id) {
        return matchOddsRepository.findByMatchId(id);
    }

    public List<MatchOdds> getAllMatchOdds() {
        return matchOddsRepository.findAll();
    }

    public MatchOdds getMatchOddsById(Long id) {
        return matchOddsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MatchOdds not found with id: " + id));
    }

    public MatchOdds createMatchOdds(MatchOdds matchOdds) {
        if (matchOdds.getMatchId() == null) {
            throw new ResourceNotFoundException("Match ID cannot be null");
        }
        Match match = matchService.getMatchById(matchOdds.getMatchId());
        matchOdds.setMatch(match);
        return matchOddsRepository.save(matchOdds);
    }

    public MatchOdds updateMatchOdds(Long id, MatchOdds matchOddsDetails) {
        MatchOdds matchOdds = getMatchOddsById(id);
        Match match = matchRepository.findById(matchOddsDetails.getMatchId())
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id: " + matchOddsDetails.getMatchId()));

        matchOdds.setMatch(match);
        matchOdds.setOdd(matchOddsDetails.getOdd());
        matchOdds.setSpecifier(matchOddsDetails.getSpecifier());

        return matchOddsRepository.save(matchOdds);
    }


    public void deleteMatchOdds(Long id) {
        MatchOdds matchOdds = matchOddsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MatchOdds not found with id: " + id));
        matchOddsRepository.delete(matchOdds);
    }
}
