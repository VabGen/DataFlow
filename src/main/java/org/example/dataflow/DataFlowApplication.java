package org.example.dataflow;

import org.example.dataflow.graph.Graph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class DataFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataFlowApplication.class, args);

//        Graph graph = new Graph();
//        graph.addVertex('A');
//        graph.addVertex('B');
//        graph.addVertex('C');
//        graph.addVertex('D');
//        graph.addVertex('E');
//        graph.addVertex('F');
//        graph.addVertex('G');
//
//        graph.addEdge(0, 1, 3);
//        graph.addEdge(0, 2, 5);
//        graph.addEdge(0, 3, 7);
//        graph.addEdge(1, 4, 6);
//        graph.addEdge(2, 4, 4);
//        graph.addEdge(2, 3, 3);
//        graph.addEdge(3, 5, 3);
//        graph.addEdge(4, 6, 6);
//        graph.addEdge(5, 6, 4);
//
//        System.out.println("Элементы имеют кратчайшие пути из точки A: ");
//        graph.path();
//        graph.clean();

        int[] array = new int[6];
        Random rang = new Random();
        Arrays.setAll(array, i -> rang.nextInt(9) + 1);

        System.out.println(Arrays.toString(array));

        sort(array);

    }



    public static void sort(int... array) {
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length-1-i; j++){
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }



}

