package ru.yandex.practicum.filmorate.validators.annotations;

import ru.yandex.practicum.filmorate.validators.FilmDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = FilmDateValidator.class)
@Documented
public @interface CorrectFilmDate {

    String message() default "{FilmDate.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}