package packageTwo;

import java.util.ArrayList;
import org.testng.annotations.Test;

public class JavaStreams {

@Test
	public void Test(){
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Aiden");
		arr.add("John");
		arr.add("Annie");
		arr.add("Avil");
		arr.add("Jenny");
		
		Long names = arr.stream().filter(s->s.startsWith("A")).count();
		System.out.println(names);
		
	}

}
