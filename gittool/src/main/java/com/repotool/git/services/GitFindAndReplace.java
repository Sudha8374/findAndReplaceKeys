/*
 
 * This class shows how can we access the whole directory.
 * This class shows how to find and replace the mentioned keywords from the cloned repository (that we had
   done in the GitCloneRepository.java Class)
 * If we are not able to do the find and replace then an exception is thrown.
 
 */



package com.repotool.git.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repotool.git.configuration.ConfigGit;

@Service
public class GitFindAndReplace {
	
	@Autowired
	ConfigGit config;
	
	
	//String findKey = config.getGitFindKey();
	
	
	
	
	//recursing folder inside a folder getting the list of all files in all folders
		public  void recurseOnFile(String path) {
			
			  File passedFile = new File(path);
			  if (passedFile.isFile()) {
			    replaceInFile(passedFile);
			  }else if (passedFile.isDirectory()) {
			     File[] listOfFiles = passedFile.listFiles();
			    for (File inDir : listOfFiles) {
			    	
			    	if(!inDir.isHidden())
			    	{
			    		recurseOnFile(inDir.getAbsolutePath());	
			    	}
			      
			    }
			  }
			}
		
		//from the list of all files finding and replacing the key words
		public void replaceInFile(File file)
		{
			try {
	            BufferedReader reader = new BufferedReader(new FileReader(file));

	            String line = "", oldtext = "";
	            while ((line = reader.readLine()) != null) {
	                oldtext += line + "\r\n";
	            }
	            reader.close();

	            String replacedtext = oldtext.replaceAll("<eol> ", "");
	            String replacedtext1 = oldtext.replaceAll("<eol> ", "");
	            String replacedtext2 = oldtext.replaceAll("<eol> ", "");
	            String replacedtext3 = oldtext.replaceAll("<eol> ", "");
	            replacedtext = replacedtext.replaceAll(config.getGitFindKey(), "~~millenniumSchemaName~~");
	            replacedtext1 = replacedtext1.replaceAll(config.getGitFindKey1(), "~~millenniumSchemaName~~");
	            replacedtext2 = replacedtext2.replaceAll(config.getGitFindKey2(), "~~cdsSchemaName~~");
	            replacedtext3 = replacedtext3.replaceAll(config.getGitFindKey3(), "~~cdsSchemaName~~");
	            
	            
	            

	            FileWriter writer = new FileWriter(file);
	            writer.write(replacedtext);

	            writer.close();
	            
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }
			
			
			
		}

}
