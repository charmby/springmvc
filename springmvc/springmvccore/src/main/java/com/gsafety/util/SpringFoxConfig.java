package com.gsafety.util;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
/*@ComponentScan(basePackages = {"com.gsafety"})  */
public class SpringFoxConfig{  
  
  /*  @Bean  
    public Docket createRestApi() {  
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.gsafety.controller"))  
                .paths(PathSelectors.any())  
                .build();  
    }  
  
    private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("Spring 中使用Swagger2构建RESTful APIs")  
                .termsOfServiceUrl("https://github.com/xiaoyiyibaibai/springmvc/issues/1")  
                .contact("肖东红")
                .version("1.1")  
                .build();  
    }  */
}  