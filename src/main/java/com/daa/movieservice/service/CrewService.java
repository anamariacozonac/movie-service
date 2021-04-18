package com.daa.movieservice.service;

import com.daa.movieservice.api.dto.CrewDto;
import com.daa.movieservice.model.Crew;
import com.daa.movieservice.repository.CrewRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.daa.movieservice.utils.MovieMapper.mapCrewToCrewDto;

@Service
@RequiredArgsConstructor
public class CrewService {
    @Autowired
    private CrewRepository crewRepository;

    public List<CrewDto> getCrew(){
        return crewRepository.findAll()
                .stream()
                .map(mapCrewToCrewDto)
                .collect(Collectors.toList());
    }
    public List<CrewDto> getCrewByMovId(Long id) {
        List<Crew> crew = crewRepository.getCrewByMovieId(id);
        return crewRepository
                .getCrewByMovieId(id)
                .stream()
                .map(mapCrewToCrewDto)
                .collect(Collectors.toList());
    }
    public List<CrewDto> getCrewByPersonId(Long id) {
        return crewRepository
                .getCrewByPersonId(id)
                .stream()
                .map(mapCrewToCrewDto)
                .collect(Collectors.toList());
    }

}
