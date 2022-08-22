package ru.yandex.practicum.filmorate.model;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @NotEmpty(message = "Email can't be empty")
    @NotBlank(message = "Email can't be blank")
    @NotNull(message = "Email can't be null")
    @Email(message = "Email should be in right format")
    private String email;

    @Pattern(regexp = "[A-Za-z\\d.-]{0,19}")
    @NotEmpty(message = "Login can't be empty")
    @NotBlank(message = "Login can't be blank")
    @NotNull(message = "Login can't be null")
    private String login;

    private String name;

    @Past(message = "Birthday should be in the past")
    private LocalDate birthday;
}
