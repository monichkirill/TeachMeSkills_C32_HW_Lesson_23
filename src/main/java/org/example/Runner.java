package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.model.Book;
import org.example.model.BookListWrapper;
import org.example.parser.XmlParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Reading a JSON file
            List<Book> books = objectMapper.readValue(new File("books.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));

            // Saving to XML
            JAXBContext jaxbContext = JAXBContext.newInstance(BookListWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new BookListWrapper(books), new File("books.xml"));

            //read XML and find the book with the most pages
            XmlParser xmlParser = new XmlParser();
            xmlParser.parseXML("books.xml");
        }catch (Exception e){
            System.out.println("General JSON to XML Conversion Error: " + e.getMessage());
        }
    }
}
