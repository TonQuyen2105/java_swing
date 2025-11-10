public class User {
    private String username;
    private String age;
    private String email;
    private Boolean gestBoolean; 

    public User(String username, int age, String email) {
        this.username = username;
        this.age = String.valueOf(age);
        this.email = email;
        this.gestBoolean = false;
    }

    public User(int age, String email) {
        this.username = "Not Provided";
        this.age = "Not Provided";
        this.email = email;
        this.gestBoolean = false;
    }

    public User() {
        this.username = "Not Provided";
        this.age = "Not Provided";
        this.email = "Not Provided";
        this.gestBoolean = true;
    }

    public void displayInfo() {
        if (gestBoolean) {
            System.out.println("Guest User");
        }
        else {
            System.out.println("Registered User");
        }
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}


