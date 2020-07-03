package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import java.util.Map;
import java.util.Set;

@WebFilter(filterName = "EncodingFilter", urlPatterns = { "/*" })
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         // 1. ServletRequest 转成 HttpServletRequest
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse rep = (HttpServletResponse)response;
        // 2. 如果是GET，就生成一个Wrapper对象，覆盖获取参数的方法进行转码
        if("GET".equalsIgnoreCase(req.getMethod())) {
            req = new MyRequest(req);
        }// 3. 如果是POST，request.setCharacterEncoding("UTF-8")
        else if("POST".equalsIgnoreCase(req.getMethod())) {
            req.setCharacterEncoding("UTF-8");
        }
        // 4.调用chain.doFilter继续向后执行
        rep.setContentType("text/html;charset=utf-8");
        rep.setCharacterEncoding("UTF-8");

        chain.doFilter(req, response);
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}


class MyRequest extends HttpServletRequestWrapper {

    private boolean hasEncode=false;
    private HttpServletRequest request;

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }
 
    public String changeEncoding(String input, String srcEncoding, String targetEncoding) {
        try {
            byte[] data = input.getBytes(srcEncoding);
            return new String(data, targetEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return input;
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
 
        if(value != null) {
            value = changeEncoding(value, "ISO8859-1", "UTF-8");
        }
        return value;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);

        if(values != null && values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                values[i] = changeEncoding(value, "ISO8859-1", "UTF-8");
            }
        }
        return values;
    }
 
    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String method = request.getMethod();

        if (method.equalsIgnoreCase("post")) {
            return parameterMap;
        }
  
        if (!hasEncode) {
            Set<String> keys = parameterMap.keySet();
            for (String key : keys) {
                String[] values = parameterMap.get(key);
                if (values == null) {
                    continue;
                }
                for (int i = 0; i < values.length; i++) {
                    String value = values[i];
                    try {
                        value = new String(value.getBytes("ISO-8859-1"), "utf-8");
                        values[i] = value;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                hasEncode = true;
            }
        }
        return parameterMap;
    }
}