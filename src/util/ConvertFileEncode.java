package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertFileEncode {
	
	public static void GBKToUTF8(String filePath){
		List<File> fileToConvert = new ArrayList<File>();
		File file = new File(filePath);
		if(file.isDirectory()){
			fileToConvert = Arrays.asList(file.listFiles());
		}else{
			fileToConvert.add(file);
		}
		for(File f : fileToConvert){
			convert(f,"GBK","UTF-8");
		}
	}
	
	private static void convert(File file, String src, String des){
		BufferedReader input = null;
		BufferedWriter output = null;
		try{
			input = new BufferedReader(new InputStreamReader(new FileInputStream(file), src));
			String ret = "";
			String temp = input.readLine();
			while(temp != null){
				ret += temp + "\r\n";
				temp = input.readLine();
			}
			output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), des));
			output.write(ret);
		}catch(Throwable t){
			t.printStackTrace();
		} finally{
			try {
				if(input != null){
					input.close();
				}
				if(output != null){
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		GBKToUTF8("D://test");
	}
}
