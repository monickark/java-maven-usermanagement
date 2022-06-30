/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

//Start of user code (user defined imports)

//End of user code


/**
* Description of AranidhiApplication.
* 
* @author NIKITHRA
*/
@SpringBootApplication
@ComponentScan(basePackages="org.nikithra.aranidhi")
@EnableJpaRepositories(basePackages = "org.nikithra.aranidhi")
@Configuration
public class AranidhiApplication {
    
	/**
	 * Description of the method main.
	 * @param AranidhiApplication
	 */
	public static void main(String[] args) {
		// Start of user code for Main Method
		/*MDC.put("userId", "ULA0001");*/
		ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		SpringApplication.run(AranidhiApplication.class, args);
		// End of User code for Main Method
	}
	/*@Bean
	  FilterRegistrationBean myFilterRegistration() {
	      FilterRegistrationBean frb = new FilterRegistrationBean();
	      frb.setFilter(new MDCFilter());
	      frb.setUrlPatterns(Arrays.asList("/*"));
	      return frb;
	}*/

}
