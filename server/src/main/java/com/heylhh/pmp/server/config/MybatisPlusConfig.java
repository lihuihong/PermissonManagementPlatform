package com.heylhh.pmp.server.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heylhh
 * @PackageName: PermissonManagementPlatform
 * @ClassName: MybatisPlusConfig
 * @Description: mybatis-plus配置
 * @data：2019/10/26 22:53
 */
@Configuration
public class MybatisPlusConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
    //防止sql注入攻击
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
