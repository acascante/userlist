package daos;

import java.util.List;
import java.util.Set;

import bos.DictionaryDao;

public class DictionaryBo {

	private DictionaryDao dao;
	
	public DictionaryBo() {
		super();
		this.dao = new DictionaryDao();
	}


	public List<String> createRestrictedDictionary () {
		return dao.createRestrictedDictionary();
	}
	
	public Set<String> createUserDictionary () {
		return dao.createUserDictionary();
	}
}
