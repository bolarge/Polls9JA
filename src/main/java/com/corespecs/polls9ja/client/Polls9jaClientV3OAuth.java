package com.corespecs.polls9ja.client;

import java.util.ArrayList;
import java.util.List;

import com.corespecs.polls9ja.domain.Poll;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

public class Polls9jaClientV3OAuth {

	private static final String QUICK_POLL_URI_V3 = "http://localhost:8080/oauth2/v3/polls";
	
	public Poll getPollById(Long pollId) {
		OAuth2RestTemplate restTemplate = restTemplate();
		return restTemplate.getForObject(QUICK_POLL_URI_V3 + "/{pollId}", Poll.class, pollId);
	}

	private OAuth2RestTemplate restTemplate() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setGrantType("password");
		resourceDetails.setAccessTokenUri("http://localhost:8080/oauth/token");
		resourceDetails.setClientId("quickpolliOSClient");
		resourceDetails.setClientSecret("top_secret");
		
		// Set scopes
		List<String> scopes = new ArrayList<>();
		scopes.add("read"); scopes.add("write");
		resourceDetails.setScope(scopes);
		
		// Resource Owner details
		resourceDetails.setUsername("mickey");
		resourceDetails.setPassword("cheese");

		return new OAuth2RestTemplate(resourceDetails);
	}
	
	public static void main(String[] args) {
		Polls9jaClientV3OAuth client = new Polls9jaClientV3OAuth();
		Poll poll = client.getPollById(1L);
		System.out.println("Poll: " + poll);
	}
}
