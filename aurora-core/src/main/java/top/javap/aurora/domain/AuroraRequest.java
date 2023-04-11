package top.javap.aurora.domain;

import top.javap.aurora.enums.HttpMethod;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: pch
 * @description:
 * @date: 2023/4/10
 **/
public class AuroraRequest {

    private final String url;
    private final HttpMethod method;
    private Map<String, Object> params = new HashMap<>();
    private Map<String, Object> headers = new HashMap<>();
    private String body;
    private Type returnType;

    public AuroraRequest(String url, HttpMethod method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public String getFullUrl() {
        String fullUrl = url;
        boolean first = true;
        for (Map.Entry<String, Object> e : params.entrySet()) {
            fullUrl += (first ? "?" : "&") + e.getKey() + "=" + e.getValue();
            first = false;
        }
        return fullUrl;
    }
}