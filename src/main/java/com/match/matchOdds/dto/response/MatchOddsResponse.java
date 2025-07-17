package com.match.matchOdds.dto.response;

public record MatchOddsResponse(

        Long id,

        Double odd,

        Long matchId,
        String specifier

) {}
