package def;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testHashfunction() throws Exception {
		String test1 = "test1";
		String test2 = "test2";
		assertFalse(Password.getSaltedHash(test1).equals(Password.getSaltedHash(test2)));
		assertFalse(Password.getSaltedHash(test1).equals(Password.getSaltedHash(test1)));
	}

	@Test
	public void testUserName() {
		User test = new User("Maier", 500);
		assertTrue(test.getUsername().equals("Maier"));
		test.setUsername("Muller");
		assertTrue(test.getUsername().equals("Muller"));
	}

	@Test
	public void testIncome() {
		User test = new User("Maier", 500);
		assertTrue(test.getIncome() == 500);
		test.setIncome(10000);
		assertTrue(test.getIncome() == 10000);
	}

	@Test
	public void testUnlockIncome() {
		User test = new User("Maier", 500);
		test.GeneratePassword("ValidPassword1!");
		assertTrue(test.UnlockIncome("Maier", "ValidPassword1!") == 500);
		assertTrue(test.UnlockIncome("Muller", "wrongPassword") == 0);
	}

	@Test
	public void testPassword() {
		User test = new User("Maier", 500);
		assertTrue(test.IsValidPassword("ValidPassword1!"));
		assertFalse(test.IsValidPassword("nouppercase1!"));
		assertFalse(test.IsValidPassword("NOLOWERCASE1!"));
		assertFalse(test.IsValidPassword("toShort1!"));
		assertFalse(test.IsValidPassword("NoNumber!!!"));
		assertFalse(test.IsValidPassword("NoSpecialCharacter1"));
	}

}
