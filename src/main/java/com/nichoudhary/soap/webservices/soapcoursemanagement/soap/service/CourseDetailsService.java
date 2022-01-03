package com.nichoudhary.soap.webservices.soapcoursemanagement.soap.service;

import com.nichoudhary.soap.webservices.soapcoursemanagement.soap.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    // course details for single course - Course findById(int id)
    // course details for all courses - List<Course> findAll()
    // delete course - int deleteById(int id)
    // update course - int updateById(int id)

    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        courses.add(course1);
        Course course2 = new Course(2, "Spring MVC", "10 Steps");
        courses.add(course2);
        Course course3 = new Course(3, "Spring Boot", "10 Steps");
        courses.add(course3);
        Course course4 = new Course(4, "Maven", "10 Steps");
        courses.add(course4);
    }

    public Course findById(int id) {
        for(Course course: courses) {
            if(course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List<Course> findAll() {
        return courses;
    }
    public int deleteById(int id) {

        Iterator<Course> iterator = courses.iterator();
        while(iterator.hasNext()) {
            Course course = iterator.next();
            if(course.getId() == id) {
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }

}
