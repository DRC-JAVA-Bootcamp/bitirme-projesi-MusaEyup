package com.BitirmeProjesi.util;

import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Converter {

    public Task convertFromTaskSaveRequestDtoToTask(TaskSaveRequestDto taskSaveRequestDto){

        String title = taskSaveRequestDto.getTitle();
        String description = taskSaveRequestDto.getDescription();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(taskSaveRequestDto.getDate(), formatter);

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDate(dateTime);
        task.setCompleted(false);
        task.setDeleted(false);

        return task;
    }

}
