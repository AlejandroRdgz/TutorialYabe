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
import com.google.code.morphia.annotations.Entity;
import play.modules.morphia.Model;


/**
 *
 * @author alejandro
 */
@Entity
public class User extends Model {
    
    @Email
    @Required
    public String email;
    
    @Required
    public String password;
    public String fullName;
    public boolean isAdmin;

    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;

    }

   public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }

    @Override
    public String toString() {
        return email;
    }
   
   
    

}
