package com.siukatech.springcloud.configclient;

import com.siukatech.springcloud.configclient.ui.model.StatusInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Test Driven Development with Spring Boot - Sannidhi Jalukar, Madhura Bhave
 * https://www.youtube.com/watch?v=s9vt6UJiHg4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class SpringCloudConfigClientApplicationTests {

    final private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testStatus() {
        // arrange


        // act
        ResponseEntity<StatusInfo> response = restTemplate.getForEntity("/status", StatusInfo.class);
        logger.debug("testStatus - response.getBody: [{}]", response.getBody());

        // assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getAppConfigInfo().getLocal()).contains("Application Name");

    }

}
