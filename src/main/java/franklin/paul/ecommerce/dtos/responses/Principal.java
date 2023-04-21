package franklin.paul.ecommerce.dtos.responses;

public class Principal {
    private String userId;
    private String username;
    private String country;
    private String token;

    public Principal() {
        super();
    }

    public Principal(String userId, String username, String country) {
        this.userId = userId;
        this.username = username;
        this.country = country;
        this.token = null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
