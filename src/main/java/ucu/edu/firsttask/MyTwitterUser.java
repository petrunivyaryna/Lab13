package ucu.edu.firsttask;

import java.time.LocalDate;

public class MyTwitterUser implements User {
    private TwitterUser twitterUser;

    public MyTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    @Override
    public String getEmail() {
        return twitterUser.getUserMail();
    }

    @Override
    public String getCountry() {
        return twitterUser.getCountry();
    }

    @Override
    public LocalDate getLastActiveDate() {
        return twitterUser.getLastActiveTime().toLocalDate();
    }
}
