import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Farmer {
    private String farmerID;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String gender;
    private String contactNumber;
    private String nextOfKeen;
    private String regionCode;
    private Boolean isFarmerAdded;
    private Boolean isFarmerDeleted;

    public String getFarmerID() {
        return farmerID;
    }

    public void setFarmerID(String value) {
        if (!(value.isEmpty())){
            farmerID = value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        if (!(value.isEmpty())){
            name = value;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String value) {
        if (!(value.isEmpty())){
            surname = value;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String value) {
        if (!(value.isEmpty())){
            dateOfBirth = value;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String value) {
        if (!(value.isEmpty())){
            gender = value;
        }
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String value) {
        if (!(value.isEmpty())){
            contactNumber = value;
        }
    }

    public String getNextOfKeen() {
        return nextOfKeen;
    }

    public void setNextOfKeen(String value) {
        if (!(value.isEmpty())){
            nextOfKeen = value;
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

    public Boolean getFarmerAdded() {
        return isFarmerAdded;
    }

    public void setIsAdded(Boolean value) {
        this.isFarmerAdded = value;
    }

    public Boolean getFarmerDeleted() {
        return this.isFarmerDeleted;
    }

    public void setIsFarmerDeleted(Boolean value) {
        this.isFarmerDeleted = value;
    }
    Boolean checkFarmerID(String farmID){
        if (farmID.equalsIgnoreCase(getFarmerID())){
            return true;
        }else {
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
        query = "INSERT INTO Farmer VALUES('"+ this.farmerID +
                "','"+this.name+
                "','"+this.surname+
                "','"+this.dateOfBirth+
                "','"+this.gender+
                "','"+this.contactNumber+
                "','"+this.nextOfKeen+
                "','"+this.regionCode+"')";


        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsAdded(true);
            {
                JOptionPane.showMessageDialog(null," student added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this student","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setIsAdded(false);
        }
    }

    void deleteFarmer()
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM farmer WHERE farmId='"+this.getFarmerID()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsFarmerDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The farmer is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the farmer");
            this.setIsFarmerDeleted(false);
        }
    }

    ResultSet ViewFarmer(String farmId)
    {
        dbConnect db = new dbConnect();
        db.connect();
        String query ="SELECT * FROM farmer WHERE farmId='"+farmId+"'";
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

    void UpdateFarmer(String farmId)
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean isFarmerUpdated = true;
        String query = "UPDATE farmer SET farmId='"+this.farmerID+
                "',farmName='"+this.name +
                "',farmSurname='"+this.surname+
                "',dateOfBirth='"+this.dateOfBirth+
                "',gender='"+this.gender+
                "',contactNo='"+this.contactNumber+
                "',nextOfKeen='"+this.nextOfKeen+
                "',regionCode='"+this.regionCode+
                "' WHERE farmId='"+farmId+"'";

        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isFarmerUpdated = false;
            Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isFarmerUpdated)
        {
            JOptionPane.showMessageDialog(null, " Farmer successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update farmer");
        }
    }
}
