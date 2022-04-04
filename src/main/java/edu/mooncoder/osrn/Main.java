package edu.mooncoder.osrn;

import edu.mooncoder.osrn.controllers.wrapper.ErrorWrapper;
import edu.mooncoder.osrn.model.containers.Osrn;
import edu.mooncoder.osrn.services.OsrnFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Osrn osrn = OsrnFactory.getOsrnByFilename("C:/Users/dylan/Desktop/Everything,"
                + "+but+Nothing/Programacion+Eliminar/OSRN/Prueba.json");

        System.out.println(Arrays.toString(ErrorWrapper.close()));
        System.out.println(osrn);
    }
}