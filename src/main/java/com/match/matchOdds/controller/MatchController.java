package com.match.matchOdds.controller;

import com.match.matchOdds.dto.response.MatchResponse;
import com.match.matchOdds.mapper.MatchMapperImpl;
import com.match.matchOdds.model.Match;
import com.match.matchOdds.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match Controller", description = "Match management APIs")
public class MatchController {
    private final MatchService matchService;
    private final MatchMapperImpl matchMapper;

    @Autowired
    public MatchController(MatchService matchService, MatchMapperImpl matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }

    @Operation(summary = "Get all matches", description = "Retrieves a list of all matches")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved matches")
    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @Operation(summary = "Get match by ID", description = "Retrieves a specific match by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved match")
    @ApiResponse(responseCode = "404", description = "Match not found")
    @GetMapping("/{id}")
    public ResponseEntity<MatchResponse> getMatchById(@PathVariable Long id) {
        return ResponseEntity.ok(matchMapper.entityToResponse(matchService.getMatchById(id)));
    }

    @Operation(summary = "Create new match", description = "Creates a new match entry")
    @ApiResponse(responseCode = "200", description = "Match successfully created")
    @PostMapping("/create")
    public ResponseEntity<MatchResponse> createMatch(@RequestBody Match match) {
        return ResponseEntity.ok(matchMapper.entityToResponse(matchService.createMatch(match)));
    }

    @Operation(summary = "Update match", description = "Updates an existing match by ID")
    @ApiResponse(responseCode = "200", description = "Match successfully updated")
    @ApiResponse(responseCode = "404", description = "Match not found")
    @PutMapping("/update/{id}")
    public ResponseEntity<MatchResponse> updateMatch(@PathVariable Long id, @RequestBody Match matchDetails) {
        return ResponseEntity.ok(matchMapper.entityToResponse(matchService.updateMatch(id, matchDetails)));
    }

    @Operation(summary = "Delete match", description = "Deletes a match by ID")
    @ApiResponse(responseCode = "204", description = "Match successfully deleted")
    @ApiResponse(responseCode = "404", description = "Match not found")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
