package com.match.matchOdds.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public record MatchResponse(
        String description,
        LocalDate matchDate,
        LocalTime matchTime,
        String teamA,
        String teamB,
        String sport
) {}
