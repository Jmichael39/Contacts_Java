import java.io.*;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        StringBuilder encryptPassword = new StringBuilder();
        for (char ch : password.toCharArray()) {
            encryptPassword.append((char) (ch + 1));
        }
        out.writeObject(encryptPassword.toString());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        password = (String) in.readObject();
        StringBuilder encryptPassword = new StringBuilder();
        for (char ch : password.toCharArray()) {
            encryptPassword.append((char) (ch - 1));
        }
        password = encryptPassword.toString();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}