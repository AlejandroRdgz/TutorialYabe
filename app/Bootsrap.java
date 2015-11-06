/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alejandro
 */

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootsrap extends Job{
    
    public void doJob(){
        //check if the data base is empty
        if(User.count() == 0){
            Fixtures.load("initial-data.yml");
        }
    
    }
}
