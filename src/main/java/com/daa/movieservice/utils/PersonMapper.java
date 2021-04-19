package com.daa.movieservice.utils;

import com.daa.movieservice.api.dto.PersonDto;
import com.daa.movieservice.model.Country;
import com.daa.movieservice.model.Person;
import lombok.NoArgsConstructor;

import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
public class PersonMapper {
    public static final Function<Person, PersonDto> mapPersonToPersonDto = person -> PersonDto.builder()
            .firstName(person.getFirstName())
            .lastName(person.getLastName())
            .gender(person.getGender())
            .biography(person.getBiography())
            .personHeight(person.getPersonHeight())
            .photo(person.getEncodedPhoto())
            .birthPlace(person.getBirthPlace())
            .birthDate(person.getBirthDate())
            .deathDate(person.getDeathDate())
            .placeOfDeath(person.getPlaceOfDeath())
            .countries(person.getCountries().stream().map(Country::getCountryName).collect(Collectors.toSet()))
            .build();
}
