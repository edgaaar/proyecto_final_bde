package com.geounam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bedatadriven.jackson.datatype.jts.JtsModule;

@Configuration
public class GeojsonConfigure {

	
	@Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }
}
