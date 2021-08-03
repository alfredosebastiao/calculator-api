package mz.alfredo.calculatorapi.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class UniqueRequestIdFilter extends OncePerRequestFilter {

    private static final String RESPONSE_HEADER = "requestId";
    private static final String MDC_KEY = "requestId";


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            final String token = UUID.randomUUID().toString().toUpperCase().replace("-", "");
            MDC.put(MDC_KEY, token);
            if (StringUtils.hasText(RESPONSE_HEADER)) {
                httpServletResponse.addHeader(RESPONSE_HEADER, token);
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            MDC.remove(MDC_KEY);
        }
    }

    @Override
    protected boolean isAsyncDispatch(final HttpServletRequest request) {
        return false;
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }

    public static String getMdcKey(){
        return MDC_KEY;
    }
}
