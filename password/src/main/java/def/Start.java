package def;
public class Start{

    public static void main(String[] args){

        User u1 = new User("Muller", 60000);
        User u2 = new User("Fritz", 75000);
        
        u1.generate_password("abcd1234");
        u2.generate_password("4321dcba");
    
        System.out.println(u1.unlock_income("Muller", "abcd1234"));
        System.out.println(u2.unlock_income("Muller", "4321dcba"));
    

    }

}