package org.egov.filter.post;

import javax.servlet.http.HttpServletResponse;

import org.egov.filter.utils.FilterConstant;

import com.netflix.client.http.HttpHeaders;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ResponseFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println("ResponseFilter");
		HttpServletResponse httpServletResponse = ctx.getResponse();
		//httpServletResponse.getHeaders()
	//	ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        ctx.getResponse().setHeader(org.apache.http.HttpHeaders.CONTENT_TYPE, "application/json");
     //   ctx.getResponse().setCharacterEncoding(CharsetConstants.CHARSET_UTF8);
		ctx.setResponseBody((String)ctx.get(FilterConstant.RESPONSE_BODY));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 999;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

}
