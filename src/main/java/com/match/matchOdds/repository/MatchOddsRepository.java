package com.match.matchOdds.repository;

import com.match.matchOdds.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {
    @Query("SELECT mo FROM MatchOdds mo WHERE mo.match.id = :matchId")
    List<MatchOdds> findByMatchId(Long matchId);
}
