package org.wecan.messageBoard.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq=(HttpServletRequest)req;
        HttpServletResponse httpResp=(HttpServletResponse)resp;
        Object o=httpReq.getSession().getAttribute("user");
        if(o==null){
            httpResp.sendRedirect("https://www.baidu.com/"); //由于没前端主页,先默认跳到百度首页
        }else {
            chain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {
    }
}
