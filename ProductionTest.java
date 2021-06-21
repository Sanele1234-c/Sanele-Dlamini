package goldenfarm;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductionTest {

    @Mock
    DbConnect dbConnect;

    @Test
    void getFarmingCode() {
        Production instance = new Production();
        String expResult = null;
        String result = instance.getFarmingCode();
        assertEquals(result, expResult);
    }

    @Test
    void setFarmingCode() {
        Production instance = new Production();
        instance.setFarmingCode("45");
        String expResult = "45";
        String result = instance.getFarmingCode();
        assertEquals(result, expResult);
    }

    @Test
    void getFarmerID() {
        Production instance = new Production();
        String expResult = null;
        String result = instance.getFarmerID();
        assertEquals(result, expResult);
    }

    @Test
    void setFarmerID() {
        Production instance = new Production();
        instance.setFarmerID("12");
        String expResult = "12";
        String result = instance.getFarmerID();
        assertEquals(result, expResult);
    }

    @Test
    void getRegionCode() {
        Production instance = new Production();
        String expResult = null;
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void setRegionCode() {
        Production instance = new Production();
        instance.setRegionCode("2013");
        String expResult = "2013";
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void getTotalCost() {
        Production instance = new Production();
        String expResult = null;
        String result = instance.getTotalCost();
        assertEquals(result, expResult);
    }

    @Test
    void setTotalCost() {
        Production instance = new Production();
        instance.setTotalCost("200");
        String expResult = "200";
        String result = instance.getTotalCost();
        assertEquals(result, expResult);
    }

    @Test
    void getTotalReturn() {
        Production instance = new Production();
        String expResult = null;
        String result = instance.getTotalReturn();
        assertEquals(result, expResult);
    }

    @Test
    void setTotalReturn() {
        Production instance = new Production();
        instance.setTotalReturn("400");
        String expResult = "400";
        String result = instance.getTotalReturn();
        assertEquals(result, expResult);
    }

    @Test
    void getGrade() {
        Production instance = new Production();
        String expResult = null;
        String result = instance.getGrade();
        assertEquals(result, expResult);
    }

    @Test
    void setGrade() {
        Production instance = new Production();
        instance.setGrade("loss");
        String expResult = "loss";
        String result = instance.getGrade();
        assertEquals(result, expResult);
    }

    @Test
    void getProductionAdded() {
//        Production instance = new Production();
//        instance.setFarmerID("14789");
//        when(dbConnect.createStatement()).thenReturn(new StatementForTest());
//        instance.AddProductionDetails(dbConnect);
//        assertEquals();
    }

    @Test
    void addProductionDetails() {
    }

    @Test
    void deleteProduction() {
    }

    @Test
    void viewIndividualMark() {
    }
}