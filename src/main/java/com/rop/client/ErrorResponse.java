/**
 *
 * 日    期：12-2-10
 */
package com.rop.client;

import com.rop.CommonConstant;

import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class ErrorResponse{

    @XmlAttribute
    protected String errorToken = CommonConstant.ERROR_TOKEN;

    @XmlAttribute
    protected String code;

    @XmlElement
    protected String message;

    @XmlElement
    protected String solution;

    @XmlElementWrapper(name = "subErrors")
    @XmlElement(name = "subError")
    protected List<SubError> subErrors;

    public ErrorResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public List<SubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<SubError> subErrors) {
        this.subErrors = subErrors;
    }

    public void addSubError(SubError subError){
        if (subErrors == null) {
            subErrors = new ArrayList<SubError>();
        }
        subErrors.add(subError);
    }

    public String getErrorToken() {
        return errorToken;
    }

    /**
     * 对服务名进行标准化处理：如book.upload转换为book-upload，
     *
     * @param method
     * @return
     */
    protected String transform(String method) {
        if(method != null){
            method = method.replace(".", "-");
            return method;
        }else{
            return "LACK_METHOD";
        }
    }

}

