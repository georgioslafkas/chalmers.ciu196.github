package chalmers.ciu196.foodschool.Database;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.content.Context;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import chalmers.ciu196.foodschool.CategoryCollection;
import chalmers.ciu196.foodschool.Food;
import chalmers.ciu196.foodschool.FoodCategory;


public class XmlParser {
	
	public XmlParser (){
	
	}

	public CategoryCollection categoryfromXML(int id, Context cont){

		// Read the XML file with our resources
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		InputStream is = cont.getResources().openRawResource(id);
		DocumentBuilder docBuilder = null;
		
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = docBuilder.parse(is);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//set up a transformer
		TransformerFactory transfac = TransformerFactory.newInstance();
		Transformer trans = null;
		try {
			trans = transfac.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		//create string from xml tree
		StringWriter sw = new StringWriter();
		StreamResult result = new StreamResult(sw);
		DOMSource source = new DOMSource(doc);
		try {
			trans.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xmlString = sw.toString();
		

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("category", FoodCategory.class);
		xstream.alias("categorycollection",CategoryCollection.class);
		xstream.alias("food",Food.class);
		
		CategoryCollection collection=(CategoryCollection)xstream.fromXML(xmlString);
		return collection;
	}	
}
