package domains;

import java.util.Set;
import java.util.TreeSet;

import implementations.Dictionary;

public class BaseDictionary implements Dictionary {

	private Long id;
	private String name;
	private Set<String> words;

	
	public BaseDictionary() {
		super();
		this.words = new TreeSet<>();
	}

	public BaseDictionary(Long id, String name, TreeSet<String> words) {
		super();
		this.id = id;
		this.name = name;
		this.words = words;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getWords() {
		return words;
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	@Override
	public void addWord(String word) {
		this.words.add(word);
	}

	@Override
	public void deleteWrod(String word) {
		this.words.remove(word);		
	}

	@Override
	public Boolean haveWord(String word) {
		return this.words.contains(word);
	}
}
