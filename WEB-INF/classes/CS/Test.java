package CS;

import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import CS.Publication;
import CS.PublicationSax;

public class Test {
	
	public static void main(String[] args) throws Exception { 
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		File f = new File("F:\\samplefile.xml"); 
        PublicationSax publications = new PublicationSax(); 
        parser.parse(f, publications);
	}
	/*
	public ArrayList<Publication> searchByTitle(PublicationSax pubs, String title) {
		//Publication pub = new Publication();
		int size = pubs.getPubs().size();
		ArrayList<Publication> result = new ArrayList();
		for(Publication pub : pubs) {
			if(pub.gettitle().equals(title)) {
				result.add(pub);
			}
		}
		return result;
	}
	*/
}