package com.assignment.parser;

import com.assignment.domain.StatementRecord;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlParser extends InputParser {

    private static final String RECORD = "record";
    private static final String REFERENCE = "reference";
    private static final String ACCOUNT_NUMBER = "accountNumber";
    private static final String DESCRIPTION = "description";
    private static final String START_BALANCE = "startBalance";
    private static final String MUTATION = "mutation";
    private static final String END_BALANCE = "endBalance";

    @Override
    public List<StatementRecord> parseAndValidate(File file) {

        List<StatementRecord> statementRecords = new ArrayList<>();
        StatementRecord statementRecord = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(file));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String localPart = startElement.getName().getLocalPart();
                    switch (localPart) {
                        case RECORD:
                            statementRecord = new StatementRecord();
                            statementRecord.setValid(true);
                            Attribute idAttr = startElement.getAttributeByName(new QName(REFERENCE));
                            if (idAttr != null) {
                                statementRecord.setTransactionReference(Integer.parseInt(idAttr.getValue()));
                            }
                            break;
                        case ACCOUNT_NUMBER:
                            xmlEvent = xmlEventReader.nextEvent();
                            statementRecord.setAccountNumber(xmlEvent.asCharacters().getData());
                            break;
                        case DESCRIPTION:
                            xmlEvent = xmlEventReader.nextEvent();
                            statementRecord.setDescription(xmlEvent.asCharacters().getData());
                            break;
                        case START_BALANCE:
                            xmlEvent = xmlEventReader.nextEvent();
                            statementRecord.setStartBalance(new BigDecimal(xmlEvent.asCharacters().getData()));
                            break;
                        case MUTATION:
                            xmlEvent = xmlEventReader.nextEvent();
                            statementRecord.setMutation(new BigDecimal(xmlEvent.asCharacters().getData()));
                            break;
                        case END_BALANCE:
                            xmlEvent = xmlEventReader.nextEvent();
                            statementRecord.setEndBalance(new BigDecimal(xmlEvent.asCharacters().getData()));
                            break;
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals(RECORD)) {

                        //validate the input record before adding it to the list
                        validateReferenceNumber(statementRecords, statementRecord);
                        validateEndBalance(statementRecord);

                        statementRecords.add(statementRecord);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return statementRecords;
    }
}
