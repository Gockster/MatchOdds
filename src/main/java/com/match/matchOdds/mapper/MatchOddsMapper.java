package com.match.matchOdds.mapper;
import com.match.matchOdds.dto.request.MatchOddsRequest;
import com.match.matchOdds.dto.response.MatchOddsResponse;
import com.match.matchOdds.model.MatchOdds;
import org.mapstruct.Mapper;

import java.util.List;


public interface MatchOddsMapper {
    MatchOdds requestToEntity(MatchOddsRequest request);

    MatchOddsResponse entityToOddResponse(MatchOdds matchOdds);

    List<MatchOddsResponse> entityToResponseList(List<MatchOdds> allMatchOdds);
}
