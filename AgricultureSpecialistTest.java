package goldenfarm;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AgricultureSpecialistTest {
    @Mock
    DbConnect dbConnect;
    @Mock
    Statement statement;

    @Test
    void getEmployeeNumber() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        String expResult = null;
        String result = instance.getEmployeeNumber();
        assertEquals(result, expResult);
    }

    @Test
    void setEmployeeNumber() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setEmployeeNumber("1230");
        String expResult = "1230";
        String result = instance.getEmployeeNumber();
        assertEquals(result, expResult);
    }

    @Test
    void getRegionCode() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        String expResult = null;
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void setRegionCode() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setRegionCode("12");
        String expResult = "12";
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void getAgricName() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        String expResult = null;
        String result = instance.getAgricName();
        assertEquals(result, expResult);
    }

    @Test
    void setAgricName() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setAgricName("Sanele");
        String expResult = "Sanele";
        String result = instance.getAgricName();
        assertEquals(result, expResult);
    }

    @Test
    void getAgricSurname() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        String expResult = null;
        String result = instance.getAgricSurname();
        assertEquals(result, expResult);
    }

    @Test
    void setAgricSurname() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setAgricSurname("Dunns");
        String expResult = "Dunns";
        String result = instance.getAgricSurname();
        assertEquals(result, expResult);
    }

    @Test
    void getEmailAddress() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        String expResult = null;
        String result = instance.getEmailAddress();
        assertEquals(result, expResult);
    }

    @Test
    void setEmailAddress() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setEmailAddress("sduns@gmail.com");
        String expResult = "sduns@gmail.com";
        String result = instance.getEmailAddress();
        assertEquals(result, expResult);
    }

    @Test
    void getContactNumber() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        String expResult = null;
        String result = instance.getContactNumber();
        assertEquals(result, null);
    }

    @Test
    void setContactNumber() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setContactNumber("07145896");
        String expResult = "07145896";
        String result = instance.getContactNumber();
        assertEquals(result, expResult);
    }

    @Test
    void addAgricultureSpecialistDetails() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        instance.setContactNumber("1010");
        when(DbConnect.createStatement()).thenReturn(statement);
        instance.AddAgricultureSpecialistDetails(dbConnect);
        verify(statement);
    }

    @Test
    void deleteAgricultureSpecialist() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        fail();
    }

    @Test
    void viewAgricultureSpecialist() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        fail();
    }

    @Test
    void updateAgricultureSpecialist() {
        AgricultureSpecialist instance = new AgricultureSpecialist();
        fail();
    }
}