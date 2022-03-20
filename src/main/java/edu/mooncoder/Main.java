package edu.mooncoder;

import edu.mooncoder.controllers.wrapper.ErrorWrapper;
import edu.mooncoder.model.containers.Osrn;
import edu.mooncoder.services.OsrnFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Osrn osrn = OsrnFactory.getOsrnByFilename("C:/Users/dylan/Desktop/Everything,"
                + "+but+Nothing/Programacion+Eliminar/OSRN/Prueba.json");

        System.out.println(Arrays.toString(ErrorWrapper.close()));
        System.out.println(osrn);
    }
}