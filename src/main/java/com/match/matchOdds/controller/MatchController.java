package com.match.matchOdds.controller;

import com.match.matchOdds.dto.response.MatchResponse;
import com.match.matchOdds.mapper.MatchMapperImpl;
import com.match.matchOdds.model.Match;
import com.match.matchOdds.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchService matchService;
    private final MatchMapperImpl matchMapper;

    @Autowired
    public MatchController(MatchService matchService, MatchMapperImpl matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponse> getMatchById(@PathVariable Long id) {
        return ResponseEntity.ok(matchMapper.entityToResponse(matchService.getMatchById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<MatchResponse> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchMapper.entityToResponse(matchService.createMatch(match)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MatchResponse> updateMatch(@PathVariable Long id, @RequestBody Match matchDetails) {
        return ResponseEntity.ok(matchMapper.entityToResponse(matchService.updateMatch(id, matchDetails)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
