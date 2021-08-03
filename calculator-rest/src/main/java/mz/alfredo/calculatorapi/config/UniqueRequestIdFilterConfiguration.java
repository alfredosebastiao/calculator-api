package mz.alfredo.calculatorapi.config;

import mz.alfredo.calculatorapi.filter.UniqueRequestIdFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UniqueRequestIdFilterConfiguration {

    @Bean
    public FilterRegistrationBean<UniqueRequestIdFilter> servletRegistrationBean() {
        final FilterRegistrationBean<UniqueRequestIdFilter> registrationBean = new FilterRegistrationBean<>();
        final UniqueRequestIdFilter log4jMDCFilterFilter = new UniqueRequestIdFilter();
        registrationBean.setFilter(log4jMDCFilterFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
