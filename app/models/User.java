/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.*;
import org.junit.Assert;
import org.junit.Test;
import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "blog_user")
public class User extends Model {
    
    @Email
    @Required
    public String eMail;
    
    @Required
    public String password;
    public String fullName;
    public boolean isAdmin;

    public User(String eMail, String password, String fullName) {
        this.eMail = eMail;
        this.password = password;
        this.fullName = fullName;

    }

   public static User connect(String eMail,String password){
       return find("byEmailAndPassword", eMail,password).first();
   }

    @Override
    public String toString() {
        return eMail;
    }
   
   
    

}
