package ru.yandex.practicum.filmorate.validators;

import ru.yandex.practicum.filmorate.validators.annotations.CorrectFilmDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FilmDateValidator implements ConstraintValidator<CorrectFilmDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate.isAfter(LocalDate.of(1895, 12, 28));
    }
}
