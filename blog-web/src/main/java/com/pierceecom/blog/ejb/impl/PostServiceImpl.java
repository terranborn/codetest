package com.pierceecom.blog.ejb.impl;

import com.pierceecom.blog.dao.PostDao;
import com.pierceecom.blog.domain.Post;
import com.pierceecom.blog.ejb.PostService;
import com.pierceecom.blog.shared.NotFoundException;
import com.pierceecom.blog.shared.NullKeyNotAllowedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PostServiceImpl implements PostService {

    @Inject
    private PostDao dao;

    @Override
    public List<Post> getAllPosts() {
        return dao.getAllPosts();
    }

    @Override
    public void addPost(Post post) {
        if (post == null || post.getId() == null) {
            throw new NullKeyNotAllowedException();
        }
        dao.addPost(post);
    }

    @Override
    public Post getPost(String id) {
        if (id == null) {
            throw new NullKeyNotAllowedException();
        }
        return dao.getPost(id);
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            throw new NullKeyNotAllowedException();
        } else if (dao.getPost(id) == null) {
            throw new NotFoundException();
        }
        dao.remove(id);
    }
}
