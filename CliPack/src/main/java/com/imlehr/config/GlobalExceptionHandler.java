package com.imlehr.config;



import com.imlehr.javabean.MyException;
import com.imlehr.javabean.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 这是用来处理全局报错的
 *
 * @author lehr
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     */
    @ExceptionHandler
    public ResponseMsg handleException(HttpServletRequest request, HttpServletResponse response, final Exception exc) throws Exception {

        log.warn("遇到异常:"+exc.getClass()+":"+exc.getMessage(),exc);

        Throwable e = exc;

        if( e instanceof UndeclaredThrowableException)
        {
            e = ((UndeclaredThrowableException) exc).getUndeclaredThrowable();
        }
        if(e instanceof MyException)
        {
            MyException e1 = (MyException) e;
            response.setStatus(e1.getStatusCode());
            return ResponseMsg.ofFail(e1);
        }
        if(e instanceof UnauthenticatedException)
        {
            return ResponseMsg.ofFail(new MyException("需要登录","403",403));
        }
        else
        {
            response.setStatus(500);
            return ResponseMsg.ofFail(new MyException(e.getMessage(),"500"));
        }

    }

}

