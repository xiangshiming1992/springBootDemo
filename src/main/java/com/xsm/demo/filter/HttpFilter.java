package com.xsm.demo.filter;

import com.xsm.demo.common.global.Configure;
import com.xsm.demo.common.utils.http.MutableHttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "httpFilter", urlPatterns = "/*")
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI().trim().replaceAll("/{2,10}", "/");
        //获取项目路径
        String path = req.getContextPath();
        String basePath = "//"+req.getServerName()+path+"/";
        if(isIp(req.getServerName()) || "localhost".equals(req.getServerName())){
            basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
        }
        req.setAttribute("basePath", basePath);
        req.setAttribute("rootUrl", Configure.getRootUrl());
        String origin = "*";
        String referer = req.getHeader("Referer");
        if(StringUtils.isNotBlank(referer)){
            String[] arr = referer.split("/");
            if(arr.length>2){
                origin = StringUtils.join(arr, "/", 0, 3);
            }
        }
        //处理跨域
        resp.setHeader("Access-Control-Allow-Origin",origin);
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with,jsessionid,Content-Type,tokenInfo");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        //在不是指定的特殊里面情况 做判断
        if(uri.startsWith(path+"/web/") && req.getSession().getAttribute("adminLoginStats")==null){
            resp.sendRedirect(basePath+"login");
            return;
        }
        chain.doFilter(doRequestAddHeader(req), response);
    }
    @Override
    public void destroy() {
    }
    /**
     * 处理拦截往header加登录ID--token信息中获取
     * @param req
     * @return
     */
    public HttpServletRequest doRequestAddHeader(HttpServletRequest req){
        String tokenInfo = req.getHeader("tokenInfo");
        if(StringUtils.isBlank(tokenInfo)){
            return req;
        }
        if (tokenInfo == null || tokenInfo.length() == 0) {
            return req;
        }
        String [] param = tokenInfo.split("_");
        if (param.length != 2) {
            return req;
        }
        String userId = param [0];
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);
        mutableRequest.addHeader("userId", userId);
        return mutableRequest;
    }
    /**
     * 判断是否是一个IP
     * @param IP
     * @return
     */
    public boolean isIp(String IP){
        boolean b = false;
        if(IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")){
            String s[] = IP.split("\\.");
            if(Integer.parseInt(s[0])<255)
                if(Integer.parseInt(s[1])<255)
                    if(Integer.parseInt(s[2])<255)
                        if(Integer.parseInt(s[3])<255)
                            b = true;
        }
        return b;
    }
}