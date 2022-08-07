package mao.service_acl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"mao.spring_security", "utils"})
@EnableDiscoveryClient
//@ComponentScan("mao")
@MapperScan("mao.service_acl.mapper")
public class ServiceAclApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ServiceAclApplication.class, args);
    }

}
