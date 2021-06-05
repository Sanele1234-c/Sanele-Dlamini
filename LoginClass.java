package com.jotham.sanele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginClass {
    private String user;
    private String pass;
    private Boolean isUserAdded;
    private Boolean isUserDeleted;

    String getUser()
    {
        return user;
    }


    void setUser(String value)
    {
        if (!(value.isEmpty()))
        {
            user= value;
        }
    }

    String getPass()
    {
        return pass;
    }
    void setPass(String value)
    {
        if (!(value.isEmpty()))
        {
            pass= value;
        }
    }

    void setIsAdded(Boolean value)
    {
        this.isUserAdded= value;
    }
    Boolean getIsAdded()
    {
        return this.isUserAdded;
    }

    void setIsUserDeleted(Boolean value)
    {
        this.isUserDeleted= value;
    }

    Boolean getIsUserDeleted()
    {
        return this.isUserDeleted;
    }



    Boolean checkUSer(String user)
    {

        if (user.equalsIgnoreCase(getUser()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void AddUserDetails()
    {
        // insert into database
        dbConnect db = new dbConnect();
        db.connect();

        Boolean x;
        x=true;
        String query;
        query = "INSERT INTO ADMIN VALUES('"+ this.user +
                "','"+this.pass+"')";

        Statement st = db.createStatement();

        try
        {

            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsAdded(true);
            {
                JOptionPane.showMessageDialog(null," user added successfully","important",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null," you can not add this user","warning",JOptionPane.INFORMATION_MESSAGE);
            this.setIsAdded(false);
        }
    }
    void deleteUser()
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean x;
        x=true;
        String query = "DELETE FROM ADMIN WHERE username='"+this.getUser()+"'";
        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
            if (x.equals(true))
                this.setIsUserDeleted(true);
            {
                JOptionPane.showMessageDialog(null, "The user is successfully deleted");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Production.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            JOptionPane.showMessageDialog(null, "The system could not  deleted the user");
            this.setIsUserDeleted(false);
        }
    }

    ResultSet ViewUser(String user)
    {
        dbConnect db = new dbConnect();
        db.connect();
        String query ="SELECT * FROM ADMIN WHERE username='"+user+"'";
        Statement st = db.createStatement();
        try
        {
            ResultSet res =  st.executeQuery(query);
            return res;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Region.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }
    void UpdateUser(String user)
    {
        dbConnect db = new dbConnect();
        db.connect();
        Boolean isClassUpdated = true;
        String query = "UPDATE ADMIN SET username='"+this.user+
                "',password='"+this.pass +

                "' WHERE username='"+this.user+"'";

        Statement st = db.createStatement();
        try
        {
            st.executeUpdate(query);
        }
        catch (SQLException ex)
        {
            isClassUpdated = false;
            Logger.getLogger(Region.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if (isClassUpdated)
        {
            JOptionPane.showMessageDialog(null, "  user successfully updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null, " system could not  update user");
        }
    }


}
