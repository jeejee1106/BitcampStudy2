package day0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class Ex06URL {

	public static void main(String[] args) {
		
		String hostName = "https://www.naver.com";
		URL url = null;
		
		int n = 0;
		
		try {
			url = new URL(hostName);
			
			InputStream is=url.openStream();

			BufferedReader br = null;
			br = new BufferedReader(new InputStreamReader(is));
			
			while(true) {
				n++;
				String line = br.readLine();
				if(line==null) {
					break;
				}
				System.out.println(n + ":" + line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

