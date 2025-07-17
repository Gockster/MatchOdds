package com.match.matchOdds.mapper;
import com.match.matchOdds.dto.request.MatchOddsRequest;
import com.match.matchOdds.dto.response.MatchOddsResponse;
import com.match.matchOdds.model.Match;
import com.match.matchOdds.model.MatchOdds;
import com.match.matchOdds.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatchOddMapperImpl implements MatchOddsMapper {
    private final MatchService matchService;

    @Autowired
    public MatchOddMapperImpl(MatchService matchService) {
        this.matchService = matchService;
    }

    @Override
    public MatchOdds requestToEntity(MatchOddsRequest request) {
        Match match = matchService.getMatchById(request.matchId());
        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setOdd(request.odd());
        matchOdds.setSpecifier(request.specifier());
        matchOdds.setMatch(match);
        return matchOdds;
    }

    public MatchOddsResponse entityToOddResponse(MatchOdds matchOdds) {
        return new MatchOddsResponse(
                matchOdds.getId(),
                matchOdds.getOdd(),
                matchOdds.getMatch().getId(),
                matchOdds.getSpecifier()
        );
    }
    @Override
    public List<MatchOddsResponse> entityToResponseList(List<MatchOdds> allMatchOdds) {
        return allMatchOdds.stream()
                .map(this::entityToOddResponse)
                .collect(Collectors.toList());
    }

}
