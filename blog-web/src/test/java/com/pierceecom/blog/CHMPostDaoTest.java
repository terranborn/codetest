package com.pierceecom.blog;

import com.pierceecom.blog.dao.impl.CHMPostDao;
import com.pierceecom.blog.domain.Post;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CHMPostDaoTest {

    private CHMPostDao dao;

    @Before
    public void init() {
        dao = new CHMPostDao();
    }

    @Test
    public void test1_empty() {
        assertEquals(dao.getAllPosts().size(), 0);
    }

    @Test
    public void test2_add_one() {
        dao.addPost(new Post("1","test title","test content"));
        assertEquals(dao.getAllPosts().size(), 1);
    }

    @Test
    public void test3_get_one() {
        dao.addPost(new Post("1","test title","test content"));
        assertEquals(dao.getAllPosts().size(), 1);

        Post post = dao.getPost("1");
        assertEquals(post.getTitle(),"test title");
        assertEquals(post.getContent(),"test content");
    }

    @Test
    public void test4_remove() {
        dao.addPost(new Post("1","test title","test content"));
        assertEquals(dao.getAllPosts().size(), 1);
        dao.remove("1");
        assertEquals(dao.getAllPosts().size(), 0);
    }

    @Test
    public void test5_add_multiple() {
        dao.addPost(new Post("1","test title","test content"));
        dao.addPost(new Post("2","test title 2","test content 2"));
        assertEquals(dao.getAllPosts().size(), 2);

        Post post = dao.getPost("1");
        assertEquals(post.getTitle(),"test title");
        assertEquals(post.getContent(),"test content");

        Post post2 = dao.getPost("2");
        assertEquals(post2.getTitle(),"test title 2");
        assertEquals(post2.getContent(),"test content 2");
    }

}
