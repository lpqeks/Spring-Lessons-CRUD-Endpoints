package com.galvanize.Spring.Lessons.CRUD.Endpoints.Controller;


import com.galvanize.Spring.Lessons.CRUD.Endpoints.Model.Lesson;
import com.galvanize.Spring.Lessons.CRUD.Endpoints.Repository.LessonRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private final LessonRepository repository;

    public LessonController(LessonRepository repository) {
        this.repository = repository;
    }


    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

}