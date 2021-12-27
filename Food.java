package food.manage;

public class Food {
    private String ID;
    private String name;
    private String type;
    private float weight;
    private String place;
    private String expiredDate;

    public Food() {
    }

    public Food(String ID, String name, String type, float weight, String place, String expiredDate) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }
}
