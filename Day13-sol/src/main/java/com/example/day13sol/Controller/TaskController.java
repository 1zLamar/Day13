package com.example.day13sol.Controller;


import com.example.day13sol.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    ArrayList<Task> tasks= new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Task> getTask(){
        return tasks;
    }

    //create
    @PostMapping("/add")
    public String addTask(@RequestBody Task task){
        tasks.add(task);
        return "added";
    }

    //update

    @PutMapping("/update/{indx}")
    public String updateTask(@RequestBody Task task , @PathVariable int indx){
        tasks.set(indx,task);
        return "task updated";
    }
    //delete
    @DeleteMapping("/delete/{indx}")
    public String deleteTask(@PathVariable int indx){
        tasks.remove(indx);
        return "task deleted";
    }

    @PutMapping("/change/{indx}")
    public String changeTask(@PathVariable int indx){
        if (tasks.get(indx).getStatus().equals("not done")) {
            tasks.get(indx).setStatus("done");
        }
        return "task status changed";
    }
    @GetMapping("/search/{title}")
    public String searchTask(@PathVariable String title) {
        boolean isFound = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(title)) {
                isFound = true;
            }
        }
        if (isFound) {
            return "found";
        } else {

            return "not found";
        }
    }


}
