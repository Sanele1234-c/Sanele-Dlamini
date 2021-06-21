package goldenfarm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {

    @Test
    void getRegionCode() {
        Region instance = new Region();
        String expResult = null;
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void setRegionCode() {
        Region instance = new Region();
        instance.setRegionCode("1234");
        String expResult = "1234";
        String result = instance.getRegionCode();
        assertEquals(result, expResult);
    }

    @Test
    void getName() {
        Region instance = new Region();
        String expResult = null;
        String result = instance.getName();
        assertEquals(result, expResult);
    }

    @Test
    void setName() {
        Region instance = new Region();
        instance.setName("Malema");
        String expResult = "Malema";
        String result = instance.getName();
        assertEquals(result, expResult);
    }

    @Test
    void addRegionDetails() {
        fail();
    }

    @Test
    void deleteRegion() {
        fail();
    }

    @Test
    void viewRegion() {
        fail();
    }

    @Test
    void updateRegion() {
        fail();
    }
}