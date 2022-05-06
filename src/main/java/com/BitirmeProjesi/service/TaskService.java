package com.BitirmeProjesi.service;

import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Long deleteTaskById(Long id);

    Task addNewTask(TaskSaveRequestDto taskSaveRequestDto);


}
