package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tank {
    @JsonProperty("id")
    private int id;
    @JsonProperty("capacity")
    private Integer capacity;

    public Tank () {}

    public Tank(int id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
