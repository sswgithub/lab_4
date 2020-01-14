package def;

public class User {

	private String username;
	private String hashed_password;
	private int income;
	private int minPasswordLength = 10;
	private int minLowerCase = 1;
	private int minUpperCase = 1;
	private int minNumbers = 1;
	private int minSpecial = 1;

	User() {
	}

	User(String name, int income) {
		this.username = name;
		this.income = income;
	}

	private void store_password(String password_hash) {
		this.hashed_password = password_hash;
	}

	public void generate_password(String password) {
		if (isValidPassword(password)) {
			try {
				this.store_password(Password.getSaltedHash(password));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Password does not match criteria");
		}
	}

	int unlock_income(String username, String cleartext_password) {
		try {
			if (Password.check(cleartext_password, this.hashed_password)) {
				return this.income;
			} else {
				System.out.println("Passwort does not match stored hash for user");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return 0;

	}

	// Password check
	public boolean isValidPassword(String password) {
		int upperCount = 0;
		int lowerCount = 0;
		int numCount = 0;
		int specialCount = 0;
		if (password.length() >= minPasswordLength) {
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (Character.isUpperCase(c)) {
					upperCount++;
				}
				if (Character.isLowerCase(c)) {
					lowerCount++;
				}
				if (Character.isDigit(c)) {
					numCount++;
				}
				if (c >= 33 && c <= 46 || c == 64) {
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