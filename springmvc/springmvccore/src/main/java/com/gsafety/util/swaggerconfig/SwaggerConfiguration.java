package com.gsafety.util.swaggerconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger  = LoggerFactory.getLogger(SwaggerConfiguration.class);
	@Bean
	public Docket getApiInfo() {
		logger.info("配置了名称为：项目所有Restfule接口 的分组。 过滤了所有的rest请求。");
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("all rest Api")
				.select()   //选择哪些路径和API会生成document
				.apis(RequestHandlerSelectors.any()) // 对所有api进行监控
				.paths(PathSelectors.any())  // 对所有路径进行监控
				.build()
				.apiInfo(outApiInfo());
	}
	
	private ApiInfo outApiInfo() {
		logger.info("swagger的各项信息。");
		return new ApiInfo(
				"springmvc的各项验证信息", // title 标题
				"springmvc的各项外部接口信息", // description 描述 标题下
				"1.0.0", // version
				"http://localhost:8080/springmvcweb/*", // termsOfService
				new Contact("肖东红","","xiaodonghong@gsafety.com"), // contact
				"项目的代码和资料地址", // licence
				"https://github.com/xiaoyiyibaibai/springmvc" // licence url
				);
	}
	@Bean  
    public Docket createRestApi() {  
		logger.info("配置了名称为：测试类Restful接口  的分组。 过滤了所有com.gsafety.bak.controller中的的rest请求！。");
        return new Docket(DocumentationType.SWAGGER_12)  
        		 .groupName("test api")
                .apiInfo(outApiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.gsafety.bak.controller"))  
                .paths(PathSelectors.any())  
                .build();  
    }  
	
	@Bean
	public Docket getHelloWorldApiInfo() {
		logger.info("配置了名称为：仅展示示例欢迎类的Restfule接口 的分组。 过滤了所有com.gsafety.controller中的的rest请求！。");
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("helloworld api")
				.select()   //选择哪些路径和API会生成document
				.apis(RequestHandlerSelectors.basePackage("com.gsafety.controller"))   // 对com.gsafety.controller下的api进行监控
				.paths(PathSelectors.any())  // 对所有路径进行监控
				.build()
				.apiInfo(outApiInfo());
	}
}