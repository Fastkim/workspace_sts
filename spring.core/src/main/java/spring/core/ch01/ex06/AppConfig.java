package spring.core.ch01.ex06;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages="spring.core.ch01.ex06",
		excludeFilters=@Filter(type=FilterType.ANNOTATION, classes=(NoComponent.class))) //noComponent는 Ioc에서 제외시킨다는걸 적어줌.
public class AppConfig {

}