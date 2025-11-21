package com.yamzil.springretrydemo.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: spring-retry-demo
 * Updated by yamzil
 * Date: 11/21/2025
 * Time: 5:32 PM
 */

@Repository
public class CourseRepository implements CommandLineRunner {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void run(String... args) throws Exception {
    courses.add(new Course(1L, "java"));
    courses.add(new Course(2L, "html"));
    courses.add(new Course(1L, "Spring"));
    courses.add(new Course(1L, "kotlin"));
    }
}
