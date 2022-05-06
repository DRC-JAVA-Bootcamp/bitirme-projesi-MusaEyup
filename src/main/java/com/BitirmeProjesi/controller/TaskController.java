package com.BitirmeProjesi.controller;

import com.BitirmeProjesi.dao.TaskRepository;
import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.entity.Task;
import com.BitirmeProjesi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<TaskSaveRequestDto> add(){


        return new ResponseEntity<TaskSaveRequestDto>(new TaskSaveRequestDto("title", "description", LocalDate.of(2020, 1, 8)) ,HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Task> addNewTask(@Valid @RequestBody TaskSaveRequestDto taskSaveRequestDto){
        Task task = taskService.addNewTask(taskSaveRequestDto);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }


}
