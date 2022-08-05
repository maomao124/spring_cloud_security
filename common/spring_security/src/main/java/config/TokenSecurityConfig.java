package config;

import filter.TokenAuthFilter;
import filter.TokenLoginFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import security.TokenLogoutHandler;
import security.TokenManager;
import security.UnAuthEntryPoint;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): config
 * Class(类名): TokenSecurityConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 23:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TokenSecurityConfig extends WebSecurityConfigurerAdapter
{
    private final TokenManager tokenManager;
    private final StringRedisTemplate stringRedisTemplate;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Autowired
    public TokenSecurityConfig(TokenManager tokenManager, StringRedisTemplate stringRedisTemplate,
                               PasswordEncoder passwordEncoder, UserDetailsService userDetailsService)
    {
        log.debug("加载TokenSecurityConfig");
        this.tokenManager = tokenManager;
        this.stringRedisTemplate = stringRedisTemplate;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //配置异常处理
        http.exceptionHandling()
                //没有权限访问的异常处理器
                .authenticationEntryPoint(new UnAuthEntryPoint());


        //csrf设置
        http.csrf().disable();

        //认证配置
        http.authorizeRequests()
                .anyRequest().authenticated()
                //设置退出路径
                .and().logout().logoutUrl("/admin/acl/index/logout")
                //设置退出登录的处理器
                .addLogoutHandler(new TokenLogoutHandler(tokenManager, stringRedisTemplate))
                .and()
                //设置过滤器
                .addFilter(new TokenLoginFilter(tokenManager, stringRedisTemplate, authenticationManager()))
                .addFilter(new TokenAuthFilter(authenticationManager(), tokenManager, stringRedisTemplate))
                .httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        //设置userDetailsService和passwordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        //设置不进行认证的路径，可以直接访问
        web.ignoring().antMatchers("/api/**");
    }

}
