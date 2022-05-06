package com.BitirmeProjesi.dto.request;


import com.BitirmeProjesi.validator.CustomDateConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskSaveRequestDto {

    @NotNull
    @Size(min = 2, message = "title should have at least 2 characters")
    private String title;

    @NotNull
    private String description;

    @NotNull
    @CustomDateConstraint
    private LocalDate dueDate;







}
