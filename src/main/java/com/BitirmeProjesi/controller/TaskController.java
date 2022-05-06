package com.BitirmeProjesi.controller;

import com.BitirmeProjesi.dao.TaskRepository;
import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.dto.response.TaskResponseDto;
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
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> add(){

        List<Task> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id){

        Task taskById = taskService.getTaskById(id);
        return new ResponseEntity<>(taskById, HttpStatus.OK);

    }


    @PostMapping("/")
    public ResponseEntity<Task> addNewTask(@Valid @RequestBody TaskSaveRequestDto taskSaveRequestDto){
        Task task = taskService.addNewTask(taskSaveRequestDto);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }


}
