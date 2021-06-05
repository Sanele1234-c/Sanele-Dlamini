import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Region {
    private String regionCode;
    private String name;
    private Boolean isRegionAdded;
    private Boolean isRegionDeleted;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String value) {
        if (!(value.isEmpty())){
            regionCode = value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (!(value.isEmpty())) {
            name = value;
        }
    }

    public Boolean getRegionAdded() {
        return isRegionAdded;
    }

    public void setRegionAdded(Boolean regionAdded) {
        isRegionAdded = regionAdded;
    }

    public Boolean getRegionDeleted() {
        return isRegionDeleted;
    }

    public void setRegionDeleted(Boolean regionDeleted) {
        isRegionDeleted = regionDeleted;
    }
    Boolean checkRegionCode(String regionCode) {
        if (regionCode.equalsIgnoreCase(getRegionCode())) {
            return true;
        } else {
            return false;
        }
    }
    void AddFarmerDetails(){
        // insert into database
        dbConnect db = new dbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query;
        query = "INSERT INTO Farmer VALUES('"+ this.regionCode +
                "','"+this.name+
                "','"+this.regionCode+"')";


        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setRegionAdded(true);
            {
                JOptionPane.showMessageDialog(null," student added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this student","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setRegionAdded(false);
        }
    }

    void deleteStudent()
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM student WHERE studId='"+this.getRegionCode()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setRegionDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The farmer is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the farmer");
            this.setRegionDeleted(false);
        }
    }

    ResultSet ViewRegion(String farmId)
    {
        dbConnect db = new dbConnect();
        db.connect();
        String query ="SELECT * FROM region WHERE regionCode='"+regionCode+"'";
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

    void UpdateRegion(String farmId)
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean isRegionUpdated = true;
        String query = "UPDATE farmer SET farmId='"+this.regionCode+
                "',farmName='"+this.name +
                "' WHERE farmId='"+regionCode+"'";

        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isRegionUpdated = false;
            Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isRegionUpdated)
        {
            JOptionPane.showMessageDialog(null, " Farmer successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update farmer");
        }
    }
}
