package com.BitirmeProjesi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TaskUpdateRequestDto {

    @NotNull
    @Size(min = 2, message = "title should have at least 2 characters")
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String date;

    @NotNull
    private boolean isCompleted;

    @NotNull
    private boolean isDeleted;

}
