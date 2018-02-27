package org.egov;

import org.egov.filter.post.ResponseFilter;
import org.egov.filter.pre.AuthFilter;
import org.egov.filter.pre.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class TranslatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslatorApplication.class, args);
	}
	
	@Bean
	public AuthFilter authFilter() {
		return new AuthFilter();
	}
	
	@Bean
	public RequestFilter requestFilter() {
		return new RequestFilter();
	}
	
	@Bean
	public ResponseFilter responseFilter() {
		return new ResponseFilter();
	}
	
	/*@Bean
	public RequestRoutFilter requestRoutFilter() {
		return new RequestRoutFilter();
	}*/
}
