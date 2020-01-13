package HTTPprotokol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebSiteReader {
	public static void main(String[] args) {
		String nextLine;
		URL url = null;
		URLConnection urlConn = null;
		
		try
		{
		// predpostavka je da je index.html podrazumevani naziv pocetne stranice name
			url = new URL("https://www.google.com");
			urlConn = url.openConnection();
			
		} catch(IOException e) {
			System.out.println("Can't connect to the provided URL: "+e.toString());
		}
		
		/*try(InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream(), "UTF8");
			BufferedReader buff = new BufferedReader(inStream);)
		*/
		
		// REFAKTORISANJE KODA
		try(BufferedReader buff = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF8"));)				
		{
		// ocitava se se i prikazuje sadrzaj pocetne Google stranice
			while(true) 
			{
				nextLine = buff.readLine();
				if(nextLine != null) System.out.println(nextLine);
				else break;
			}		
		} catch(IOException ioe) {
			System.out.println("Can't read from the Internet: "+ioe.toString());
		}
	}
}
