package ucu.edu.secondtask;

public class Database extends БазаДаних {
    public String getUserdata() {
        return отриматиДаніКористувача();
    }

    public String getStaticData() {
        return отриматиСтатистичніДані();
    }
    
}
