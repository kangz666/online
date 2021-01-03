package filter;

import controller.RegisterServlet;
import sun.misc.Request;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kangz
 * @date 2021-01-03
 */
@WebFilter(filterName = "EncodingFilter",
        urlPatterns = {"/CartServlet", "/LoginServlet","/ManagerAddServlet","/ManagermentServlet","/ManagerServlet","/OrderServlet","/RegisterServlet"}
)
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        //设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        chain.doFilter(req, resp);//过滤完成,转到目标资源
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
