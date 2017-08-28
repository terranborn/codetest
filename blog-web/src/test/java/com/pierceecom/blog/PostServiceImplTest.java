package com.pierceecom.blog;

import com.pierceecom.blog.ejb.impl.PostServiceImpl;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.BadRequestException;

import static org.junit.Assert.assertTrue;

public class PostServiceImplTest {

    private PostServiceImpl service;

    @Before
    public void init() {
        service = new PostServiceImpl();
    }

    //TODO: use some mocking framework (MOCKITO) to inject DAO mock to be pure UNIT test or test only behaviour that don't use DAO

    @Test
    public void test1_add_bad_one() {
        try {
            service.addPost(null);
            assertTrue("should throw an exception", false);
        } catch (Exception e) {
            if (!(e instanceof BadRequestException)){
                assertTrue("should throw an BadRequestException", false);
            }
        }
    }

    @Test
    public void test2_get_bad(){
        try {
            service.getPost(null);
            assertTrue("should throw an exception", false);
        } catch (Exception e) {
            if (!(e instanceof BadRequestException)){
                assertTrue("should throw an BadRequestException", false);
            }
        }
    }

    @Test
    public void test3_remove_bad(){
        try {
            service.remove(null);
            assertTrue("should throw an exception", false);
        } catch (Exception e) {
            if (!(e instanceof BadRequestException)){
                assertTrue("should throw an BadRequestException", false);
            }
        }
    }


}
