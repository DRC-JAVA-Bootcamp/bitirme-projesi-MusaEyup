package com.BitirmeProjesi.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static java.time.temporal.WeekFields.ISO;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Data
@AllArgsConstructor
public class TaskSaveRequestDto {

    @NotNull
    @Size(min = 2, message = "title should have at least 2 characters")
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String date;







}
