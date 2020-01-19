package p1;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
class Book implements Comparable<Book> 
{   String title;
    String author;
    String year;
    int price;
    String category;
	Book(String title,String author,String year,int price,String category)
	{  this.title=title;
	   this.author=author;
	   this.year=year;
	   this.price=price;
	   this.category=category;
	}
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return (this.price-o.price);
	}
	
	public String toString()
	{
		return (this.title+" "+this.author+" "+this.category+" "+this.price+" "+this.year);
	}
}
public class Xmlparser {

	   public static void main(String[] args) throws IOException {

	      try {
	         SAXReader read= new SAXReader();
	         Document doc= read.read(new File("./XML_RAW_DATA.xml"));
	         ArrayList<Node> nodes = new ArrayList<Node>(doc.selectNodes("/bookstore/book" ));
	         System.out.println("Books in XML file");
	         ArrayList<Book> l=new ArrayList<Book>(); 
	         int c=0;
	         for (Node node : nodes) {
	            l.add(new Book(node.selectSingleNode("title").getText(),node.selectSingleNode("author").getText(),node.selectSingleNode("year").getText(),Integer.parseInt(node.selectSingleNode("price").getText()),node.valueOf("@category")));
	         }
	         for(Book b:l)
	         {
	         System.out.println(b);
	         }
	         Collections.sort(l);
	             Document doc1 = DocumentHelper.createDocument();
	             Element root= doc1.addElement( "bookstore" );
	             for(Book b:l) {
	             Element ele = root.addElement("book").addAttribute("category",b.category);
	             ele.addElement("title").addText(b.title);
	             ele.addElement("author").addText(b.author);
	             ele.addElement("year").addText(b.year);
	             ele.addElement("price").addText(Double.toString(b.price));
	             }
	             OutputFormat format = OutputFormat.createPrettyPrint();
	             XMLWriter writer= new XMLWriter( System.out, format );
	             writer.write( doc1 );     
	      } catch (DocumentException e) {
	         e.printStackTrace();
	      }
	   }
	}