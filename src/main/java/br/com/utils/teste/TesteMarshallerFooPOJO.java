package br.com.utils.teste;

import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import br.com.utils.pojo.FooPOJO;

public class TesteMarshallerFooPOJO {

    public static void main(final String[] args) {
        try {
            FooPOJO foo =
                            new FooPOJO().setNome("Teste").setValor(150.00)
                                            .setData(new Date());
            JAXBContext context = JAXBContext.newInstance(FooPOJO.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(foo, stringWriter);
            System.out.println(stringWriter.toString());
        } catch (PropertyException e) {
            e.getMessage();
        } catch (JAXBException e) {
            e.getMessage();
        }
    }

}
