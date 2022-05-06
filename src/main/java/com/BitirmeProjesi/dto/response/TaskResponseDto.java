package com.BitirmeProjesi.dto.response;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private boolean isCompleted;
    private boolean isDeleted;

}
