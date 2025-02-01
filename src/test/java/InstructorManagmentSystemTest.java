import com.shosha.springboot.demo.InstructorsManagmentSystem;
import com.shosha.springboot.demo.dao.instructorrepository.InstructorRepository;
import com.shosha.springboot.demo.service.instructorservice.InstructorService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        String existingInstructorId = "5d3fa3d2-90ac-490d-8282-c5f7ec34a8f6";
        String nonExistingInstructorId = "ea7ccec0-a718-4c43-888e-f5da2e66a39b";

        when(instructorRepository.existsById(existingInstructorId)).thenReturn(true);
        when(instructorRepository.existsById(nonExistingInstructorId)).thenReturn(false);

        assertTrue(instructorService.isNullOrNot(existingInstructorId));
        assertFalse(instructorService.isNullOrNot(nonExistingInstructorId));
    }

    @Test
    @Order(2)
    public void getInstructorsSizeInDatabase() {
        Integer mockInstructorsNumber = instructorService.findAllInstructors().size();
        assertEquals(mockInstructorsNumber, 18);
    }

    @AfterEach
    public void tearDown() {
        jdbc.execute("DELETE FROM instructor WHERE instructor_id = '12345678-xyzv-1234-efgh-123456789abc';");
    }

}
