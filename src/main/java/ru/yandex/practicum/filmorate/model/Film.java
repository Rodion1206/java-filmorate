package ru.yandex.practicum.filmorate.model;


import lombok.Data;
import ru.yandex.practicum.filmorate.validators.annotations.CorrectFilmDate;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
public class Film {
    private int id;
    @NotEmpty
    @NotBlank
    private String name;
    @Size(max = 200)
    private String description;
    @CorrectFilmDate
    private LocalDate releaseDate;
    @Positive
    private Long duration;
}
