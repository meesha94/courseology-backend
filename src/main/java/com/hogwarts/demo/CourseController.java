package com.hogwarts.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(CourseNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // CREATE

    @PostMapping("/course")
    public ResponseEntity<Courses> createGreeting(@RequestBody Courses courses) {
        courseService.addCourse(courses);
        return ResponseEntity.status(HttpStatus.CREATED).body(courses);
    }

    // READ

    @GetMapping("/courses")
    public ResponseEntity <List<Courses>> getAllCourses() {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourses());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable long id) {

        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourseById(id));
    }

    // UPDATE

    @PutMapping("/course/{id}")
    public ResponseEntity<Courses> updateCourse(@RequestBody Courses newCourses, @PathVariable long id) {
        newCourses.setId(id);
        courseService.updateGreeting(newCourses, id);
        return ResponseEntity.status(HttpStatus.OK).body(newCourses);
    }

    // DELETE

    @DeleteMapping("/course/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable long id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
