package com.BitirmeProjesi.service.impl;

import com.BitirmeProjesi.dao.TaskRepository;
import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.entity.Task;
import com.BitirmeProjesi.exceptions.TaskNotFoundException;
import com.BitirmeProjesi.service.TaskService;
import com.BitirmeProjesi.util.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    Converter converter;


    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {

        Optional<Task> byId = taskRepository.findById(id);

        if(byId.isPresent())
            return byId.get();
        else
            throw new TaskNotFoundException("Task with id " + id + " not found!!");
    }

    @Override
    public Long deleteTaskById(Long id) {
        return null;
    }

    @Override
    public Task addNewTask(TaskSaveRequestDto taskSaveRequestDto) {

        Task task = converter.convertFromTaskSaveRequestDtoToTask(taskSaveRequestDto);

        return taskRepository.save(task);

    }
}
