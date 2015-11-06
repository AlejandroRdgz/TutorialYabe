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
import play.db.jpa.Model;

/**
 *
 * @author alejandro
 */
@Entity
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
    @ManyToOne
    public User author;

    /*public Post(User author, String title, String content) {
     this.author = author;
     this.title = title;
     this.content = content;
     this.postedAt = new Date();
     }*/
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<Tag> tags;
    
    public Post(User author, String title, String content) {
        this.comments = new ArrayList<Comment>();
        this.tags = new TreeSet<Tag>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();

    }

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        this.save();
        return this;
    }

    public Post previous() {
        return Post.find("postedAt < ? order by postedAt desc", postedAt)
                .first();
    }

    public Post next() {
        return Post.find("postedAt > ? order by postedAt asc", postedAt)
                .first();
    }
    
    public Post tagItWith(String name){
        tags.add(Tag.findOrCreateByName(name));
        return(this);
    }
    
    public static List<Post> findTaggedWith(String... tags){
        return Post.find(
                "select distinct p from Post p join p.tags as t where t.name in (:tags) group by p.id, p.author, p.title, p.content,p.postedAt having count(t.id) = :size"
                ).bind("tags", tags).bind("size", tags.length).fetch();
    }
    
    
    
    

}
