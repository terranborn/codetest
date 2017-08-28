package com.pierceecom.blog.ws;

import com.pierceecom.blog.domain.Post;
import com.pierceecom.blog.ejb.PostService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RESTPostServiceImpl extends BaseRESTService<Post> {

    @EJB
    private PostService service;

    @GET
    public Response posts() {
        GenericEntity<List<Post>> genericEntity = new GenericEntity<List<Post>>(service.getAllPosts()) {
        };
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id:[0-9]+}")
    public Response post(@PathParam("id") String id) {
        return handleContent(service.getPost(id));
    }

    @POST
    public Response create(Post post) throws URISyntaxException {
        service.addPost(post);
        return Response.created(new URI("posts/" + post.getId())).build();
    }

    @DELETE
    @Path("/{id:[0-9]+}")
    public Response remove(@PathParam("id") String id) {
        service.remove(id);
        return Response.ok().build();
    }
}
