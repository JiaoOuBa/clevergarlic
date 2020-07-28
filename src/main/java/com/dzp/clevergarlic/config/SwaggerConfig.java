package com.dzp.clevergarlic.config;

import com.dzp.clevergarlic.enums.ExceptionMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.common.SwaggerPluginSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2配置文件
 * @Auther ck
 * @Date 2020/7/1 11:49
 * @Desc
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${fc.swagger.open}")
    private Boolean openSwagger;

    //自定义后台Response异常信息
    List<ResponseMessage> responseMessageList =  new ArrayList<ResponseMessage>() {
        {
            add(new ResponseMessageBuilder().code(ExceptionMsg.ParamError.getCode())
                    .message(ExceptionMsg.ParamError.getMsg()).build());
            add(new ResponseMessageBuilder().code(ExceptionMsg.FAILED.getCode())
                    .message(ExceptionMsg.FAILED.getMsg()).build());
            add(new ResponseMessageBuilder().code(ExceptionMsg.FriendTrip.getCode())
                    .message(ExceptionMsg.FriendTrip.getMsg()).build());
            add(new ResponseMessageBuilder().code(ExceptionMsg.SERVER_ERROR.getCode())
                    .message(ExceptionMsg.SERVER_ERROR.getMsg()).build());
            add(new ResponseMessageBuilder().code(ExceptionMsg.ACCESS_LIMIT_REACHED.getCode())
                    .message(ExceptionMsg.ACCESS_LIMIT_REACHED.getMsg()).build());
            add(new ResponseMessageBuilder().code(ExceptionMsg.LOGINOUT.getCode())
                    .message(ExceptionMsg.LOGINOUT.getMsg()).build());
        }
    };

    @Bean
    public Docket commonApi() {

        List<Parameter> pars = new ArrayList<>();

        // token验证header
        ParameterBuilder commonTicketPar = new ParameterBuilder();
        commonTicketPar.name("Authorization")
                .description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER - 5)
                .required(false).build();
        pars.add(commonTicketPar.build());

        // traceId
        ParameterBuilder commonTicketPar5 = new ParameterBuilder();
        commonTicketPar5.parameterType("header")
                .order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER - 1)
                .name("traceId")
                .description("日志接口标识")
                .modelRef(new ModelRef("string"))
                .required(false)
                .build();
        pars.add(commonTicketPar5.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("公共api接口文档")
                .enable(openSwagger)
                .apiInfo(apiInfo("FC公共接口文档(Api)"))
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.dzp.clevergarlic.web.common"))// 对所有api进行监控
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }

    @Bean
    public Docket adminApi() {

        List<Parameter> pars = new ArrayList<>();

        // token验证header
        ParameterBuilder commonTicketPar = new ParameterBuilder();
        commonTicketPar.name("Authorization")
                .description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER - 5)
                .required(false).build();
        pars.add(commonTicketPar.build());

        // traceId
        ParameterBuilder commonTicketPar5 = new ParameterBuilder();
        commonTicketPar5.parameterType("header")
                .order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER - 1)
                .name("traceId")
                .description("日志接口标识")
                .modelRef(new ModelRef("string"))
                .required(false)
                .build();
        pars.add(commonTicketPar5.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("后台管理api接口文档")
                .enable(openSwagger)
                .apiInfo(apiInfo("FC后台接口文档(Api)"))
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.dzp.clevergarlic.web.admin"))// 对所有api进行监控
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }


    private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                .title("Forecast Api")
                .contact(new Contact("ck","#","xxxx@example.com"))
                .version("0.0.1")
                .description(desc)
                .build();
    }

}
