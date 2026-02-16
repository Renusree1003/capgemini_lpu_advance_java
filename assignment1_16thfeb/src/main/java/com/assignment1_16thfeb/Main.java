package com.assignment1_16thfeb;

import javax.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        BlogService service = new BlogService(em);

        //to register user

        Users user = new Users();
        user.setName("Renu");
        user.setPassword("12345");
        user.setEmail("renu@gmail.com");

        service.registerUser(user);

        System.out.println("User Registered Successfully");

        
        Users savedUser = service.getPostsByUser(1) == null
                ? em.find(Users.class, 1)
                : em.find(Users.class, 1);

        //to create post

        Post post = new Post();
        post.setTitle("Hibernate Guide");
        post.setContent("This is Hibernate tutorial");

        service.createPost(1, post);

        System.out.println("Post Created Successfully");

       //to update post

        service.updatePost(1, "Updated Hibernate tutorial content");

        System.out.println("Post Updated Successfully");

        //to add comment

        Comments comment = new Comments();
        comment.setContent("Very Helpful Post!");

        service.addComment(1, 1, comment);

        System.out.println("Comment Added Successfully");

        //to fetch posts by user

        List<Post> userPosts = service.getPostsByUser(1);

        System.out.println("Posts by User:");
        for (Post p : userPosts) {
            System.out.println(p);
        }

     //fetch comments of a post

        List<Comments> postComments =
                service.getCommentsByPost(1);

        System.out.println("Comments on Post:");
        for (Comments c : postComments) {
            System.out.println(c);
        }

        //fetch comments by user

        List<Comments> userComments =
                service.getCommentsByUser(1);

        System.out.println("Comments by User:");
        for (Comments c : userComments) {
            System.out.println(c);
        }

       //to delete post

        service.deletePost(1);

        System.out.println("Post Deleted Successfully");

        em.close();
        emf.close();
    }
}
