package com.nichoudhary.soap.webservices.soapcoursemanagement.soap;

import com.in28minutes.courses.*;
import com.nichoudhary.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.nichoudhary.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    CourseDetailsService service;

    //method
    //input - GetCourseDetailsRequest
    //output - GetCourseDetailsResponse

    //namespace = http://in28minutes.com/courses
    // name/type/localPart = GetCourseDetailsRequest

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

        Course course = service.findById(request.getId());
        return mapCourseDetails(course);
    }

    @PayloadRoot(namespace = "http://in28minutes.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {

        List<Course> courses = service.findAll();
        return mapAllCourseDetails(courses);
    }

    private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        for(Course course: courses) {
            CourseDetails courseDetails = mapCourse(course);
            response.getCourseDetails().add(courseDetails);
        }
        return response;
    }

    private GetCourseDetailsResponse mapCourseDetails(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    private CourseDetails mapCourse(Course course) {

        CourseDetails courseDetails =  new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }
}
