package com.pierceecom.blog.shared;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

    @Override
    public Response toResponse(ApplicationException e) {

        Response.Status status = null;

        switch (e.getType()) {
            case NOT_FOUND:
                status = Response.Status.NOT_FOUND;
                break;
            case NULL_KEY_NOT_ALLOWED:
                status = Response.Status.BAD_REQUEST;
                break;
        }

        return Response.status(status).build();
    }
}
