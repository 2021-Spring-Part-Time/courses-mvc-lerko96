package org.wecancodeit.courses;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Collection;

@WebMvcTest(CourseController.class)
public class CourseControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseRepository courseRepo;

    @Mock
    private Course courseOne;

    @Mock
    private Course courseTwo;

    @Test
    public void shouldBeOkForAllCoursesInTheCoursesTemplate() throws Exception {
        mockMvc.perform(get("/courses")).andExpect(status().isOk())
                .andExpect(view().name("coursesTemplate"));
    }

    @Test
    public void shouldFindAllCoursesInModel() throws Exception {
        Collection<Course> allCoursesInModel = Arrays.asList(courseOne, courseTwo);
        when(courseRepo.findAll()).thenReturn(allCoursesInModel);
        mockMvc.perform(get("/courses"))
                .andExpect(model().attribute("coursesModel", allCoursesInModel));
    }

    @Test
    public void shouldBeOkForOneCourseInTheCourseTemplate() throws Exception {
        mockMvc.perform(get("/course?id=1")).andExpect(status().isOk())
                .andExpect(view().name("courseTemplate"));
    }

    @Test
    public void shouldFindCourseOneInModel() throws Exception {
        Long courseOneId = 1L;
        when(courseRepo.findOne(courseOneId)).thenReturn(courseOne);
        mockMvc.perform(get("/course?id=1"))
                .andExpect(model().attribute("courseModel", courseOne));
    }
}
