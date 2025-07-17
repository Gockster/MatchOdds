package com.match.matchOdds.dto.request;

import org.antlr.v4.runtime.misc.NotNull;

public record MatchOddsRequest(
        @NotNull
        Long matchId,

        @NotNull
        Double odd,

        @NotNull
        String specifier
) {}


