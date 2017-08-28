package com.pierceecom.blog.dao;

import com.pierceecom.blog.domain.Post;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PostDao {

    List<Post> getAllPosts();

    void addPost(Post post);

    Post getPost(String id);

    void remove(String id);
}
