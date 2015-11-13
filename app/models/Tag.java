/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author alejandro
 */


public class Tag {
    
    /*
    @Required
    public String name;
    
    
    
    private Tag(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Tag otherTag) {
        return name.compareTo(otherTag.name);
    }
    
    public static Tag findOrCreateByName(String name) {
    Tag tag = Tag.find("byName", name).first();
    if(tag == null) {
        tag = new Tag(name);
    }
    return tag;
    }*/
    
    public static Map<String, Long> getCloud() {
        return Post._cloud("tags");
    }
    
    public static List<String> findAll() {
        return new ArrayList(Post._distinct("tags"));
    }
    
    
    
    
    
    
    
    
   
    
    
}
