package def;

import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

	private String username;
	private String hashedPassword;
	private int income;
	private int minPasswordLength = 10;
	private int minLowerCase = 1;
	private int minUpperCase = 1;
	private int minNumbers = 1;
	private int minSpecial = 1;
	private static final Logger log = Logger.getLogger( User.class.getName() );
	User() {
	}

	User(String name, int income) {
		this.username = name;
		this.income = income;
	}

	private void StorePassword(String passwordHash) {
		this.hashedPassword = passwordHash;
	}

	public void GeneratePassword(String password) {
		if (IsValidPassword(password)) {
			try {
				this.StorePassword(Password.getSaltedHash(password));
			} catch (Exception e) {
				log.info("there was an exception");
			}
		} else {
			System.out.println("Password does not match criteria");
		}
	}

	int UnlockIncome(String username, String cleartextPassword) {
		try {
			if (Password.check(cleartextPassword, this.hashedPassword)) {
				return this.income;
			} else {
				System.out.println("Passwort does not match stored hash for user");

			}
		} catch (Exception e) {
			log.severe("there was an exception");

		}
		return 0;

	}

	// Password check
	public boolean IsValidPassword(String password) {
		int upperCount = 0; 	//How many uppercase letters are in the password?
		int lowerCount = 0;		//How many lowercase letters are in the password?
		int numCount = 0;		//How many digits are in the password?
		int specialCount = 0;	//How many special characters are in the password?
		if (password.length() >= minPasswordLength) { //check password length
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (Character.isUpperCase(c)) { //check for uppercase
					upperCount++;
				}
				if (Character.isLowerCase(c)) { //check for lowercase
					lowerCount++;
				}
				if (Character.isDigit(c)) { //check for digits
					numCount++;
				}
				if (c >= 33 && c <= 46 || c == 64) { //check for special character
					specialCount++;
				}
			}
		}
		if (upperCount >= minUpperCase && lowerCount >= minLowerCase && numCount >= minNumbers
				&& specialCount >= minSpecial) {
			return true;
		} else {
			return false;
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

}