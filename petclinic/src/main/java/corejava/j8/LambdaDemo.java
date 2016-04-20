package corejava.j8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LambdaDemo {

	public static void main(String[] args) {
		testNameConcatenater();
		testTimeDisplayer();
	}

	
	public static void testNameConcatenater(){
		NameConcatenater nc = (String s1, String s2) -> (s1 + "-" + s2);
		System.out.println(nc.concate("Gavin", "Li"));
	}
	
	public static void testTimeDisplayer(){
		TimeDisplayer td = ()->{
				Date time = new Date();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
				System.out.println(df.format(time));
		};
		
		td.displayTime();
	}
}


interface NameConcatenater{
	String concate(String givenName, String firstName);
}

interface TimeDisplayer{
	void displayTime();
}