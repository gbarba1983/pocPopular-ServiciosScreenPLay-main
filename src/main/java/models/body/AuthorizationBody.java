package models.body;

public class AuthorizationBody {
    String userName ;
    String password ;

    public AuthorizationBody(String user, String password) {
        this.userName  = user;
        this.password  = password;
    }

    public String getUser() {
        return userName ;
    }

    public void setUser(String user) {
        this.userName  = user;
    }

    public String getPassword() {
        return password ;
    }

    public void setPassword(String password) {
        this.password  = password;
    }
}
