package com.galvanize.Spring.Lessons.CRUD.Endpoints.Controller;


import com.galvanize.Spring.Lessons.CRUD.Endpoints.Model.Lesson;
import com.galvanize.Spring.Lessons.CRUD.Endpoints.Repository.LessonRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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

    @GetMapping("{id}")
    public Optional<Lesson> getTitleByID(@PathVariable long id) {
        return this.repository.findById(id);
    }

    @DeleteMapping("{id}")
    public String  deleteDatabaseRowByID(@PathVariable long id) {
        this.repository.deleteById(id);
        return "Record " + id + " has been deleted.";
    }

    @PatchMapping("{id}")
    public Lesson updateLessonById(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);

    }

    @GetMapping("/find/{title}")
    public Iterable<Lesson> getLessonsByTitle(@PathVariable String title) {
        return this.repository.findByTitle(title);
    }

    @GetMapping("/between")
    public Iterable<Lesson> getLessonBetweenDates(@RequestParam String date1, String date2) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate = formatter.parse(date1);
        Date endDate = formatter.parse(date2);

       return this.repository.findByDeliveredOnBetween(startDate, endDate);
    }
}



