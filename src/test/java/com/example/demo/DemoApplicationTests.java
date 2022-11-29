package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.pojos.DemoEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void canRetrieveByIdWhenDoesNotExist() {
		
		// when
	    ResponseEntity<DemoEntity> demoResponse = restTemplate.getForEntity("/demo/2", DemoEntity.class);
	
	    // then
	    assertThat(demoResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	    assertThat(demoResponse.getBody().getId()).isEqualTo("2");
	    assertThat(demoResponse.getBody().getLinks().iterator().next().getHref()).isEqualTo("http://localhost:8080/demo/2");
	}
}
