package test.mcnaughton.bbc.models;

import java.util.UUID;

public class User extends BaseModel {

    private String name;
    private int numTimesVoted;

    public User(UUID id, String name){
        super(id);
        this.name = name;
        this.numTimesVoted = 0;
    }

    public void userVoted(){
        numTimesVoted++;
    }

    public int getNumTimesVoted(){
        return numTimesVoted;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (numTimesVoted != user.numTimesVoted) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + numTimesVoted;
        return result;
    }
}
