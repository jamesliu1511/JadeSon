package com.jade.path;

import java.io.Reader;
import java.util.Iterator;
import java.util.Stack;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class XmlParser {

	public static JadeDoc parse(Reader reader) throws XMLStreamException {

		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventReader = factory.createXMLEventReader(reader);

		Stack<JsonObject> stack = new Stack<>();
		JsonObject root = new JsonObject();

		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			switch (event.getEventType()) {
			case XMLStreamConstants.START_ELEMENT:
				StartElement startElement = event.asStartElement();

				String qName = startElement.getName().toString();

				JsonObject attr = new JsonObject();
				JsonObject current = new JsonObject();

				current.add("_", attr);
				current.add("$", new JsonArray());

				JsonObject child = new JsonObject();
				child.add(qName, current);

				if (stack.isEmpty()) {
					root = child;
				} else {
					var parent = stack.peek();
					parent.get("$").getAsJsonArray().add(child);
				}
				stack.add(current);

				Iterator<Attribute> attributes = startElement.getAttributes();
				while (attributes.hasNext()) {
					Attribute currentAt = attributes.next();
					attr.addProperty(currentAt.getName().toString(), currentAt.getValue());
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				Characters characters = event.asCharacters();
				String value = characters.getData();
				if (StringUtils.isNotBlank(value)) {
					JsonArray children = stack.peek().get("$").getAsJsonArray();
					JsonObject v = new JsonObject();
					v.addProperty("@", value);
					children.add(v);
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				stack.pop();
				break;
			}
		}
		return JadeDoc.build().create(root);
	}
}