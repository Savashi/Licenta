package ro.cristin.dto;

import ro.cristin.model.EntityDO;

public class EntityNodeDTO implements  NodeDTO{
    private EntityDO e;
    private static final String COLOR = "red";

    public EntityNodeDTO(EntityDO e){
        this.e = e;
    }

    @Override
    public String getId() {
        return "e_" + e.getId();
    }

    @Override
    public String getLabel() {
        return e.getName();
    }

    @Override
    public String getColor() {
        return COLOR;
    }
}
