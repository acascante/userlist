package bos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DictionaryDao {

	public List<String> createRestrictedDictionary() {
		List<String> dictionary = new ArrayList<>();
		dictionary.add("cannabis");
		dictionary.add("abuse");
		dictionary.add("crack");
		dictionary.add("damn");
		dictionary.add("grass");
		return dictionary;
	}
	
	public Set<String> createUserDictionary() {
		Set<String> dictionary = new TreeSet<>();
		dictionary.add("acascante");
		dictionary.add("bugalde");
		dictionary.add("cramirez");
		dictionary.add("drojas");
		dictionary.add("etorres");
		return dictionary;
	}	
}
