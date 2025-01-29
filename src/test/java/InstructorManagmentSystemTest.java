import com.shosha.springboot.demo.InstructorsManagmentSystem;
import com.shosha.springboot.demo.dao.instructorrepository.InstructorRepository;
import com.shosha.springboot.demo.model.entity.Instructor;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = InstructorsManagmentSystem.class)
public class InstructorManagmentSystemTest {

    private static MockHttpServletRequest request;

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorService instructorService;

    @BeforeEach
    public void setUp() {
        jdbc.execute("insert into instructor(instructor_id, first_name, last_name, date_of_birth, email, address_id, course_id) " +
                "VALUES ('12345678-xyzv-1234-efgh-123456789abc', 'John', 'Doe', '1990-05-15', 'john.doe@example.com', NULL, NULL);");
    }

    @Test
    @Order(1)
    public void testIsInstructorNullCheck() {
        String existingInstructorId = "6bd15419-2bc6-42da-adcc-4c61e361b861";
        String nonExistingInstructorId = "ea7ccec0-a718-4c43-888e-f5da2e66a39b";

        when(instructorRepository.existsById(existingInstructorId)).thenReturn(true);
        when(instructorRepository.existsById(nonExistingInstructorId)).thenReturn(false);

        assertTrue(instructorService.isNullOrNot(existingInstructorId));
        assertFalse(instructorService.isNullOrNot(nonExistingInstructorId));
    }

    @Test
    @Order(4)
    public void testFirstSavedInstructor() throws Exception {
        Instructor instructor1 = Instructor.builder()
                .id("12345678-xyzv-1234-efgh-123456789abc")
                .firstName("John")
                .lastName("Doe")
                .birthDate("1990-05-15")
                .email("john.doe@example.com")
                .build();

        ArrayList<Instructor> instructors = new ArrayList<>();
        instructors.add(instructor1);

        when(instructorRepository.findAll()).thenReturn(instructors);

        List<Instructor> actualInstructors = instructorService.findAllInstructors();

        Assertions.assertSame(instructors.get(0), actualInstructors.get(0), "Must be same object");
    }

    @Test
    @Order(3)
    public void testListInstructorViewMvc() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk()).andReturn();

        ModelAndView mav = mvcResult.getModelAndView();

        ModelAndViewAssert.assertViewName(mav, "login");
    }

    @Test
    @Order(2)
    public void getInstructorsSizeInDatabase() {
        Integer mockInstructorsNumber = instructorService.findAllInstructors().size();
        assertEquals(mockInstructorsNumber, 10);
    }

    @AfterEach
    public void tearDown() {
        jdbc.execute("DELETE FROM instructor WHERE instructor_id = '12345678-xyzv-1234-efgh-123456789abc';");
    }

}
