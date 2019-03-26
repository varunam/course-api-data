package io.springboot.learning.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findCourseByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        //return courses.parallelStream().filter(t -> t.getId().equals(id)).findFirst().get();
        Optional<Course> optionalTopic = courseRepository.findById(id);
        if (optionalTopic.isPresent())
            return optionalTopic.get();
        else
            throw new EntityNotFoundException("Course not found");
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //return courses.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
