/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author alejandro
 */

@Entity
public class Comment extends Model{
    
    
    @Required
    public String author;
    
    @Required
    public Date postedAt;
    
    @Required
    @Lob
    @MaxSize(10000)
    public String content;
    
    @ManyToOne
    @Required
    public Post post;

    public Comment(Post post, String author, String content ) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    
    }
    
    
    
    
   
}
