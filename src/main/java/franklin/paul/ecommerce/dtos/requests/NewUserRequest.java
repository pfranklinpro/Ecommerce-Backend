package franklin.paul.ecommerce.dtos.requests;

public class NewUserRequest {
    private String username;
    private String password;
    private String country;

    public NewUserRequest(String username, String password, String country) {
        this.username = username;
        this.password = password;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
