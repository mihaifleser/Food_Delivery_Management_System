package Business;

import java.io.Serializable;

/**
 * Class used to store information about the accounts of the clients
 */

public class Account implements Serializable {
    private String email;
    private String password;


    public Account(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
