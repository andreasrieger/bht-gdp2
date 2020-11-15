package ale.meinearraylist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


/**
 * @author Andreas Rieger (s82456@beuth-hochschule.de)
 *
 */
class MeineArrayListTest {

	
	private MeineArrayList<String> malist = new MeineArrayList<>(10, 10);

	@AfterEach
	public void clearList() {
		malist.removeAllEntries();
	}
	
	@Nested
	@DisplayName("empty list")
	class MeineArrayListTestEmptyList {
		
		@Test
		public void testAddEntry() {
			malist.addEntry("Foo");
			assertEquals(1, malist.size());
		}
		
		@Test
		public void testRemoveEntry() {
			malist.removeEntry("Foo");
			assertEquals(0, malist.size());
		}
	}
	
	@Nested
	@DisplayName("list with one entry")
	class MeineArrayListTestOneEntry {

		@BeforeEach
		public void init() {
			malist.addEntry("Foo");
		}

		@Test
		public void testAddEntry() {
			malist.addEntry("Bar");
			assertEquals(2, malist.size());
		}
		
		@Test
		public void testRemoveEntry() {
			malist.removeEntry("Foo");
			assertEquals(1, malist.size());
		}
	}
	
	@Nested
	@DisplayName("list with many entries")
	class MeineArrayListTestMultiEntries {

		@BeforeEach
		public void init() {
			malist.addEntry("Foo");
			malist.addEntry("Bar");
			malist.addEntry("Baz");
		}

		@Test
		public void testAddEntry() {
			malist.addEntry("Omega");
			assertEquals(4, malist.size());
			System.out.println(malist);
		}
		
		@Test
		public void testRemoveEntry() {
			malist.removeEntry("Bar");
			assertEquals(3, malist.size());
			System.out.println("testRemoveEntry(): " + malist);
		}
	
	}

}
