package ru.yandex.practicum.filmorate.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exceptions.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/films")
@Slf4j
public class FilmController {

    private Map<Integer, Film> films = new HashMap<>();
    private static int filmId = 0;


    private int getFilmId(){
        return ++filmId;
    }

    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) {
        log.info("request to add film");
        film.setId(getFilmId());
        films.put(film.getId(), film);
        return film;
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) {
        log.info("request to update film");
        if (film.getId() == null) {
            film.setId(getFilmId());
        }
        if (films.containsKey(film.getId())) {
            films.put(film.getId(), film);
            return film;
        }
        throw new ValidationException(HttpStatus.NOT_FOUND, "film not found");
    }

    @GetMapping
    public List<Film> getAllFilms() {
        log.info("request for all films");
        List<Film> result = new ArrayList<>();
        for (Film f : films.values()) {
            result.add(f);
        }
        return result;
    }

}
