package org.example.dataflow.generation.thread;

@FunctionalInterface
public interface CommandLineRunner {

    void run(String... args) throws Exception;
}
