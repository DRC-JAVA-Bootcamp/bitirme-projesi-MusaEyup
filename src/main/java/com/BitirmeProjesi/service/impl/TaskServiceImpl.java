package com.BitirmeProjesi.service.impl;

import com.BitirmeProjesi.dao.TaskRepository;
import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.dto.request.TaskUpdateRequestDto;
import com.BitirmeProjesi.dto.response.TaskResponseDto;
import com.BitirmeProjesi.entity.Task;
import com.BitirmeProjesi.exceptions.TaskNotFoundException;
import com.BitirmeProjesi.service.TaskService;
import com.BitirmeProjesi.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    Converter converter;


    @Override
    public List<TaskResponseDto> getAllTasks() {

        Iterable<Task> all = taskRepository.findAll();
        return converter.convertFromIterableTaskToListOfTaskResponseDto(all);
    }

    @Override
    public List<TaskResponseDto> getAllNotDeletedTasks() {
        Iterable<Task> tasks = taskRepository.findNotDeleted();
        return converter.convertFromIterableTaskToListOfTaskResponseDto(tasks);

    }

    @Override
    public TaskResponseDto getTaskById(Long id) {

        Optional<Task> byId = taskRepository.findById(id);

        if(byId.isPresent())
            return  converter.convertFromTaskToTaskResponseDto(byId.get());
        else
            throw new TaskNotFoundException("Task with id " + id + " not found!!");
    }

    @Override
    public Long deleteTaskById(Long id) {
        return null;
    }

    @Override
    public TaskResponseDto addNewTask(TaskSaveRequestDto taskSaveRequestDto) {

        Task task = converter.convertFromTaskSaveRequestDtoToTask(taskSaveRequestDto);

        task = taskRepository.save(task);

        return converter.convertFromTaskToTaskResponseDto(task);

    }

    @Override
    public TaskResponseDto update(Long id, TaskUpdateRequestDto taskUpdateRequestDto) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty())
            throw new TaskNotFoundException("Task with id " + id + " not found!!");

        Task task = converter.convertFromTaskUpdateRequestDtoToTask(taskUpdateRequestDto, optionalTask.get());
        task = taskRepository.save(task);
        return converter.convertFromTaskToTaskResponseDto(task);

    }
}
