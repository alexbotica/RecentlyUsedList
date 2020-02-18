package com.develogical;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {

	private ArrayList<String> m_entries;

	public RecentlyUsedList()
	{
		m_entries = new ArrayList<String>();
	}

	public List<String> getAllEntries() {
		return m_entries;
	}

	public int add(String s) {
		m_entries.remove(s);
		m_entries.add(s);
		return m_entries.lastIndexOf(s);
	}

	public String get(int i) {
		return m_entries.get(i);
	}

	public String getMostRecent() {
		if(m_entries.size()==0){
			throw new IndexOutOfBoundsException("List Empty");
		}
		return m_entries.get(m_entries.size()-1);
	}

	public int size() {
		return m_entries.size();
	}
}
