package com.gsafety.util;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket getApiInfo() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("outer api")
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(outApiInfo());

	}

	private ApiInfo outApiInfo() {
		return new ApiInfo(
				"mylearn 前后端接口-外部", // title 标题
				"外部接口文档", // description 描述 标题下
				"1.0.0", // version
				"http://mylearn/*", // termsOfService
				new Contact("肖东红","","xiaodonghong@gsafety.com"), // contact
				"Apache 2.0", // licence
				"http://www.apache.org/licenses/LICENSE-2.0.html" // licence url
				);

	}

	@Bean
	public UiConfiguration getUiConfig() {
		return new UiConfiguration(
				null,// url,暂不用
				"none",       // docExpansion          => none | list
				"alpha",      // apiSorter             => alpha
				"schema",     // defaultModelRendering => schema
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
				false,        // enableJsonEditor      => true | false
				true);        // showRequestHeaders    => true | false
	}
}