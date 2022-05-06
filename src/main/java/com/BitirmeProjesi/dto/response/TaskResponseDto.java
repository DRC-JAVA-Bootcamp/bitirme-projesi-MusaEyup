package com.BitirmeProjesi.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private boolean isCompleted;
    private boolean isDeleted;

}
