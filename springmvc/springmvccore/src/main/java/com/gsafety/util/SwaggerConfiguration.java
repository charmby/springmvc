package com.gsafety.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc      // 启用Mvc //非springboot框架需要引入注解@EnableWebMvc。不配置这个不能扫描，Controller中的request的url请求
@EnableSwagger2  //@Configuration和@EnableSwagger2是最少的两个注解。并且配置后，还需要在springmvc的xml文件中配置。该类的bean
public class SwaggerConfiguration {

	@Bean
	public Docket getApiInfo() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("rest接口信息")
				.select()   //选择哪些路径和API会生成document
				.apis(RequestHandlerSelectors.any()) // 对所有api进行监控
				.paths(PathSelectors.any())  // 对所有路径进行监控
				.build()
				.apiInfo(outApiInfo());

	}

	

	private ApiInfo outApiInfo() {
		return new ApiInfo(
				"springmvc的各项验证信息", // title 标题
				"springmvc的各项外部接口信息", // description 描述 标题下
				"1.0.0", // version
				"http://mylearn/*", // termsOfService
				new Contact("肖东红","","xiaodonghong@gsafety.com"), // contact
				"Apache 2.0", // licence
				"http://www.apache.org/licenses/LICENSE-2.0.html" // licence url
				);

	}

/*	@Bean
	public UiConfiguration getUiConfig() {
		return new UiConfiguration(
				null,// url,暂不用
				"none",       // docExpansion          => none | list
				"alpha",      // apiSorter             => alpha
				"schema",     // defaultModelRendering => schema
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
				true,        // enableJsonEditor      => true | false
				false);        // showRequestHeaders    => true | false
	}*/
}