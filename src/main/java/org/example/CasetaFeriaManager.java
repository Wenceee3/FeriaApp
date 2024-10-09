package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CasetaFeriaManager {
    private List<CasetaFeria> casetas;

    public void marshallingToXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CasetaFeria.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        for (CasetaFeria caseta : casetas) {
            marshaller.marshal(caseta, new File(filePath));
        }
    }

    public void unmarshallingFromXML(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CasetaFeria.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
    }

    public void marshallingToJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), casetas);
    }

    public void unmarshallingFromJSON(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        casetas = mapper.readValue(new File(filePath), mapper.getTypeFactory().constructCollectionType(List.class, CasetaFeria.class));
    }

    // Metodo para cargar casetas desde un archivo de texto
    public void loadCasetasFromFile(String filePath) {

    }
}

