package com.pierceecom.blog.ejb;

import com.pierceecom.blog.domain.Post;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PostService {

    List<Post> getAllPosts();

    void addPost(Post post);

    Post getPost(String id);

    void remove(String id);
}
