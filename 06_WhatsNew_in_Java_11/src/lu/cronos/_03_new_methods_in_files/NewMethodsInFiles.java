package lu.cronos._03_new_methods_in_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class NewMethodsInFiles {

	public static void main(String[] args) {

		 readString();
		//writeString();

	}
	private static void readString() {
		try {
			Path path = Paths.get("data.txt");
			String data = Files.readString(path);
			System.out.println(data);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void writeString() {
		try {
			Path path = Paths.get("data.txt");
			path = Files.writeString(path, "Quarkus framework", StandardOpenOption.APPEND);
			String data = Files.readString(path);
			System.out.println(data);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}


}
