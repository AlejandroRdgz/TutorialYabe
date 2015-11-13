/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.*;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.modules.morphia.Model;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Reference;
import java.util.HashSet;

/**
 *
 * @author alejandro
 */
@Entity
//@Embedded
public class Post extends Model {

    @Required
    public String title;
    
    @Required
    public Date postedAt;

    @Lob
    @Required
    @MaxSize(10000)    
    public String content;

    @Required
    //@ManyToOne
    public User author;
    
    

    /*public Post(User author, String title, String content) {
     this.author = author;
     this.title = title;
     this.content = content;
     this.postedAt = new Date();
     }*/
  //  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @Reference
    public List<Comment> comments;
    
   // @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<String> tags = new HashSet<String>();
    
    public Post(User author, String title, String content) {
        this.comments = new ArrayList<Comment>();
        this.tags = new TreeSet();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();

    }

    public Post addComment(String author, String content) {
//        Comment newComment = new Comment(this, author, content).save();
//        this.comments.add(newComment);
//        this.save();
        
        new Comment(this, author, content).save();
        
        return this;
    }

    public Post previous() {
        return Post.q().filter("postedAt <", postedAt).
                order("-postedAt").first();
    }

    public Post next() {
        return Post.q().filter("postedAt >", postedAt).
                order("postedAt").first();
    }
    
    public Post tagItWith(String name){
        tags.add(name);
        return(this);
    }
    
    public static List<Post> findTaggedWith(String... tags){
//        return Post.find(
//                "select distinct p from Post p join p.tags as t where t.name in (:tags) group by p.id, p.author, p.title, p.content,p.postedAt having count(t.id) = :size"
//                ).bind("tags", tags).bind("size", tags.length).fetch();
        
        return Post.q().filter("tags all", tags).asList();
    }
    
    
    public String toString() {
        return title;
    }
    
    @OnDelete void cascadeDelete() {
        for (Comment c: comments) {
            c.delete();
        }
    }
    

}
