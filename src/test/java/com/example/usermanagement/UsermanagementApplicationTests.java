package com.example.usermanagement;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsermanagementApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void createUser() {

		UserDto userDto = new UserDto();
		userDto.setFirstName("dimitra");

		HttpEntity<UserDto> httpEntity = new HttpEntity<>(userDto);
		httpEntity.getHeaders().add("Content-Type", "application/json");
		ResponseEntity<UserDto> responseEntity = testRestTemplate.exchange("/user", HttpMethod.POST,httpEntity,UserDto.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		UserDto returnedUserDto = responseEntity.getBody();

		UUID.fromString(returnedUserDto.getId());
		assertEquals("test@test.com",returnedUserDto.getEmail());



	}

}
