package com.leyou.upload.configuration;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @ClassName FastClientImporter
 * @Description FastDFS配置类
 * @Author wq
 * @Date 2018/11/30 9:12
 * @Version 1.0.0
 */
@Configuration
@Import(FdfsClientConfig.class)
/**
 * 解决jmx重复注册Bean的问题
 */
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastClientImporter {
}
