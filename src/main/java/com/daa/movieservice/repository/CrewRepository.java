package com.daa.movieservice.repository;

import com.daa.movieservice.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
    List<Crew> getCrewByMovieId(Long id);
    List<Crew> getCrewByPersonId(Long id);
}
