package com.assignment1_16thfeb;

import javax.persistence.*;
import java.util.*;

public class BlogService {

    private EntityManager em;
    private UsersDAO usersDAO;
    private PostDAO postDAO;
    private CommentsDAO commentsDAO;

    public BlogService(EntityManager em) {
        this.em = em;
        this.usersDAO = new UsersDAO(em);
        this.postDAO = new PostDAO(em);
        this.commentsDAO = new CommentsDAO(em);
    }

    // Register User
    public void registerUser(Users user) {
        usersDAO.saveUser(user);
    }

    //  Create Post
    public void createPost(int userId, Post post) {

        Users user = usersDAO.findUser(userId);

        post.setAuthor(user);
        post.setCreatedAt(java.time.LocalDateTime.now().toString());

        postDAO.savePost(post);

        user.getPost().add(post);
        usersDAO.updateUser(user);
    }

    //  Update Post
    public void updatePost(int postId, String newContent) {

        Post post = postDAO.findPost(postId);
        post.setContent(newContent);
        post.setUpdatedAt(java.time.LocalDateTime.now().toString());

        postDAO.updatePost(post);
    }

    //  Delete Post
    public void deletePost(int postId) {
        postDAO.deletePost(postId);
    }

    // Add Comment
    public void addComment(int userId, int postId, Comments comment) {

        Users user = usersDAO.findUser(userId);
        Post post = postDAO.findPost(postId);

        comment.setAuthor(user);
        comment.setPost(post);
        comment.setCreatedAt(java.time.LocalDateTime.now().toString());

        commentsDAO.saveComment(comment);

        user.getComment().add(comment);
        post.getComments().add(comment);

        usersDAO.updateUser(user);
        postDAO.updatePost(post);
    }

    //Fetch Posts by User
    public List<Post> getPostsByUser(int userId) {
        Users user = usersDAO.findUser(userId);
        return user.getPost();
    }

    //  Fetch Comments by Post
    public List<Comments> getCommentsByPost(int postId) {
        Post post = postDAO.findPost(postId);
        return post.getComments();
    }

    // Fetch Comments by User
    public List<Comments> getCommentsByUser(int userId) {
        Users user = usersDAO.findUser(userId);
        return user.getComment();
    }
}
