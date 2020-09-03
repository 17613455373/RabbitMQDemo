package com.rabbitmq.provider.configuration;

/**
 * Created by shenyong on 2018/6/28.
 */

import com.rabbitmq.provider.respon.ApiReturnInfo;
import com.rabbitmq.provider.respon.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * 返回Rest错误信息
 */
@RestControllerAdvice
public class RestErrorEndpoint {
    private final static Logger logger = LoggerFactory.getLogger(RestErrorEndpoint.class);

    @ExceptionHandler
    public ApiReturnInfo handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        logger.error("************************异常开始*******************************");
        ApiReturnInfo ar = new ApiReturnInfo();
        logger.info("Restful Http请求发生异常...");
        if (e instanceof NullPointerException) {
            logger.error("NullPointerException：" + e.getMessage(), e);
            ar.setCode(ResultCodeEnum.NullPointerException.getCode());
            ar.setMessage(ResultCodeEnum.NullPointerException.getMessage());
        } else if (e instanceof IllegalArgumentException) {
            logger.error("IllegalArgumentException：" + e.getMessage(), e);
            ar.setCode(ResultCodeEnum.IllegalArgumentException.getCode());
            ar.setMessage(ResultCodeEnum.IllegalArgumentException.getMessage());
        } else if (e instanceof SQLException) {
            ar.setCode(ResultCodeEnum.SQLException.getCode());
            ar.setMessage(ResultCodeEnum.SQLException.getMessage());
            logger.error("SQLException：" + e.getMessage(), e);
        }else if (e instanceof BindException){
            ar.setCode(ResultCodeEnum.IllegalArgumentException.getCode());
            ar.setMessage(((BindException) e).getFieldError().getDefaultMessage());
        } else {
            logger.error("ServerError：" + e.getMessage(), e);
            ar.setCode(ResultCodeEnum.ServerExceprion.getCode());
            ar.setMessage(ResultCodeEnum.ServerExceprion.getMessage());
        }
        logger.error("************************异常结束*******************************");
        return  ar;
    }

    private String getParameter(HttpServletRequest request) {
        StringBuffer context = new StringBuffer();
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            context.append(name + "=" + request.getParameter(name)).append("&");
        }
        return context.toString();
    }


}