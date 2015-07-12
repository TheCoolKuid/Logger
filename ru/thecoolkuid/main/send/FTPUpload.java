package ru.thecoolkuid.main.send;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;

import ru.thecoolkuid.main.log.LogWithPrint;

public class FTPUpload{
	   public static void FTPup(String username, String pass, String Adress, String directory, String file){
		   try{
		   File outArxFile=new File(file);   
		   URL ur = new URL("ftp://"+username+":"+pass+"@" + Adress  + "/" + directory  + file);
		    URLConnection urlc = ur.openConnection();

		     BufferedInputStream in = new BufferedInputStream(new FileInputStream(outArxFile));
		                           BufferedOutputStream z = new BufferedOutputStream(urlc.getOutputStream());
		                           int by;
		                           while ((by = in.read()) != -1) {
		                               z.write(by);
		                           }
		                           in.close();
		                           z.close();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   LogWithPrint.printINFO("FTPUpload", "Файл Загружен");
	   }
}
	