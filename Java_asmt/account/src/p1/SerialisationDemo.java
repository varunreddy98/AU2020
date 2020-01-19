package p1;
import java.io.*;
import java.util.*;
public class SerialisationDemo {
       static int c=0;
       static Student s[]=new Student[20];
		public static void main(String...args) throws IOException
		{
			File f=new File("./file.txt");
	 		FileInputStream oi=new FileInputStream(f);
	 		ObjectInputStream os = null;
	 		try{os=new ObjectInputStream(oi);
	 		Student pp=null;
	 		while((pp=(Student) os.readObject())!=null) {
	 		System.out.println(pp);
	 		s[c++]=pp;	
	 		}
	 		os.close();
	 		}
	 		catch(EOFException e)
	 		{
	 			System.out.println(e);
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
	 		}
	 		int num;
	 		Scanner sc=new Scanner(System.in);
	 		System.out.println("enter no of students");
	 		num=sc.nextInt();
	 		for(int i=0;i<num;i++)
	 		{
	 			System.out.println("enter name,id and marks of student");
	 			Student pp=new Student(sc.next(),sc.nextInt(),sc.nextInt());
	 			s[c++]=pp;	
	 			
	 		}
			FileOutputStream fo;
			try {
				fo = new FileOutputStream("./file.txt");
			ObjectOutputStream oj=new ObjectOutputStream(fo);
			for(int i=0;i<c;i++)
			{   System.out.println(s[i].toString());
				oj.writeObject(s[i]);
			}
			oj.flush();
			oj.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
}

