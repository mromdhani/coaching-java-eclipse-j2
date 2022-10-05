package lu.cronos._02_new_methods_in_string;

import java.util.stream.Stream;

@SuppressWarnings("unused")
public class NewMethodsInString {
		
		public static void main(String[] args) {
			//isBlanck();	
			//lines();
			//strip();
			reapeat();
		}

		private static void reapeat() {
			String str = "@"; 
			System.out.println(str);
			String str2 = str.repeat(3);
			System.out.println(str2);
			str = "java";
			System.out.println(str);
			str2 = str.repeat(5);
			System.out.println(str2);			
		}

		
		private static void strip() {
			String str = "      Java 11  "; 
			System.out.println(str);
	        String str2 = str.strip();  // There is stripLeading(), and stripTrailing()
	        System.out.println(str2);
			
		}

		private static void lines() {
			String str = "SPF Justice \nis the Belgian government body \nthat deals with justice."; 	 
	        Stream<String> lines = str.lines();
	        lines.forEach(System.out::println);			
		}

		private static void isBlanck() {
			String str = "SPF Justice";
			boolean r = str.isBlank();
			System.out.println(r);
			str = "";
			r = str.isBlank();
			System.out.println(r);
		}
	}