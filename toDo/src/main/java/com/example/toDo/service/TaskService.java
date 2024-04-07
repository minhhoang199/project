package com.example.toDo.service;

import com.example.toDo.model.Task;
import com.example.toDo.model.enums.State;
import com.example.toDo.repeository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    private boolean validateNumber(Integer num) {
        if (num < 0) {
            throw new RuntimeException(num + ": This parameter can not be negative");
        }
        if (num == 0) {
            throw new RuntimeException(num + ": This parameter can not be 0");
        }
        return true;
    }



    public List<Task> getAll(Integer pageNo, Integer pageSize) {
        //pageNo can be 0
        if (pageNo < 0) {
            throw new RuntimeException("This parameter can not be negative");
        }
        validateNumber(pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Task> pageResult = taskRepository.findAll(pageable);
        return pageResult.toList();
    }

    //Search by Title and date
    public List<Task> getByTitleAndDate(String title, String strDate, Integer pageNo, Integer pageSize) {
        if (pageNo < 0) {
            throw new RuntimeException("This parameter can not be negative");
        }
        validateNumber(pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(strDate, formatter);
        Page<Task> pageResult = taskRepository.findByContentContainingAndDate(title, date, pageable);

        return pageResult.toList();
    }

    //Search by Title
    public List<Task> getByTitle(String title, Integer pageNo, Integer pageSize) {
        //pageNo can be 0
        if (pageNo < 0) {
            throw new RuntimeException("This parameter can not be negative");
        }
        validateNumber(pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Task> pageResult = taskRepository.findByContentContaining(title, pageable);

        return pageResult.toList();
    }


    //Search by date
    public List<Task> getByDate(String strDate, Integer pageNo, Integer pageSize) {
        //pageNo can be 0
        if (pageNo < 0) {
            throw new RuntimeException("This parameter can not be negative");
        }
        validateNumber(pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(strDate, formatter);
        Page<Task> pageResult = taskRepository.findByDate(date, pageable);

        return pageResult.toList();
    }

    public boolean addNewTask(Task newTask) {
        if (newTask != null) {
//            if (newTask.getTaskState().equals(State.DONE)) {
//                throw new RuntimeException("New task cannot be done already");
//            }
            newTask.setTaskState(State.ACTIVE);
            taskRepository.save(newTask);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateTask(Integer id, Task newTask) {
        validateNumber(id);
        Optional<Task> opTask = taskRepository.findById(id);
        if (opTask.isPresent()) {
            Task oldTask = opTask.get();
            if (newTask.getContent() != null && newTask.getContent().length() > 0) {
                oldTask.setContent(newTask.getContent());
            }
            if (newTask.getDate() != null) {
                oldTask.setContent(newTask.getContent());
            }
            oldTask.setTaskState(newTask.getTaskState());
            taskRepository.save(oldTask);
            return true;
        } else {
            throw new RuntimeException("Not found task");
        }
    }

    public boolean deleteTask(Integer id) {
        validateNumber(id);
        Optional<Task> opTask = taskRepository.findById(id);
        if (opTask.isPresent()) {
            taskRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Not found task");
        }
    }
}
