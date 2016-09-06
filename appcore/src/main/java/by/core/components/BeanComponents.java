package by.core.components;

import by.core.multitrading.BicycleFactory;
import by.core.servicie.BuildBicycle;
import org.jetbrains.annotations.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Denis on 23.08.2016.
 */
@Deprecated //not uses for task. Will use in future
@Configuration
@ComponentScan(basePackages = {"by.core.servicie", "by.core.multitrading", "by.core.dao"})
public class BeanComponents {

    @org.jetbrains.annotations.Contract(" -> !null")
    @Bean
    private BuildBicycle buildBicycle(){
        return null;//new BuildBicycle();
    }
    @Contract(" -> !null")
    @Bean
    private BicycleFactory bicycleFactory(){
        return new BicycleFactory();
    }
}
