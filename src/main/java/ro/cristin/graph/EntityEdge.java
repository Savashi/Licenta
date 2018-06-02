package ro.cristin.graph;

public class EntityEdge {

    private UserNode from;
    private EntityNode to;
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public UserNode getFrom() {
        return from;
    }

    public void setFrom(UserNode from) {
        this.from = from;
    }

    public EntityNode getTo() {
        return to;
    }

    public void setTo(EntityNode to) {
        this.to = to;
    }
}
