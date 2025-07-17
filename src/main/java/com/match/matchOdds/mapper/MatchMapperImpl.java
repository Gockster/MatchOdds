package com.match.matchOdds.mapper;

import com.match.matchOdds.dto.response.MatchResponse;
import com.match.matchOdds.model.Match;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchMapperImpl implements MatchMapper {

    public MatchResponse entityToResponse(Match match) {
        return new MatchResponse(
                match.getDescription(),
                match.getMatchDate(),
                match.getMatchTime(),
                match.getTeamA(),
                match.getTeamB(),
                match.getSport().toString()
        );
    }

    @Override
    public List<MatchResponse> entityToResponseList(List<Match> allMatches) {
        return allMatches.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }
}
