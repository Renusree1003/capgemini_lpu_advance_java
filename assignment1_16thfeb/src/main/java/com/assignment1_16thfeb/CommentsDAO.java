package com.assignment1_16thfeb;

import javax.persistence.*;
import java.util.List;

public class CommentsDAO {

    private EntityManager em;

    public CommentsDAO(EntityManager em) {
        this.em = em;
    }

    // Save Comment
    public void saveComment(Comments comment) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(comment);
        et.commit();
    }

    // Find Comment
    public Comments findComment(int id) {
        return em.find(Comments.class, id);
    }

    // Delete Comment
    public void deleteComment(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Comments comment = em.find(Comments.class, id);
        if (comment != null) {
            em.remove(comment);
        }

        et.commit();
    }

    // Get Comments by Post
    public List<Comments> findCommentsByPost(Post post) {
        return post.getComments();
    }

    // Get Comments by User
    public List<Comments> findCommentsByUser(Users user) {
        return user.getComment();
    }
}
