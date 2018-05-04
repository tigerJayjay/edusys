
package org.es.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/** 
* @author 作者 tigerJay E-mail: 
* @version 创建时间：2018年1月20日 下午3:35:04 
* 类说明 
*/
@Configuration
public class SpringJsonConfig {
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
	    //1.需要定义一个convert转换消息的对象;
	    FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
	    //2:添加fastJson的配置信息;
	    FastJsonConfig fastJsonConfig = new FastJsonConfig();
	    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	    //3处理中文乱码问题
	    List<MediaType> fastMediaTypes = new ArrayList<>();
	    fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
	    //4.在convert中添加配置信息.
	    fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
	    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
	    HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
	    return new HttpMessageConverters(converter);
	}
}
 