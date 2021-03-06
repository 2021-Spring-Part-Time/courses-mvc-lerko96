package org.wecancodeit.courses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

public class CourseRepositoryTest {

    private CourseRepository underTest;
    Course courseOne = new Course(1L, "course one name", "description");
    Course courseTwo = new Course(2L, "course two name", "description");

    @Test
    public void shouldFindCourseOne() {
        underTest = new CourseRepository(courseOne);
        Course foundCourse = underTest.findOne(1L);
        assertEquals(courseOne, foundCourse);
    }

    @Test
    public void shouldFindCourseOneAndCourseTwo() {
        underTest = new CourseRepository(courseOne, courseTwo);
        Collection<Course> foundCourses = underTest.findAll();
        assertThat(foundCourses).contains(courseOne, courseTwo);
    }
}
