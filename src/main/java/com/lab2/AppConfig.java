package com.lab2;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.lab2")
@ComponentScan("logger")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public ComponentVisitor componentVisitor() {
        return new ComponentVisitor();
    }

    @Bean
    @Scope("prototype")
    public SystemFacade systemFacade(List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        return new SystemFacade(motherboards, cpus, gpus);
    }

    @Bean
    @Scope("singleton")
    public Menu menu(SystemFacade systemFacade, List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        return new Menu(systemFacade, motherboards, cpus, gpus);
    }
}
