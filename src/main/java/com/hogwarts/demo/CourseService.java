package com.hogwarts.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public void addCourse(Courses courses) {
        courseRepository.save(courses);
    }

    public void updateGreeting(Courses newCourses, long id) {
        newCourses.setId(id);
        courseRepository.save(newCourses);
    }

    public Courses getCourseById(long id) {
        Optional<Courses> course = courseRepository.findById(id);
        return course.get();
    }

    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }
}
