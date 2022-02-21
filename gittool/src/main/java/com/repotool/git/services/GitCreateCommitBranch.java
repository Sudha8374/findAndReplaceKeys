/*
 
 * This class shows how to create a new branch in the mentioned repository and push the updated
   files(i.e after doing find and replace logic that we had done in GitFindAndReplace.java Class)
   into the newly created branch.
 * If we are not able to create and commit the branch an exception is thrown.
  
 */


package com.repotool.git.services;

import java.io.File;

import org.eclipse.jgit.api.CheckoutCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repotool.git.configuration.ConfigGit;

@Service
public class GitCreateCommitBranch {
	
	@Autowired
	ConfigGit config;
	
	public  boolean createAndCommitBranch(final String destinationBranchName) {
		
		
		String cloneDirectoryPath = config.getGitcloneDirectoryPath();
		CheckoutCommand checkout;
        Git git;
  
        File src = new File(cloneDirectoryPath);
        
        
        try {
        	
        	Repository repo = new FileRepositoryBuilder().readEnvironment().findGitDir(src).build();
            git = new Git(repo);
            git.branchCreate().setName(destinationBranchName).call();
            checkout = git.checkout();
            checkout.setName(destinationBranchName);
            checkout.call();
           
            git.commit().setAll(true).setMessage("replacement done").call();
            
           
        	
           
            
            System.out.println("New Branch created");
           
            PushCommand pushCommand = git.push();
            pushCommand.setRemote("origin");
            pushCommand.setRefSpecs(new RefSpec(destinationBranchName + ":" + destinationBranchName));
            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(
            		config.getGitUsername(), config.getGitPassword()));
            pushCommand.call();
            git.getRepository().close();
            git.close();
            git.gc().call();
            git=null;
            System.out.println("pushed successfully");
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
