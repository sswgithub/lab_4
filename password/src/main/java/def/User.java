package def;

public class User {

    private String username;
    private String hashed_password;
    private int income;

    User(){}

    User(String name, int income){
        this.username = name;
        this.income = income;
    }

    private void store_password(String password_hash){
        this.hashed_password = password_hash;
    }

    public void generate_password(String password){
        try {
			this.store_password(Password.getSaltedHash(password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    int unlock_income(String username, String cleartext_password){
        try {
			if(Password.check(cleartext_password, this.hashed_password)){
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

}