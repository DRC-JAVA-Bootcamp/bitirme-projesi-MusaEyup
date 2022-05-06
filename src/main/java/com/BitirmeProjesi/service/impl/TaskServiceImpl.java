package com.BitirmeProjesi.service.impl;

import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.entity.Task;
import com.BitirmeProjesi.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public Long deleteTaskById(Long id) {
        return null;
    }

    @Override
    public Task addNewTask(TaskSaveRequestDto taskSaveRequestDto) {
        return new Task();
    }
}
