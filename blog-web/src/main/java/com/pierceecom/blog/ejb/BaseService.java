package com.pierceecom.blog.ejb;

import com.pierceecom.blog.shared.ApplicationException;

public abstract class BaseService {

    protected void handleApplicationError(ApplicationException.TYPE type){
        //TODO: additionally some logging mechanism here
        throw new ApplicationException(type);
    }
}
