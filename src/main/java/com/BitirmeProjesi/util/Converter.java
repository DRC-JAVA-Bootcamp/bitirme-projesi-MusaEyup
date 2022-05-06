package com.BitirmeProjesi.util;

import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.dto.request.TaskUpdateRequestDto;
import com.BitirmeProjesi.dto.response.TaskResponseDto;
import com.BitirmeProjesi.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public TaskResponseDto convertFromTaskToTaskResponseDto(Task task){

        TaskResponseDto taskResponseDto = new TaskResponseDto();

        taskResponseDto.setId(task.getId());
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setDate(task.getDate());
        taskResponseDto.setCompleted(task.isCompleted());
        taskResponseDto.setDeleted(task.isDeleted());

        return taskResponseDto;

    }

    public List<TaskResponseDto> convertFromIterableTaskToListOfTaskResponseDto(Iterable<Task> tasks){
        List<TaskResponseDto> list = new ArrayList<>();
        tasks.forEach(task -> {
                    list.add(this.convertFromTaskToTaskResponseDto(task));
                }
        );
        return list;
    }


    public Task convertFromTaskUpdateRequestDtoToTask(TaskUpdateRequestDto taskUpdateRequestDto, Task task){

        task.setTitle(taskUpdateRequestDto.getTitle());
        task.setDescription(taskUpdateRequestDto.getDescription());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(taskUpdateRequestDto.getDate(), formatter);
        task.setDate(dateTime);

        task.setCompleted(taskUpdateRequestDto.isCompleted());
        task.setDeleted(taskUpdateRequestDto.isDeleted());

        return task;
    }
}
