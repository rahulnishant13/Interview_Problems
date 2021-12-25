public class User {
    private int userId;
    private String name;
    private String email;
    private String mobile_number;

    public User(int userId, String name, String email, String mobile_number){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

}
