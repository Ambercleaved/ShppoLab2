package com.lab2;

import java.util.List;
import java.util.ArrayList;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("logger")
public class AppConfig {

    @Bean
    public CPU cpu1() {
        return Factory.createCPU("Intel", "i5-8400", 6, "Lga", 3.6);
    }
    @Bean
    public GPU gpu1() {
        return Factory.createGPU("Nvidia", "RTX 2060s", "pci 3.0", 16000);
    }
    @Bean
    public Motherboard mb1() {
        return Factory.createMotherboard("Asus", "Asrock z345", "pci 3.0", "Lga");
    }
    @Bean
    public CPU cpu2() {
        return Factory.createCPU("AMD", "Ryzen 7 5800X", 8, "AM4", 4.7);
    }
    @Bean
    public GPU gpu2() {
        return Factory.createGPU("AMD", "RX 6700 XT", "pci 4.0", 24200);
    }

    @Bean
    public Motherboard mb2() {
        return Factory.createMotherboard("Gigabyte", "B550 Aorus Elite", "pci 4.0", "AM4");
    }

    @Bean
    public CPU cpu3() {
        return Factory.createCPU("Intel", "I7 - 11500K", 10, "Lga", 4.2);
    }
    @Bean
    public GPU gpu3() {
        return Factory.createGPU("Nvidia", "GTX 1660", "pci 3.0", 10000);
    }
    @Bean
    public Motherboard mb3() {
        return Factory.createMotherboard("Lenovo", "L 564", "pci 3.0", "Lga");
    }

    @Bean
    public List<CPU> cpus() {
        List<CPU> cpus = new ArrayList<>();
        cpus.add(cpu1());
        cpus.add(cpu2());
        cpus.add(cpu3());
        return cpus;
    }

    @Bean
    public List<GPU> gpus() {
        List<GPU> gpus = new ArrayList<>();
        gpus.add(gpu1());
        gpus.add(gpu2());
        gpus.add(gpu3());
        return gpus;
    }

    @Bean
    public List<Motherboard> motherboards() {
        List<Motherboard> motherboards = new ArrayList<>();
        motherboards.add(mb1());
        motherboards.add(mb2());
        motherboards.add(mb3());
        return motherboards;
    }
    @Bean
    public ComponentVisitor componentVisitor() {
        return new ComponentVisitor();
    }

    @Bean
    public SystemFacade systemFacade(List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        return new SystemFacade(motherboards, cpus, gpus);
    }

    @Bean
    public Menu menu(SystemFacade systemFacade, List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        return new Menu(systemFacade, motherboards, cpus, gpus);
    }
}
