package com.pierceecom.blog.ejb.impl;

import com.pierceecom.blog.dao.PostDao;
import com.pierceecom.blog.domain.Post;
import com.pierceecom.blog.ejb.BaseService;
import com.pierceecom.blog.ejb.PostService;
import com.pierceecom.blog.shared.ApplicationException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class PostServiceImpl extends BaseService implements PostService {

    @Inject
    private PostDao dao;

    @Override
    public List<Post> getAllPosts() {
        return dao.getAllPosts();
    }

    @Override
    public void addPost(Post post) {
        if (post == null || post.getId() == null) {
            handleApplicationError(ApplicationException.TYPE.NULL_KEY_NOT_ALLOWED);
        }
        dao.addPost(post);
    }

    @Override
    public Post getPost(String id) {
        if (id == null) {
            handleApplicationError(ApplicationException.TYPE.NULL_KEY_NOT_ALLOWED);
        }
        return dao.getPost(id);
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            handleApplicationError(ApplicationException.TYPE.NULL_KEY_NOT_ALLOWED);
        } else if (dao.getPost(id) == null) {
            handleApplicationError(ApplicationException.TYPE.NOT_FOUND);
        }
        dao.remove(id);
    }
}
