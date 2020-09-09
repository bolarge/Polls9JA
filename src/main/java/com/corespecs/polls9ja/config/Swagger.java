/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.corespecs.polls9ja.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Java config for Springfox swagger documentation plugin
 *
 * @author Bolaji Salau
 *
 */

@Configuration
@EnableSwagger2
@ComponentScan(basePackages="com.corespecs.polls9ja")
public class Swagger {

   @Bean
   public Docket customDocket(){
      return new Docket(DocumentationType.SWAGGER_2)
    		  .select()
              //.apis(RequestHandlerSelectors.any())
              //.paths(PathSelectors.any())
			  .apis(RequestHandlerSelectors.basePackage("com.corespecs.polls9ja"))
			  .paths(PathSelectors.ant("/v2/**"))
              .build()
              .apiInfo(getApiInfo());
   }

	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"REST Polls9JA backend Api Documentation",
				"This is REST API documentation of the Polls9JA backend. If authentication is enabled, when calling the APIs use admin/admin",
				"1.0",
				"Polls9JA backend terms of service",
				new Contact(
						"Bolaji Salau",
						"https://github.com/bolarge/polls9JA",
						"bolaji.salau@gmail.com"),
				"Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}


}
