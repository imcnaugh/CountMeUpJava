package test.mcnaughton.bbc.models;

import java.util.UUID;

public class Candidate extends BaseModel{

    private String name;

    public Candidate(UUID id, String name){
        super(id);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        return name != null ? name.equals(candidate.name) : candidate.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
