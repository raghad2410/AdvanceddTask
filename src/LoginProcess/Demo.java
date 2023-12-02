package LoginProcess;

public class Demo {

	public static void main(String[] args) {
		String [] myColors = {"red" , "green" , "blue" , "grey"};
		System.out.println(myColors[0]);
		System.out.println(myColors.length);
		
		for (int i = 0 ; i < myColors.length ; i++) {
			if (myColors[i] == "green" || myColors[i] == "grey" ) {
				continue ;
			} 
			System.out.println(myColors[i].toUpperCase());
		}
		
		for (int i = 0 ; i < myColors.length ; i++) {
			if (myColors[i].charAt(0) == 'b') {
				continue ;
			} 
			System.out.println(myColors[i]);
		}
		
		
		
//		for (String color : myColors ) {
//			System.out.println(color.toUpperCase());
//		}
//		
//		for (String color : myColors ) {
//			int i = 0 ;
//			System.out.println(color);
//			i++ ;
//		}
	}

}
