package com.pierceecom.blog.ejb.impl;

import com.pierceecom.blog.dao.PostDao;
import com.pierceecom.blog.domain.Post;
import com.pierceecom.blog.ejb.PostService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
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
            throw new BadRequestException();
        }
        dao.addPost(post);
    }

    @Override
    public Post getPost(String id) {
        if (id == null) {
            throw new BadRequestException();
        }
        return dao.getPost(id);
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            throw new BadRequestException();
        } else if (dao.getPost(id) == null){
            throw new NotFoundException();
        }
        dao.remove(id);
    }
}
