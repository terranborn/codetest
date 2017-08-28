package com.pierceecom.blog.ws;

import javax.ws.rs.core.Response;

public abstract class BaseRESTService<T> {

    public Response handleContent(T t){
        Response response;
        if (t == null) {
            response = Response.noContent().build();
        } else {
            response = Response.ok(t).build();
        }
        return response;
    }
}
