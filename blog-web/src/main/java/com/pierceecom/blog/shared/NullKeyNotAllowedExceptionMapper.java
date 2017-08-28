package com.pierceecom.blog.shared;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NullKeyNotAllowedExceptionMapper implements ExceptionMapper<NullKeyNotAllowedException> {

    @Override
    public Response toResponse(NullKeyNotAllowedException e) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
