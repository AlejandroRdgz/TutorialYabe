/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author alejandro
 */


import play.*;
import play.mvc.*;


@Check("admin")
@With(Secure.class)
public class Tags extends CRUD {
    
}
