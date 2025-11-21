package com.yamzil.springretrydemo.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: spring-retry-demo
 * Updated by yamzil
 * Date: 11/21/2025
 * Time: 5:37 PM
 */

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity getCourses() {
        try {
            return courseService.getAllCourses();
        } catch (Exception e) {
            return ResponseEntity.status(503).body(e.getMessage());
        }
    }
}
