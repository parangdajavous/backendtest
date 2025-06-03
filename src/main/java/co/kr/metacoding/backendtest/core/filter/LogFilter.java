package co.kr.metacoding.backendtest.core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String ip = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");

        String msg = "[로그] IP: ${ip} | UA: ${ua}"
                .replace("${ip}", ip)
                .replace("${ua}", userAgent != null ? userAgent : "");
        log.info(msg);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
