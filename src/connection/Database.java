package connection;

public class Database {
   String url;
   String username;
   String password;
   String driver;
   
   public Database() {
       this.url = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
       this.username = "root";
       this.password = "";
       this.driver = "com.mysql.cj.jdbc.Driver";
   }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDriver()
    {
        return driver;
    }

    public void setDriver(String driver)
    {
        this.driver = driver;
    }
}
