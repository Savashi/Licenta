package ro.cristin.graphv2;

public class EntityEdge {

    private UserNode from;
    private EntityNode to;

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
