package HTTPprotokol;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FileDownload {

	public static void main(String[] args) {
		if(args.length!=2) {
			//log4j
			System.out.println("Proper Usage: java FileDownload SourceFileURL OutputFileName");
			System.out.println("For example: "+ "java FileDownload http://myflex.org/yf/nyc.jpg nyc.jpg");
			//prvi argument je URL slike a drugi naziv slike, parametri se moraju uneti pri pokretanju programa
		System.exit(-1);	
		}
		
		URLConnection fileStream = null;
		try 
		{
			URL remoteFile = new URL(args[0]);
			fileStream = remoteFile.openConnection();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		try(FileOutputStream fOut = new FileOutputStream(args[1]);
			InputStream in = fileStream.getInputStream();) 
		{
		//ocitavanje udaljene datoteke i njeno snimanje na lokalnu lokaciju
			int data;
			System.out.println("Starting the download from "+ args[0]);
			while((data = in.read()) != -1) {
				fOut.write(data);
			}
			System.out.println("Finished downloading the file " + args[1]);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
