package org.feriapp;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CasetaFeriaManager manager = new CasetaFeriaManager();
        manager.loadCasetasFromFile("C:\\Users\\tarde\\IdeaProjects\\FeriaApp\\src\\main\\java\\org\\feriapp\\casetas.txt");

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Marshalling casetas a XML");
            System.out.println("2. Unmarshalling casetas de XML");
            System.out.println("3. Mostrar la caseta número X");
            System.out.println("4. Marshalling casetas a JSON");
            System.out.println("5. Unmarshalling casetas de JSON");
            System.out.println("6. Mostrar la caseta número X desde JSON");
            System.out.println("7. Salir");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        manager.marshallingToXML("casetas.xml");
                    } catch (JAXBException e) {
                        System.err.println("Error al marshalling a XML: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        manager.unmarshallingFromXML("casetas.xml");
                    } catch (JAXBException e) {
                        System.err.println("Error al unmarshalling de XML: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Introduce el ID de la caseta: ");
                    int idToShow = scanner.nextInt();
                    CasetaFeria casetaToShow = manager.getCasetaById(idToShow);
                    if (casetaToShow != null) {
                        System.out.println(casetaToShow);
                    } else {
                        System.out.println("Caseta no encontrada.");
                    }
                    break;
                case 4:
                    try {
                        manager.marshallingToJSON("casetas.json");
                    } catch (IOException e) {
                        System.err.println("Error al marshalling a JSON: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        manager.unmarshallingFromJSON("casetas.json");
                    } catch (IOException e) {
                        System.err.println("Error al unmarshalling de JSON: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Introduce el ID de la caseta: ");
                    int idToShowJSON = scanner.nextInt();
                    CasetaFeria casetaToShowJSON = manager.getCasetaById(idToShowJSON);
                    if (casetaToShowJSON != null) {
                        System.out.println(casetaToShowJSON);
                    } else {
                        System.out.println("Caseta no encontrada.");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
