package CS;

import java.io.*;
import java.util.*;

public class Publication implements Serializable {

	// All the attributes
	public String type;
	public String author;
	public String editor;
	public String title;
	public String booktitle;
	public String pages;
	public String year;
	public String address;
	public String volume;
	public String journal;
	public String number;
	public String month;
	public String url;
	public String cdrom;
	public String cite;
	public String ee;
	public String publisher;
	public String note; 
	public String crossref;
	public String isbn;
	public String series;
	public String school;
	public String chapter;

	public Publication() {
	}

	// Constructor
	public Publication(String type, String author, String editor, String tile, String booktitle, String pages, String year,
			String address, String volume, String journal, String number, String month, String url, String cdrom,
			String cite, String ee, String publisher, String note) {
		this.type = type;
		this.author = author;
		this.editor = editor;
		this.title = title;
		this.booktitle = booktitle;
		this.pages = pages;
		this.year = year;
		this.address = address;
		this.volume = volume;
		this.journal = journal;
		this.number = number;
		this.month = month;
		this.url = url;
		this.cdrom = cdrom;
		this.cite = cite;
		this.ee = ee;
		this.ee = publisher;
		this.note = note;
	}

	/*****     Get methods     *****/
	public String getauthor() {
		return author;
	}

	public String geteditor() {
		return editor;
	}

	public String gettitle() {
		return title;
	}

	public String getbooktitle() {
		return booktitle;
	}

	public String getpages() {
		return pages;
	}

	public String getyear() {
		return year;
	}

	public String getaddress() {
		return address;
	}

	public String getvolume() {
		return volume;
	}

	public String getjournal() {
		return journal;
	}

	public String getnumber() {
		return number;
	}

	public String month() {
		return month;
	}

	public String geturl() {
		return url;
	}

	public String getcdrom() {
		return cdrom;
	}

	public String getcite() {
		return cite;
	}

	public String getee() {
		return ee;
	}

	public String getpublisher() {
		return publisher;
	}

	public String getnote() {
		return note;
	}
	
	public String gettcrossref() {
		return crossref;
	}
	
	public String getisbn() {
		return isbn;
	}
	
	public String getseries() {
		return series;
	}
	
	public String getschool() {
		return school;
	}
	
	public String getchapter() {
		return chapter;
	}
	
	public String gettype() {
		return type;
	}

	/*****     Set methods     *****/
	public void settype(String type) {
		this.type = type;
	}
	
	public void setauthor(String author) {
		this.author = author;
	}

	public void seteditor(String editor) {
		this.editor = editor;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public void setbooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public void setpages(String pages) {
		this.pages = pages;
	}

	public void setyear(String year) {
		this.year = year;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public void setvolume(String volume) {
		this.volume = volume;
	}

	public void setjournal(String journal) {
		this.journal = journal;
	}

	public void setnumber(String number) {
		this.number = number;
	}

	public void setmonth(String month) {
		this.month = month;
	}

	public void seturl(String url) {
		this.url = url;
	}

	public void setcdrom(String cdrom) {
		this.cdrom = cdrom;
	}

	public void setcite(String cite) {
		this.cite = cite;
	}

	public void setee(String ee) {
		this.ee = ee;
	}

	public void setpublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setnote(String note) {
		this.note = note;
	}

	public void setcrossref(String crossref) {
		this.crossref = crossref;
	}
	
	public void setisbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setseries(String series) {
		this.series = series;
	}
	
	public void setschool(String school) {
		this.school = school;
	}
	
	public void setchapter(String chapter) {
		this.chapter = chapter;
	}
	
}
