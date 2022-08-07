package utils.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Project name(项目名称)：spring_cloud_security
 * Package(包名): utils.handler
 * Class(类名): MyMetaObjectHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/4
 * Time(创建时间)： 22:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler
{

    @Override
    public void insertFill(MetaObject metaObject)
    {
        //属性名称，不是字段名称
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject)
    {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
