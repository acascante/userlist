package controllers;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import daos.DictionaryBo;
import domains.CheckUserResponse;

public class UserCheckerController {

	private DictionaryBo dictionaryBo;
	private List<String> restricted;
	private Set<String> users;
	
	private static final int USERNAME_MINIMUM_LENGTH = 6;
	private static final int USERNAME_MINIMUM_OPTIONS = 14;
	
	private static class ErrorMessages {
		private static final String USERNAME_LENGTH = "Username should be more that " + USERNAME_MINIMUM_LENGTH + " characters";
		private static final String USERNAME_RESTRICTED_WORD = "Username is a restricted word";
		private static final String USERNAME_EXISTS = "Username already exists";
		private static final String USERNAME_VALID = "Username is valid";
	}  
	public UserCheckerController() {
		super();
		this.dictionaryBo = new DictionaryBo();
		this.restricted = this.dictionaryBo.createRestrictedDictionary();
		this.users = this.dictionaryBo.createUserDictionary();
	}

	public CheckUserResponse checkUsername(String username) {
		CheckUserResponse checkUserResponse = new CheckUserResponse();
		
		String message = validateUser(username); 
		if (message == null) {
			if (checkForRestrictedWords(username)) {
				// User is one of the restricted words
				checkUserResponse.setResult(Boolean.FALSE);
				checkUserResponse.setMessage(ErrorMessages.USERNAME_RESTRICTED_WORD);
				
				checkUserResponse.setOptions(generateOptions(generateRandomUser(username.substring(0, USERNAME_MINIMUM_LENGTH))));				
			} else {
				if (this.users.contains(username)) {
					// User already exists
					checkUserResponse.setResult(Boolean.FALSE);
					checkUserResponse.setMessage(ErrorMessages.USERNAME_EXISTS);
					checkUserResponse.setOptions(generateOptions(username.substring(0, USERNAME_MINIMUM_LENGTH)));				
				} else {
					checkUserResponse.setResult(Boolean.TRUE);
					checkUserResponse.setMessage(ErrorMessages.USERNAME_VALID);
				}
			}
		} else {
			// Invalid user, according to general validations
			checkUserResponse.setResult(Boolean.FALSE);
			checkUserResponse.setMessage(message);
		}		
		return checkUserResponse;
	}
	
	private boolean checkForRestrictedWords(String username) {
		for (String word : this.restricted) {
			if (username.contains(word)) {
				return true;
			}
		}
		return false;
	}

	private String validateUser(String username) {
		if (username.length() < USERNAME_MINIMUM_LENGTH) {
			return ErrorMessages.USERNAME_LENGTH;
		}
		return null;
	}
	
	private String generateRandomUser(String username) {
		Random random = new Random();
		int aLimit = 97; // letter 'a'
	    int zLimit = 122; // letter 'z'
	    StringBuilder newUsername = new StringBuilder(USERNAME_MINIMUM_LENGTH);
	    for (int i = 0; i < USERNAME_MINIMUM_LENGTH; i++) {
	        int randomLimitedInt = aLimit + (int) (random.nextFloat() * (zLimit - aLimit + 1));
	        newUsername.append((char) randomLimitedInt);
	    }
	    return newUsername.toString();
	}
	
	private TreeSet<String> generateOptions(String username) {
		TreeSet<String> options = new TreeSet<>();
		Random random = new Random();
		
		int i = 0;
		int cont = 0;
		int maxRandom = 100;
		while (i < USERNAME_MINIMUM_OPTIONS) {
			cont ++;
			if (cont > maxRandom) {
				maxRandom += maxRandom;
				cont = 0;
			}
			int randomValue = random.nextInt(maxRandom);
			String sugestedUsername = username + "_" + randomValue;
			if (!this.restricted.contains(sugestedUsername) && !this.users.contains(sugestedUsername) ) {
				options.add(sugestedUsername);
				i ++;
			}
		}
		return options;
	}
	
	public List<String> getRestricted() {
		return restricted;
	}

	
	public void setRestricted(List<String> restricted) {
		this.restricted = restricted;
	}

	
	public Set<String> getUsers() {
		return users;
	}

	
	public void setUsers(Set<String> users) {
		this.users = users;
	}
}

