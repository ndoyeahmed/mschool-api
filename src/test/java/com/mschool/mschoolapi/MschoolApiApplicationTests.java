package com.mschool.mschoolapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MschoolApiApplicationTests {

    @Test
    public void contextLoads() {
        assertThat(true).isEqualTo(true);
    }

}
