/*
 
 * This class shows how to clone the private GitHub Repository using jGit library .
 * In this class we had cloned the repository using user name and password as it's the 
   private GitHub account.
 * The repository is cloned in the mentioned local directory.
 * If we are not able to clone the mention repository then an exception is thrown.

 */

package com.repotool.git.services;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.jgit.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repotool.git.configuration.ConfigGit;
import com.repotool.git.model.EntitiesValues;




@Service
public class GitCloneRepo {
	
	@Autowired
	ConfigGit config;
	
	public void cloneRepository(String sourceBranch)
	{
		
		//System.out.println(config.getGitFindKey());
		
		String repoUrl = config.getGiturl();
		String cloneDirectoryPath = config.getGitcloneDirectoryPath(); // Ex.in windows c:\\gitProjects\SpringBootMongoDbCRUD\
		
		try {
		    System.out.println("Cloning "+repoUrl+" into "+cloneDirectoryPath);
		    Git result = Git.cloneRepository()
		        .setURI(repoUrl)
		        .setDirectory(Paths.get(cloneDirectoryPath).toFile())
		        .setCredentialsProvider((new UsernamePasswordCredentialsProvider(config.getGitUsername(), config.getGitPassword())))
		        .call();
		    
		} catch (GitAPIException e) {
		    System.out.println("Exception occurred while cloning repo");
		    e.printStackTrace();
		}
		
  }
	
}
	

