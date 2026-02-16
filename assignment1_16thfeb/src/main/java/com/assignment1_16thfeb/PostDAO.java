package com.assignment1_16thfeb;

import javax.persistence.*;
import java.util.List;

public class PostDAO {

    private EntityManager em;

    public PostDAO(EntityManager em) {
        this.em = em;
    }

    // Save Post
    public void savePost(Post post) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(post);
        et.commit();
    }

    // Find Post
    public Post findPost(int id) {
        return em.find(Post.class, id);
    }

    // Update Post
    public void updatePost(Post post) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(post);
        et.commit();
    }

    // Delete Post
    public void deletePost(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Post post = em.find(Post.class, id);
        if (post != null) {
            em.remove(post);
        }

        et.commit();
    }

    // Get Posts by User
    public List<Post> findPostsByUser(Users user) {
        return user.getPost();
    }
}
