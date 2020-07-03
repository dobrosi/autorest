package com.github.dobrosi.autorest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Service
public class EndpointService {

	@Autowired
	private QueryController queryController;

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;

	public void addMapping(final String urlPath) throws NoSuchMethodException {

		RequestMappingInfo requestMappingInfo =
				RequestMappingInfo.paths(urlPath).methods(RequestMethod.GET).produces(MediaType.APPLICATION_JSON_VALUE).build();

		requestMappingHandlerMapping
				.registerMapping(requestMappingInfo, queryController, QueryController.class.getDeclaredMethod("handleRequests", String.class));
	}

	@PostConstruct
	public void created() {
		try {
			addMapping("/hello");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}