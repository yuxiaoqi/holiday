package com.yyq.holiday.common.handler;

import com.yyq.holiday.common.util.ArmsLogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcg on 15/10/5.
 */
@ControllerAdvice
public class ErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);


    @Autowired
    private ArmsLogUtil armsLogUtil;


/**
     * 业务级异常的捕获
     *
     * @param
     * @return
     * @throws Exception
     */

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public void applicationErrorHandler(RuntimeException e) throws Exception {
        LOGGER.warn("异常信息为：{}", e);
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", e.getMessage());
        armsLogUtil.track("tettetetete", properties);
    }


/**
     * 业务级异常的捕获
     *
     * @param e
     * @return
     * @throws Exception
     *//*

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public void AccessErrorHandler(AccessDeniedException e) throws Exception {
        LOGGER.warn("异常信息为：{}", e);
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", e.getMessage());
        armsLogUtil.track(AramsTypeEnums.UNKNOW_EXCPTION.getValue(), properties);
    }

    */
/**
     * get请求参数的验证
     *
     * @return
     *//*

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void errorResponse(MissingServletRequestParameterException e) {
        LOGGER.warn("异常信息为：{}", e);

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", e.getMessage());
        armsLogUtil.track(AramsTypeEnums.UNKNOW_EXCPTION.getValue(), properties);
    }

    */
/**
     * post请求参数的验证 表单提交校验时会报这个错
     *
     * @return 返回具体vo注解上的message
     *//*

    @ExceptionHandler(value = BindException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void errorResponse(BindException e) {
        LOGGER.warn("异常信息为：{}", e);
        BasicErrorCodeEnum errorCode = BasicErrorCodeEnum.PARAM_VALID_ERROR;
        if (e.hasErrors()) {
            List<ObjectError> errors = e.getAllErrors();
            errorCode.setDesc(errors.get(errors.size() - 1).getDefaultMessage());
        }

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", "errorCode:"+errorCode+","+e.getMessage());
        armsLogUtil.track(AramsTypeEnums.UNKNOW_EXCPTION.getValue(), properties);
    }

    */
/**
     * post请求参数的验证 json方式提交校验时会报这个错
     *
     * @return
     *//*

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void errorResponse(MethodArgumentNotValidException e) {
        LOGGER.warn("异常信息为：{}", e);
        BasicErrorCodeEnum errorCode = BasicErrorCodeEnum.PARAM_VALID_ERROR;
        if (e.getBindingResult().hasErrors()) {
            List<ObjectError> errors = e.getBindingResult().getAllErrors();
            errorCode.setDesc(errors.get(errors.size() - 1).getDefaultMessage());
        }

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", "errorCode:"+errorCode+","+e.getMessage());
        armsLogUtil.track(AramsTypeEnums.UNKNOW_EXCPTION.getValue(), properties);
    }

    */
/**
     * motan handler 异常处理
     *
     * @param e
     * @return
     *//*

    @ExceptionHandler(value = MotanServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void errorResponse(MotanServiceException e) {
        LOGGER.warn("异常信息为：{}", e);
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", e.getMessage());
        armsLogUtil.track(AramsTypeEnums.MOTAN_SERVICE_ERROR.getValue(), properties);
    }

*/

    /**
     * handler 异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void errorResponse(HttpServletRequest request, Exception e) {
        LOGGER.error("异常uri：{}.", request.getRequestURI(), e);
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("message", e.getMessage());
        armsLogUtil.track("异常测试======", properties);
    }

}

