package com.hogwarts.demo;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("Course has not been found");
    }
}
