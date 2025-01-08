package org.example.parser;

import org.example.exception.XmlParseException;
import org.example.model.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser {
    public  void parseXML(String fileName) throws XmlParseException {
        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("book");
            Book maxBook = null;

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    int pages = Integer.parseInt(eElement.getElementsByTagName("pages").item(0).getTextContent());

                    if (maxBook == null || pages > maxBook.getPages()) {
                        maxBook = new Book();
                        maxBook.setTitle(title);
                        maxBook.setPages(pages);
                    }
                }
            }

            if (maxBook != null) {
                System.out.println("The book with the most pages:");
                System.out.println("Title: " + maxBook.getTitle());
                System.out.println("Pages: " + maxBook.getPages());
            }
        } catch (Exception e) {
            throw new XmlParseException("File read incorrectly: "  + e.getMessage());
        }
    }
}
