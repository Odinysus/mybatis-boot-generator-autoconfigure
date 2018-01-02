package com.odinysus.mybatisboot.generator.autoconfigure;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class CoderGeneratorAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Test
    public void testGeneratorAutoConfiguration() {
        load();
        AutoGenerator autoGenerator = context.getBean(AutoGenerator.class);
        assertNotNull(autoGenerator);
    }

    @After
    public void tearDown() {
        if (this.context != null) {
            this.context.close();
        }
    }

    private void load() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CoderGeneratorAutoConfiguration.class);
        applicationContext.refresh();
        this.context = applicationContext;
    }

}