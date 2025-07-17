package com.match.matchOdds.controller;

import com.match.matchOdds.dto.request.MatchOddsRequest;
import com.match.matchOdds.dto.response.MatchOddsResponse;
import com.match.matchOdds.mapper.MatchOddsMapper;
import com.match.matchOdds.model.Match;
import com.match.matchOdds.model.MatchOdds;
import com.match.matchOdds.service.MatchOddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/odds")
public class MatchOddsController {
    private final MatchOddsService matchOddsService;

    private final MatchOddsMapper matchOddsMapper;

    @Autowired
    public MatchOddsController(MatchOddsService matchOddsService, MatchOddsMapper matchOddMapper) {
        this.matchOddsService = matchOddsService;
        this.matchOddsMapper = matchOddMapper;
    }

    @GetMapping("/match/{matchId}")
    public ResponseEntity<List<MatchOdds>> getMatchOddsForMatch(@PathVariable Long matchId) {
        return ResponseEntity.ok(matchOddsService.getOddsByMatchId(matchId));
    }

    @GetMapping
    public ResponseEntity<List<MatchOddsResponse>> getAllMatchOdds() {
        return ResponseEntity.ok(matchOddsMapper.entityToResponseList(matchOddsService.getAllMatchOdds()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<MatchOdds> getMatchOddsById(@PathVariable Long id) {
        return ResponseEntity.ok(matchOddsService.getMatchOddsById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<MatchOddsResponse> createMatchOdds(@RequestBody MatchOddsRequest request) {
        return ResponseEntity.ok(
                matchOddsMapper.entityToOddResponse(
                        matchOddsService.createMatchOdds(
                                matchOddsMapper.requestToEntity(request)
                        )
                )
        );
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MatchOddsResponse> updateMatchOdds(@PathVariable Long id, @RequestBody MatchOddsRequest request) {
        return ResponseEntity.ok(
                matchOddsMapper.entityToOddResponse(
                        matchOddsService.updateMatchOdds(
                                id,
                                matchOddsMapper.requestToEntity(request)
                        )
                )
        );
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMatchOdds(@PathVariable Long id) {
        matchOddsService.deleteMatchOdds(id);
        return ResponseEntity.noContent().build();
    }
}
