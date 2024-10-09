package org.feriapp;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasetaFeriaManager {
    private List<CasetaFeria> casetas = new ArrayList<>();

    public void marshallingToXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CasetaFeria.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        for (CasetaFeria caseta : casetas) {
            marshaller.marshal(caseta, new File(filePath));
        }
        System.out.println("Casetas guardadas en XML.");
    }

    public void unmarshallingFromXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CasetaFeria.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        for (int i = 1; i <= 50; i++) {
            CasetaFeria caseta = (CasetaFeria) unmarshaller.unmarshal(new File(filePath));
            casetas.add(caseta);
        }
        System.out.println("Casetas leídas desde XML.");
    }

    public void marshallingToJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), casetas);
        System.out.println("Casetas guardadas en JSON.");
    }

    public void unmarshallingFromJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        casetas = mapper.readValue(new File(filePath),
                mapper.getTypeFactory().constructCollectionType(List.class, CasetaFeria.class));
        System.out.println("Casetas leídas desde JSON.");
    }

    public void loadCasetasFromFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int id = 1; // Empezamos el ID en 1
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" - ");
                if (data.length == 4) { // Verificamos que haya 4 elementos
                    CasetaFeria caseta = new CasetaFeria();
                    caseta.setId(id++);
                    caseta.setNombre(data[0].trim());
                    caseta.setTitular(data[1].trim());
                    caseta.setAforo(Integer.parseInt(data[2].trim()));
                    caseta.setTipoCaseta(data[3].trim());
                    casetas.add(caseta);
                }
            }
            System.out.println("Casetas cargadas desde el archivo de texto.");
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de texto: " + e.getMessage());
        }
    }

    public CasetaFeria getCasetaById(int id) {
        return casetas.stream().filter(caseta -> caseta.getId() == id).findFirst().orElse(null);
    }
}
