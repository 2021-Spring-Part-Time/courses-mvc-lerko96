package org.wecancodeit.courses;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseRepository {

    Map<Long, Course> coursesList = new HashMap<>();

    //constructor for testing purposes only uses carArgs to add none or as many objects as we want
    public CourseRepository(Course ...coursesToAdd) {
        for(Course course: coursesToAdd){
            coursesList.put(course.getId(), course);
        }
    }

    public Course findOne(long id) {
        return coursesList.get(id);
    }

    public Collection<Course> findAll() {
        return coursesList.values();
    }
}
