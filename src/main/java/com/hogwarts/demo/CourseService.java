package com.hogwarts.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException();
        }
        newCourses.setId(id);
        courseRepository.save(newCourses);
    }

    public Courses getCourseById(long id) {
        Optional<Courses> course = courseRepository.findById(id);
        if (course.isEmpty()) {
            throw new CourseNotFoundException();
        }
        return course.get();
    }

    @Transactional
    public void deleteCourseById(long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException();
        }
        courseRepository.deleteById(id);
    }

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }
}
