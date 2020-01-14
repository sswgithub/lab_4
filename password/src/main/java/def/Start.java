package def;
public class Start{

    public static void main(String[] args){

        User u1 = new User("Muller", 60000);
        User u2 = new User("Fritz", 75000);
        
        u1.GeneratePassword("abcd1234");
        u2.GeneratePassword("4321dcba");
    

    

    }

}