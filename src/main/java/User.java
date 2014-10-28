import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.Serializable;

@SessionScoped
@Named(value = "user")
public class User implements Serializable {
    String login = "test";
    String password = "testpass";

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}











