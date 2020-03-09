package com.pengshuai.utils;

import jdk.internal.util.xml.impl.ReaderUTF8;

import java.io.*;

public class FileUtil {

	public static final String FILE_PATH="D:/YUAN.txt";
	
	public static final String OUT_PUT_FILE="D:/RESULT.txt";
	
	public static void parseTextFile(String filePath, String resultFilePath)
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		InputStream fis = null;
		FileWriter fw = null;

		String line = null;
		try {
			fis = new FileInputStream(new File(filePath));
			br = new BufferedReader(new ReaderUTF8(fis));

			fw = new FileWriter(new File(resultFilePath));
			
			while((line = br.readLine()) != null)
			{
				if(null == line || line.isEmpty())
				{
					continue;
				}

				int selectIdx = line.indexOf(" '");
				String areaCode = line.substring(selectIdx + 2,selectIdx + 14);
				String linStr = line.replace("?",areaCode);
				sb.append(linStr);
				sb.append("\n");
			}
			
			if(!sb.toString().isEmpty())
			{
				fw.write(sb.toString());
				fw.flush();
				fw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]){
		parseTextFile(FILE_PATH, OUT_PUT_FILE);
	}
	
}
