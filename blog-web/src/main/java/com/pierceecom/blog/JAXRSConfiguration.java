package com.pierceecom.blog;

import com.pierceecom.blog.shared.NotFoundExceptionMapper;
import com.pierceecom.blog.shared.NullKeyNotAllowedExceptionMapper;
import com.pierceecom.blog.ws.RESTPostServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class JAXRSConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(HelloPierceResource.class);
        classes.add(RESTPostServiceImpl.class);
        classes.add(NullKeyNotAllowedExceptionMapper.class);
        classes.add(NotFoundExceptionMapper.class);
        return classes;
    }
}
