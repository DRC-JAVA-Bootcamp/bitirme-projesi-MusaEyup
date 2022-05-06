package com.BitirmeProjesi.service;

import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.dto.request.TaskUpdateRequestDto;
import com.BitirmeProjesi.dto.response.TaskResponseDto;


import java.util.List;

public interface TaskService {

    List<TaskResponseDto> getAllTasks();
    List<TaskResponseDto> getAllNotDeletedTasks();

    TaskResponseDto getTaskById(Long id);

    Long deleteTaskById(Long id);

    TaskResponseDto addNewTask(TaskSaveRequestDto taskSaveRequestDto);

    TaskResponseDto update(Long id, TaskUpdateRequestDto taskUpdateRequestDto);

    Long completeTask(Long id);
}
