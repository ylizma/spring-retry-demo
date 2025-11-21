package com.yamzil.springretrydemo.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.resilience.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Project: spring-retry-demo
 * Updated by yamzil
 * Date: 11/21/2025
 * Time: 5:34 PM
 */

@Service
public class CourseService {
    private Logger logger = LoggerFactory.getLogger(CourseService.class.getName());

    private final CourseRepository courseRepository;
    private Random random = new Random();

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Retryable(includes = {CourseApiException.class}, delay = 1000, maxRetries = 2)
    public ResponseEntity<List<Course>> getAllCourses() {
        logger.info("calling course api");
        addSomeDelay();
        if (random.nextDouble() < 0.60){
            logger.warn("course api failed..");
            throw new CourseApiException();
        }
        return ResponseEntity.ok(courseRepository.getCourses());
    }

    private void addSomeDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
