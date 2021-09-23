package com.galvanize.Spring.Lessons.CRUD.Endpoints.Repository;

import com.galvanize.Spring.Lessons.CRUD.Endpoints.Model.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
}