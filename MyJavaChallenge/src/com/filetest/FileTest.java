package com.filetest;

import java.io.File;

public class FileTest {
		// TODO Auto-generated method stub

	public File[] getFiles(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles != null){
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
	}
		return listOfFiles;
	}
}
