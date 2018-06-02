package ro.cristin.dto;

import ro.cristin.model.UserDO;

public class UserEdgeDTO  implements EdgeDTO {

    private UserDO fromUser;
    private UserDO toUser;
    private static final String COLOR = "green";

    public UserEdgeDTO(UserDO fromUser, UserDO toUser){
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    @Override
    public String getFrom() {
        return "u_" + fromUser.getId();
    }

    @Override
    public String getTo() {
        return "u_" + toUser.getId();
    }

    @Override
    public Color getColor() {
        return new Color(COLOR);
    }

    @Override
    public String getLabel() {
        return "";
    }
}
