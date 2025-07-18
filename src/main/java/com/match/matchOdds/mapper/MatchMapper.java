package com.match.matchOdds.mapper;

import com.match.matchOdds.dto.response.MatchResponse;
import com.match.matchOdds.model.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface MatchMapper {

    MatchResponse entityToResponse(Match match);


    List<MatchResponse> entityToResponseList(List<Match> allMatches);
}
