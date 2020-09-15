package models;

public class Students {
    int id;
    String username;
    String subject;
    int year_of_entry;
    
    public Students() {
        
    }
    
    public Students(String username, String subject, int year_of_entry)
    {
       // this.id = id;
        this.username = username;
        this.subject = subject;
        this.year_of_entry = year_of_entry;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public int getYear_of_entry()
    {
        return year_of_entry;
    }

    public void setYear_of_entry(int year_of_entry)
    {
        this.year_of_entry = year_of_entry;
    }
}
