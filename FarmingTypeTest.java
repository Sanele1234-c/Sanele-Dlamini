package goldenfarm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmingTypeTest {

    @Test
    void getFarmingCode() {
        FarmingType ft = new FarmingType();
        String expResult = null;
        String result = ft.getFarmingCode();
        assertEquals(result, null);
    }

    @Test
    void setFarmingCode() {
        FarmingType instance = new FarmingType();
        instance.setFarmingCode("a123");
        String expResult = "a123";
        String result = instance.getFarmingCode();
        assertEquals(result, expResult);
    }

    @Test
    void getFarmingName() {
        FarmingType instance = new FarmingType();
        String expResult = null;
        String result = instance.getFarmingName();
        assertEquals(result, null);
    }

    @Test
    void setFarmingName() {
        FarmingType instance = new FarmingType();
        instance.setFarmingName("animals");
        String expResult = "animals";
        String result = instance.getFarmingName();
        assertEquals(result, expResult);
    }

    @Test
    void getRegionCode() {
        FarmingType instance = new FarmingType();
        String expResult = null;
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void setRegionCode() {
        FarmingType instance = new FarmingType();
        instance.setRegionCode("a123");
        String expResult = "a123";
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void getTypeOfProduct() {
        FarmingType instance = new FarmingType();
        String expResult = null;
        String result = instance.getRegionCode();
        assertEquals(result,expResult);
    }

    @Test
    void setTypeOfProduct() {
        FarmingType instance = new FarmingType();
        instance.setTypeOfProduct("poultry");
        String expResult = "poultry";
        String result = instance.getTypeOfProduct();
        assertEquals(result, expResult);
    }


    @Test
    void addFarmingTypeDetails() {
        fail();
    }

    @Test
    void deleteFarmingType() {
    }

    @Test
    void viewFarmingType() {
    }
}