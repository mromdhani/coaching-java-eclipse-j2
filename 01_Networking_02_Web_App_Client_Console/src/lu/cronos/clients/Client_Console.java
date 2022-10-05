package lu.cronos.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Client_Console {

	private static String URL = "http://localhost:8080/01_01_Hello_Web_App/helloservlet";

	public static void main(String[] args) {

		System.out
				.println("Hello this programm defines about how to call a servlet with a java application ");
		try {

			URL target = new URL(URL);
			URLConnection conn = target.openConnection();
			conn.setDoOutput(true);
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String str;
			while ((str = br.readLine()) != null)
				System.out.println(str);

		} catch (IOException e) {
			System.out.println("exception is" + e);
		}

	}

}
