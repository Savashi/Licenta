package ro.cristin.dto;

import ro.cristin.model.UserDO;

public class UserNodeDTO implements NodeDTO {
    private UserDO u;
    private static final String COLOR = "green";

    public UserNodeDTO(UserDO u){
        this.u = u;
    }

    @Override
    public String getId() {
        return "u_" + u.getId();
    }

    @Override
    public String getLabel() {
        return u.getName() + " " + u.getSurname();
    }

    @Override
    public String getColor() {
        return COLOR;
    }
}
