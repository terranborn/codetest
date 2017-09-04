package com.pierceecom.blog;

import com.pierceecom.blog.domain.Post;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JerseyTestIntegr {

    private static final String ENDPOINT = "http://localhost:8080/blog-web/";
    private static final String PATH = "posts";

    @Test
    public void t1_empty() {
        List<Post> list = GET(200);
        assertEquals(0, list.size());
    }

    @Test
    public void t2_add() {
        Post post = new Post("1", "title 1", "content 1");
        POST(post, 201);
        Post post2 = new Post("2", "title 2", "content 2");
        POST(post2, 201);
    }

    @Test
    public void t3_get_all() {
        List<Post> list = GET(200);
        assertEquals(2, list.size());
    }

    @Test
    public void t4_get_single() {
        Post post1 = GET("1", 200);
        assertEquals("title 1", post1.getTitle());

        Post post2 = GET("2", 200);
        assertEquals("title 2", post2.getTitle());
    }

    @Test
    public void t5_delete_all() {
        DELETE("1", 200);

        DELETE("2", 200);
    }

    @Test
    public void t6_empty() {
        List<Post> list = GET(200);
        assertEquals(0, list.size());
    }

    private void DELETE(String id, int expectedResponse) {
        Invocation.Builder request = prepareBuilder(ENDPOINT, PATH, id);
        Response response = request.delete();

        assertEquals(expectedResponse, response.getStatus());
    }

    private void POST(Post post, int expectedResponse) {
        Invocation.Builder request = prepareBuilder(ENDPOINT, PATH);

        Response response = request.post(Entity.entity(post, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(expectedResponse, response.getStatus());

    }

    private Post GET(String uri, int expectedResponse) {
        Invocation.Builder request = prepareBuilder(ENDPOINT, PATH, uri);
        Response response = request.get();
        assertEquals(expectedResponse, response.getStatus());

        Post post = response.readEntity(Post.class);

        return post;
    }

    private List<Post> GET(int expectedResponse) {

        Invocation.Builder request = prepareBuilder(ENDPOINT, PATH);

        Response response = request.get();

        List<Post> list = response.readEntity(List.class);

        assertEquals(expectedResponse, response.getStatus());

        return list;
    }

    private Invocation.Builder prepareBuilder(String endpoint, String path) {
        return prepareBuilder(endpoint, path, null);
    }

    private Invocation.Builder prepareBuilder(String endpoint, String path, String uri) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(endpoint).path(path);
        if (uri != null) {
            target = target.path(uri);
        }
        return target.request(MediaType.APPLICATION_JSON_TYPE);
    }
}
