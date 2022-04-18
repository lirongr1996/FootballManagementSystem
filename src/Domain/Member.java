package Domain;

public class Member {
    protected String userName;
    protected String password;

    public Member(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Member(Member m){
        this.userName=m.userName;
        this.password=m.password;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
