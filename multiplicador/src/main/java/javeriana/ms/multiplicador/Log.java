package javeriana.ms.multiplicador;

public class Log {
    String user;
    String dateTime;
    public Log() {
    }

    
    public Log(String user, String dateTime) {
        this.user = user;
        this.dateTime = dateTime;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
