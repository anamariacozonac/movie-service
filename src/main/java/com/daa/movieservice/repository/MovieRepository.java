package com.daa.movieservice.repository;

import com.daa.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM t_movies m " +
            "ORDER BY m.budget LIMIT :limit", nativeQuery = true)
    List<Movie> getTop(@Param("limit") Integer limit);

}
