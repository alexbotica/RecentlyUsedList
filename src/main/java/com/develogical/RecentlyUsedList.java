package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList<T> {
	private ArrayList<T> m_entries;

	public RecentlyUsedList()
	{
		m_entries = new ArrayList<T>();
	}

	public List<T> getAllEntries() {
		return m_entries;
	}

	public int add(T s) {
		m_entries.remove(s);
		m_entries.add(s);
		return m_entries.lastIndexOf(s);
	}

	public T get(int i) {
		return m_entries.get(i);
	}

	public T getMostRecent() {
		if(m_entries.size()==0){
			throw new IndexOutOfBoundsException("List Empty");
		}
		return m_entries.get(m_entries.size()-1);
	}

	public int size() {
		return m_entries.size();
	}
	
}
