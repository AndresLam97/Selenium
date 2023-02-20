package Model.PageObject;

public class LoginPageObject {

    private String email;
    private String password;

    public LoginPageObject(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getPassword()
    {
        return this.password;
    }
}
