package com.repotool.git.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;




@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("config")
public class ConfigGit {

	private String giturl;
	private String gitUsername;
	private String gitPassword;
    private String gitcloneDirectoryPath;
    private String gitFindKey;
    private String gitFindKey1;
    private String gitFindKey2;
    private String gitFindKey3;
	
	
	public String getGitFindKey2() {
		return gitFindKey2;
	}

	public void setGitFindKey2(String gitFindKey2) {
		this.gitFindKey2 = gitFindKey2;
	}

	public String getGitFindKey3() {
		return gitFindKey3;
	}

	public void setGitFindKey3(String gitFindKey3) {
		this.gitFindKey3 = gitFindKey3;
	}

	public String getGitFindKey1() {
		return gitFindKey1;
	}

	public void setGitFindKey1(String gitFindKey1) {
		this.gitFindKey1 = gitFindKey1;
	}

	public String getGitFindKey() {
		return gitFindKey;
	}

	public void setGitFindKey(String gitFindKey) {
		this.gitFindKey = gitFindKey;
	}

	public String getGitcloneDirectoryPath() {
		return gitcloneDirectoryPath;
	}

	public void setGitcloneDirectoryPath(String gitcloneDirectoryPath) {
		this.gitcloneDirectoryPath = gitcloneDirectoryPath;
	}

	public String getGitUsername() {
		return gitUsername;
	}

	public void setGitUsername(String gitUsername) {
		this.gitUsername = gitUsername;
	}

	public String getGitPassword() {
		return gitPassword;
	}

	public void setGitPassword(String gitPassword) {
		this.gitPassword = gitPassword;
	}

	public String getGiturl() {
		return giturl;
	}

	public void setGiturl(String giturl) {
		this.giturl = giturl;
	}
	

}
