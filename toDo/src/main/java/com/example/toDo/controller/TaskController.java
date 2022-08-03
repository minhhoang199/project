package com.example.toDo.controller;

import com.example.toDo.model.ResponseObject;
import com.example.toDo.model.Task;
import com.example.toDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

//    @GetMapping("")
//    public ResponseEntity<Object> getAll(
//            @RequestParam(value = "pageNo") Optional<Integer> pageNo,
//            @RequestParam(value = "pageSize") Optional<Integer> pageSize
//    ){
//        try {
//            List<Task> taskList = taskService.getAll(pageNo.orElse(0), pageSize.orElse(10));
//            return ResponseEntity.ok(taskList);
//        } catch (RuntimeException e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> getByConditions(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "pageNo") Optional<Integer> pageNo,
            @RequestParam(value = "pageSize") Optional<Integer> pageSize
    ){
        try {
            //Not input title condition search
            if (title == null && date != null){
                List<Task> taskList = taskService.getByDate(date, pageNo.orElse(0), pageSize.orElse(10));
                return ResponseEntity.ok(new ResponseObject("201", "Success", taskList));
            }
            //Not input date condition search
            else if (title != null && date == null){
                List<Task> taskList = taskService.getByTitle(title, pageNo.orElse(0), pageSize.orElse(10));
                return ResponseEntity.ok(new ResponseObject("201", "Success", taskList));
            }  // Input both search conditions
            else if (title != null && date != null){
                List<Task> taskList = taskService.getByTitleAndDate(title, date, pageNo.orElse(0), pageSize.orElse(10));
                return ResponseEntity.ok(new ResponseObject("201", "Success", taskList));
            }//Not input both search conditions
            else {
                List<Task> taskList = taskService.getAll(pageNo.orElse(0), pageSize.orElse(10));
                return ResponseEntity.ok(new ResponseObject("201", "Success", taskList));
            }
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(new ResponseObject("400", e.getMessage(), null));
        }
    }

    //Define 202 is "Create success"
    @PostMapping
    public ResponseEntity<ResponseObject> addNewTask(@RequestBody Task newTask){
        try {
            var isCreated = taskService.addNewTask(newTask);
            if (isCreated) {
                return ResponseEntity.ok().body(new ResponseObject("202", "Create success", null));
            } else {
                return ResponseEntity.internalServerError().body(new ResponseObject("500", "Internal server error", null));
            }
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(new ResponseObject("400", e.getMessage(), null));
        }
    }


    //Define 203 is "Update success"
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseObject> updateTask(
            @PathVariable("id") Integer id,
            @RequestBody Task newTask){
        try {
            var isUpdated = taskService.updateTask(id, newTask);
            if (isUpdated) {
                return ResponseEntity.ok().body(new ResponseObject("203", "Update success", null));
            } else {
                return ResponseEntity.internalServerError().body(new ResponseObject("500", "Internal server error", null));
            }
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(new ResponseObject("400", e.getMessage(), null));
        }
    }

    //Define 204 is "Delete success"
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteTask(@PathVariable("id") Integer id){
        try {
            var isDeleted = this.taskService.deleteTask(id);
            if (isDeleted) {
                return ResponseEntity.ok().body(new ResponseObject("204", "Delete success", null));
            } else {
                return ResponseEntity.internalServerError().body(new ResponseObject("500", "Internal server error", null));
            }
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(new ResponseObject("400", e.getMessage(), null));
        }
    }
}
