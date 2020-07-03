package com.github.dobrosi.autorest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {

	public ResponseEntity<String> handleRequests(final String name) throws Exception {

		System.out.println("name: " + name);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}