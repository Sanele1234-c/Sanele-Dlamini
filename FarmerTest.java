package goldenfarm;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FarmerTest {


    @Mock
    Statement statement;
    @Mock
    private DbConnect dbConnect;

    @Test
    void testGetFarmerID() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getFarmerID();
        assertEquals(result, expResult);
    }

    @Test
    void testSetFarmerID() {
        Farmer instance = new Farmer();
        instance.setFarmerID("9012");
        String expResult = "9012";
        String result = instance.getFarmerID();
        assertEquals(result, expResult);
    }

    @Test
    void testGetName() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getName();
        assertEquals(result, expResult);
    }

    @Test
    void testSetName() {
        Farmer instance = new Farmer();
        instance.setName("Sans");
        String expResult = "Sans";
        String result = instance.getName();
        assertEquals(result, expResult);
    }

    @Test
    void getSurname() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getSurname();
        assertEquals(result, expResult);
    }

    @Test
    void setSurname() {
        Farmer instance = new Farmer();
        instance.setSurname("Dlamini");
        String expResult = "Dlamini";
        String result = instance.getSurname();
        assertEquals(result, expResult);
    }

    @Test
    void getDateOfBirth() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getDateOfBirth();
        assertEquals(result, expResult);
    }

    @Test
    void setDateOfBirth() {
        Farmer instance = new Farmer();
        instance.setDateOfBirth("10.10.96");
        String expResult ="10.10.96";
        String result = instance.getDateOfBirth();
        assertEquals(result, expResult);
    }

    @Test
    void getGender() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getGender();
        assertEquals(result, expResult);
    }

    @Test
    void setGender() {
        Farmer instance = new Farmer();
        instance.setGender("male");
        String expResult = "male";
        String result = instance.getGender();
        assertEquals(result, expResult);
    }

    @Test
    void getContactNumber() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getContactNumber();
        assertEquals(result, expResult);
    }

    @Test
    void setContactNumber() {
        Farmer instance = new Farmer();
        instance.setContactNumber("07145612");
        String expResult = "07145612";
        String result = instance.getContactNumber();
        assertEquals(result, expResult);
    }

    @Test
    void getNextOfKeen() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getNextOfKeen();
        assertEquals(result, expResult);
    }

    @Test
    void setNextOfKeen() {
        Farmer instance = new Farmer();
        instance.setNextOfKeen("TN");
        String expResult = "TN";
        String result = instance.getNextOfKeen();
        assertEquals(result, expResult);
    }

    @Test
    void getRegionCode() {
        Farmer instance = new Farmer();
        String expResult = null;
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void setRegionCode() {
        Farmer instance = new Farmer();
        instance.setRegionCode("12");
        String expResult = "12";
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void testAddFarmerDetails() throws SQLException {
        Farmer instance = new Farmer();
        instance.setFarmerID("123");
        when(dbConnect.createStatement()).thenReturn(statement);
        instance.AddFarmerDetails(dbConnect);
       verify(statement).executeQuery("123");
    }

    @org.junit.jupiter.api.Test
    void deleteFarmer() {
        fail();
    }

    @org.junit.jupiter.api.Test
    void viewFarmer() {
        fail();
    }

    @org.junit.jupiter.api.Test
    void updateFarmer() {
        fail();
    }


}