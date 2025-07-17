package com.match.matchOdds.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "match_odds")
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;


    @JsonGetter("match_id")
    public Long getMatchId() {
       return match.getId();
    }

    @Column(nullable = false)
    @JsonProperty("odd")
    private Double odd;

    @Column(nullable = false)
    @JsonProperty("specifier")
    private String specifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }
    public Double getOdd() {
        return odd;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public String getSpecifier() {
        return specifier;
    }

}
