package com.heylhh.pmp.server.config;

import com.heylhh.pmp.server.shiro.ShiroVariable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author heylhh
 * @PackageName: PermissonManagementPlatform
 * @ClassName: FreemarkerConfig
 * @Description: Freemarker配置
 * @data：2019/10/26 22:55
 */
@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(ShiroVariable shiroVariable){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/templates");

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("shiro",shiroVariable);
        configurer.setFreemarkerVariables(variables);

        Properties settings = new Properties();
        settings.setProperty("default_encoding", "utf-8");
        settings.setProperty("number_format", "0.##");
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }

}
