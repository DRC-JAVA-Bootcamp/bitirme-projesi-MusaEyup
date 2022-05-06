package com.BitirmeProjesi.controller;

import com.BitirmeProjesi.dao.TaskRepository;
import com.BitirmeProjesi.dto.request.TaskSaveRequestDto;
import com.BitirmeProjesi.dto.request.TaskUpdateRequestDto;
import com.BitirmeProjesi.dto.response.TaskResponseDto;
import com.BitirmeProjesi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskService taskService;


    @GetMapping("/")
    public ResponseEntity<List<TaskResponseDto>> getNotDeleted(){

        List<TaskResponseDto> allTasks = taskService.getAllNotDeletedTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);

    }
    @GetMapping("/all")
    public ResponseEntity<List<TaskResponseDto>> getAll(){

        List<TaskResponseDto> allTasks = taskService.getAllTasks();
        return new ResponseEntity<>(allTasks, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getById(@PathVariable Long id){

        TaskResponseDto taskById = taskService.getTaskById(id);
        return new ResponseEntity<>(taskById, HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<TaskResponseDto> addNewTask(@Valid @RequestBody TaskSaveRequestDto taskSaveRequestDto){
        TaskResponseDto task = taskService.addNewTask(taskSaveRequestDto);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @RequestBody TaskUpdateRequestDto taskUpdateRequestDto){

        TaskResponseDto updated = taskService.update(id, taskUpdateRequestDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<Long> completeTask(@PathVariable Long id){

        Long ID = taskService.completeTask(id);
        return new ResponseEntity<>(ID, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTaskById(@PathVariable Long id){
        Long ID = taskService.deleteTaskById(id);
        return new ResponseEntity<>(ID, HttpStatus.OK);
    }


}
