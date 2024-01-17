package com.education.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.education.entity.Education;
import com.education.repository.EducationRepository;

@RunWith(MockitoJUnitRunner.class)
public class EducationControllerTest {

    @InjectMocks
    private EducationController educationController;

    @Mock
    private EducationRepository educationRepository;
    
    private List<Education> educationList;


    @Before
    public void setup() {
    	educationList = Arrays.asList(
                new Education(1, "BAC", "School A", "2022"),
                new Education(2, "Master", "School B", "2023")
        );
        Mockito.when(educationRepository.findAll()).thenReturn(educationList);
        Mockito.when(educationRepository.findById(1)).thenReturn(educationList.get(0));
        Mockito.when(educationRepository.findByGraduationYear("2022")).thenReturn(Arrays.asList(educationList.get(0)));
    }

    @Test
    public void testGetAllEducation() {
        List<Education> result = educationController.getAllEducation();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetEducationById() {
        Education result = educationController.getEducationById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    public void testGetEducationByYear() {
        List<Education> result = educationController.getEducationByYear("2022");
        assertEquals(1, result.size());
        assertEquals("2022", result.get(0).getGraduationYear());
    }

    @Test
    public void testCreateEducation() {
        Education newEducation = new Education(3, "Bachelor", "School C", "2024");
        Mockito.when(educationRepository.save(newEducation)).thenReturn(newEducation);
        Education result = educationController.createEducation(newEducation);
        assertNotNull(result);
        assertEquals(3, result.getId());
    }

    @Test
    public void testUpdateEducation() {
        Education educationToUpdate = new Education(1, "Master", "Updated School", "2022");
        Mockito.when(educationRepository.save(educationToUpdate)).thenReturn(educationToUpdate);
        Education result = educationController.updateEducation(1, educationToUpdate);
        assertEquals("Updated School", result.getInstitution());
    }

    @Test
    public void testDeleteEducation() {
        educationController.deleteEducation(1);
        Mockito.verify(educationRepository, Mockito.times(1)).deleteById(1);
    }

    
}
