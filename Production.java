package goldenfarm;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Production {
    private String farmingCode;
    private String farmerID;
    private String regionCode;
    private String totalCost;
    private String totalReturn;
    private String grade;
    private Boolean isProductionAdded;
    private Boolean isProductionDeleted;

    public String getFarmingCode() {
        return farmingCode;
    }

    public void setFarmingCode(String value) {
        if (!(value.isEmpty())){
            farmingCode = value;
        }
    }

    public String getFarmerID() {
        return farmerID;
    }

    public void setFarmerID(String value) {
        if (!(value.isEmpty())){
            farmerID = value;
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

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getTotalReturn() {
        return totalReturn;
    }

    public void setTotalReturn(String totalReturn) {
        this.totalReturn = totalReturn;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String value) {
        if (!(value.isEmpty())){
            grade = value;
        }
    }

    public Boolean getProductionAdded() {
        return isProductionAdded;
    }

    public void setProductionAdded(Boolean value) {
        this.isProductionAdded = value;
    }

    public Boolean getProductionDeleted() {
        return isProductionDeleted;
    }

    public void setProductionDeleted(Boolean value) {
        this.isProductionDeleted = value;
    }
    Boolean checkFarmerID(String farmerID){
        if (farmID.equalsIgnoreCase(getFarmerID())){
            return true;
        }else {
            return false;
        }
    }
    void AddProductionDetails(){
        // insert into database
        DbConnect db = new DbConnect();
        db.connect();

        Boolean x;
        x=true;
        String query;
        query = "INSERT INTO production VALUES('"+ this.farmerID +
                "','"+this.farmingCode+
                "','"+this.totalCost +
                "','"+this.totalReturn +               
                "','"+this.grade+
                "','"+this.regionCode+"')";
        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setProductionAdded(true);
            {
                JOptionPane.showMessageDialog(null," production added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this production","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setProductionAdded(false);
        }
    }

    void deleteProduction()
    {
        DbConnect db = new DbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM production WHERE farmerID='"+this.getFarmerID()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setProductionDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The production is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the product");
            this.setProductionDeleted(false);
        }
    }

    ResultSet ViewIndividualProduction(String FarmerID)
    {
        DbConnect db = new DbConnect();
        db.connect();
        String query ="SELECT * FROM production WHERE farmerID='"+farmerID+"'";
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
}
