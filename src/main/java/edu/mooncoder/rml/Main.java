package edu.mooncoder.rml;

import edu.mooncoder.rml.exceptions.BadWrittenRmlException;
import edu.mooncoder.rml.services.ReadRml;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ReadRml readRml = new ReadRml("C:/Users/dylan/Desktop/Everything,+but+Nothing" +
                "/Programacion+Eliminar/RML/Prueba.def", null, true);
        try {
            System.out.println(readRml.getRmlResult().getHtmlString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BadWrittenRmlException e) {
            System.out.println(Arrays.toString(readRml.getErrors()));
        }
    }
}
