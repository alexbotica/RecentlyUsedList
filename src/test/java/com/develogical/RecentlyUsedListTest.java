package com.develogical;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class RecentlyUsedListTest {

	private RecentlyUsedList list1 = new RecentlyUsedList();

	@Test
	public void testEmptyWhenInitialised(){
		assertThat(list1.getAllEntries(),equalTo(new ArrayList<String>()));
	}

	@Test
	public void testListNotEmptyWhenPopulted() {
		assertThat(list1.add("123456789"), equalTo(0));
	}

	@Test
	public void testAddCaseMismatch() {
		list1.add("555-TREE-REPAIR");
		list1.add("555-tree-repair");
		assertThat(list1.size(), equalTo(2));
	}

	@Test
	public void testRetrieveItemByIndex(){
		list1.add("999");
		assertThat(list1.get(0),equalTo("999"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testOutOfBoundsOnGetMostRecent()
	{
		assertThat(list1.getMostRecent(),equalTo("111"));
	}

	@Test
	public void testMostRecentFirst(){
		list1.add("999");
		list1.add("111");
		try{
			assertThat(list1.getMostRecent(),equalTo("111"));
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void checkDuplicateInsertionsMoved(){
		list1.add("999");
		list1.add("111");
		list1.add("999");
		assertThat(list1.size(),equalTo(2));
		assertThat(list1.getMostRecent(),equalTo("999"));
	}
}
