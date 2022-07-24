package com.kcbgroup.main.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.kcbgroup.main.models.wsdl.StudentDetailsRequest;
import com.kcbgroup.main.models.wsdl.StudentDetailsResponse;
import com.kcbgroup.main.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
public class StudentEndpoint {

	@Autowired
	private StudentRepository studentRepository;
	private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
	@ResponsePayload
	public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
		log.info(request.toString());
		StudentDetailsResponse response = new StudentDetailsResponse();
		response.setStudent(studentRepository.findStudent(request.getName()));

		return response;
	}
}
