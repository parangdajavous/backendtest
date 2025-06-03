package co.kr.metacoding.backendtest.core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class UriFilter implements Filter {

    private static final Pattern SAFE_URL_PATTERN = Pattern.compile("^[a-zA-Z0-9\\?&=:/]*$");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String rawUri = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();


        String fullUri = rawUri + (queryString != null ? "?" + queryString : "");
        // 디코딩된 URI 검사
        String decodedUri = URLDecoder.decode(fullUri, StandardCharsets.UTF_8);

        if (!SAFE_URL_PATTERN.matcher(decodedUri).matches()) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"reason\": \"요청 주소에 허용되지 않은 문자가 포함되어 있습니다.\"}");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
