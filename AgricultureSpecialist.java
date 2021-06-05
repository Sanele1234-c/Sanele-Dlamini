import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgricultureSpecialist {
    private String employeeNumber;
    private String regionCode;
    private String agricName;
    private String agricSurname;
    private String emailAddress;
    private String contactNumber;
    private Boolean isAdded;
    private Boolean isDeleted;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String value) {
        if (!(value.isEmpty())){
            employeeNumber = value;
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

    public String getAgricName() {
        return agricName;
    }

    public void setAgricName(String value) {
        if (!(value.isEmpty())){
            agricName = value;
        }
    }

    public String getAgricSurname() {
        return agricSurname;
    }

    public void setAgricSurname(String value) {
        if (!(value.isEmpty())){
            agricSurname = value;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String value) {
        if (!(value.isEmpty())){
            emailAddress = value;
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

    public Boolean getIsAdded() {
        return isAdded;
    }

    public void setIsAdded(Boolean added) {
        isAdded = added;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
    Boolean checkEmployeeNumber(String emplyNum){
        if (emplyNum.equalsIgnoreCase(getEmployeeNumber())){
            return true;
        }else {
            return false;
        }
    }
    void AddAgricultureSpecialistDetails()
    {
        // insert into database
        dbConnect db = new dbConnect();
        db.connect();

        Boolean x;
        x=true;
        String query;
        query = "INSERT INTO AgricSpec VALUES('"+ this.employeeNumber +
                "','"+this.agricName +
                "','"+this.agricSurname+
                "','"+this.contactNumber+
                "','"+this.emailAddress+
                "','"+this.regionCode+"')";
        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsAdded(true);
            {
                JOptionPane.showMessageDialog(null," agriculture Specialist added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this agriculture specialist","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setIsAdded(false);
        }
    }

    void deleteAgricultureSpecialist()
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM agricSpec WHERE emplyNum='"+this.getEmployeeNumber()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The agriculture specialist is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AgricultureSpecialist.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the agriculture Specialist");
            this.setIsDeleted(false);
        }
    }

    ResultSet ViewAgricultureSpecialist(String emplyNum)
    {
        dbConnect db = new dbConnect();
        db.connect();
        String query ="SELECT * FROM agricSpec WHERE emplyNum='"+employeeNumber+"'";
        Statement st = db.createStatement();
        try
        {
            ResultSet res =  st.executeQuery(query);
            return res;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(AgricultureSpecialist.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    void UpdateAgricultureSpecialist(String employeeNumber)
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean isAgricultureSpecialistUpdated = true;
        String query = "UPDATE AgricSpec SET emplyNum='"+this.employeeNumber+
                "',agricName='"+this.agricName+
                "',agricSurname='"+this.agricSurname +
                "',contactNumber='"+this.contactNumber +
                "',emailAddress='"+this.emailAddress+
                "',regionCode='"+this.regionCode +
                "' WHERE emplyNum='"+employeeNumber+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isAgricultureSpecialistUpdated = false;
            Logger.getLogger(AgricultureSpecialist.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isAgricultureSpecialistUpdated)
        {
            JOptionPane.showMessageDialog(null, " Agriculture specialist record successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update Agriculture specialist record");
        }
    }

}
