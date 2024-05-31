package com.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemFacade {
    private List<Motherboard> motherboards;
    private List<CPU> cpus;
    private List<GPU> gpus;

    @Autowired
    public SystemFacade(List<Motherboard> motherboards, List<CPU> cpus, List<GPU> gpus) {
        this.motherboards = motherboards;
        this.cpus = cpus;
        this.gpus = gpus;
    }

    public void displayComponentInfo(ComponentVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("ComponentVisitor cannot be null");
        }
        System.out.println("Процессоры:");
        for (CPU cpu : cpus) {
            cpu.accept(visitor);
        }

        System.out.println("Видеокарты:");
        for (GPU gpu : gpus) {
            gpu.accept(visitor);
        }

        System.out.println("Материнские платы:");
        for (Motherboard mb : motherboards) {
            mb.accept(visitor);
        }
    }

    public void buildAndOutputSystems(ComponentVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("ComponentVisitor cannot be null");
        }

        // Create a SystemIterator to iterate over all combinations of components
        SystemIterator systemiterator = new SystemIterator(motherboards,cpus,gpus);
        // Iterate over each combination and build systems
        while (systemiterator.hasNext()) {
            SystemBuilder builder = systemiterator.next();
            if (builder != null) {
                // Build system
                PcSystem pcsystem = builder.build();
                // Output system details using the ComponentVisitor
                pcsystem.accept(visitor);
            }
        }
    }
    public void addCPU(CPU cpu) {
        cpus.add(cpu);
    }

    public void addGPU(GPU gpu) {
        gpus.add(gpu);
    }

    public void addMotherboard(Motherboard motherboard) {
        motherboards.add(motherboard);
    }
}
