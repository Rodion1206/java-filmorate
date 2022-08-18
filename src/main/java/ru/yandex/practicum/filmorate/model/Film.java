package ru.yandex.practicum.filmorate.model;


import lombok.Data;
import ru.yandex.practicum.filmorate.validators.annotations.CorrectFilmDate;

import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
public class Film {
    private int id;

    @NotEmpty(message = "Name can't be empty")
    @NotBlank(message = "Name can't be blank")
    @NotNull(message = "Name can't be null")
    private String name;

    @Size(max = 200, message = "can't be more than 200 symbols")
    private String description;

    @CorrectFilmDate(message = "Release date should be after 28.12.1895")
    private LocalDate releaseDate;

    @Positive(message = "Duration in seconds should be positive")
    private Long duration;
}
