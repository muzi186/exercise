package corejava.j8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createStream();
	}

	public static void createStream() {
		String[] strNames = new String[] { "a1", "a2", "v1", "v3", "c3", "b6" };
		List<String> names = Arrays.asList(strNames);

		Stream<String> stream = names.stream();

		System.out.println(stream);
		
		Stream<String> sortedStream = stream.sorted(new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.compareToIgnoreCase(s2);
			}
			
		});
		
		//sortedStream.forEach(action);
	}
}
