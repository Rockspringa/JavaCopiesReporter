package edu.mooncoder.copy;

import edu.mooncoder.copy.controllers.manager.StructureReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(new StructureReader().getFiles("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/Structure Copy/Prueba.yml")));
    }
}