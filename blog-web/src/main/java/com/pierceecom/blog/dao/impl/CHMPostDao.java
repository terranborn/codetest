package com.pierceecom.blog.dao.impl;

import com.pierceecom.blog.dao.PostDao;
import com.pierceecom.blog.domain.Post;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class CHMPostDao implements PostDao {

    private ConcurrentHashMap<String, Post> map = new ConcurrentHashMap<>();

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void addPost(Post post) {
        map.put(post.getId(), post);
    }

    @Override
    public Post getPost(String id) {
        return map.get(id);
    }

    @Override
    public void remove(String id) {
        map.remove(id);
    }
}
