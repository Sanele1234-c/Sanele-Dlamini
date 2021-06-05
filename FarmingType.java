import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmingType {
    private String farmingCode;
    private String farmingName;
    private String regionCode;
    private Boolean isFarmingTypeAdded;
    private Boolean getIsFarmingTypeDeleted;

    public String getFarmingCode() {
        return farmingCode;
    }

    public void setFarmingCode(String value) {
        if (!(value.isEmpty())){
            farmingCode = value;
        }
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String value) {
        if (!(value.isEmpty())){
            farmingName = value;
        }
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String value) {
        if (!(value.isEmpty())){
            regionCode = value;
        }
    }

    public Boolean getFarmingTypeAdded() {
        return isFarmingTypeAdded;
    }

    public void setIsFarmingTypeAdded(Boolean value) {
        this.isFarmingTypeAdded = value;
    }

    public Boolean getGetIsFarmingTypeDeleted() {
        return getIsFarmingTypeDeleted;
    }

    public void setGetIsFarmingTypeDeleted(Boolean getIsFarmingTypeDeleted) {
        this.getIsFarmingTypeDeleted = getIsFarmingTypeDeleted;
    }
    Boolean checkFarmingCode(String farmCode){
        if (farmCode.equalsIgnoreCase(farmingCode)){
            return true;
        }else {
            return false;
        }
    }
    void AddFarmingTypeDetails()
    {
        // insert into database
        dbConnect db = new dbConnect();
        db.connect();

        Boolean x;
        x=true;
        String query;
        query = "INSERT INTO FarmingType VALUES('"+ this.farmingCode +
                "','"+this.farmingName+
                "','"+this.regionCode+"')";

        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsFarmingTypeAdded(true);
            {
                JOptionPane.showMessageDialog(null," studentClass added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this Class","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setIsFarmingTypeAdded(false);
        }
    }
    void deleteClass()
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM FarmingType WHERE farmingCode='"+this.getFarmingCode()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setGetIsFarmingTypeDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The Farming type is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the Farming type");
            this.setGetIsFarmingTypeDeleted(false);
        }
    }
    ResultSet ViewFarmingType(String farmingCode)
    {
        dbConnect db = new dbConnect();
        db.connect();
        String query ="SELECT * FROM FarmingType WHERE farmingCode='"+farmingCode+"'";
        Statement st = db.createStatement();
        try
        {
            ResultSet res =  st.executeQuery(query);
            return res;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    void UpdateSubFarmingType(String farmCode)
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean isFarmingTypeUpdated = true;
        String query = "UPDATE FarmingType SET farmingCode='"+this.farmingCode+
                "',farmingName='"+this.farmingName +
                "',regionCode='"+this.regionCode +
                "' WHERE farmingCode='"+farmingCode+"'";

        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isFarmingTypeUpdated = false;
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isFarmingTypeUpdated)
        {
            JOptionPane.showMessageDialog(null, "  Farming type record successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update Farming type record");
        }
    }
}
