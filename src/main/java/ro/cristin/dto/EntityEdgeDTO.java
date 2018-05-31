package ro.cristin.dto;

import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

public class EntityEdgeDTO implements EdgeDTO {
    private UserDO fromUser;
    private EntityDO toEntity;
    private static final String COLOR = "red";

    public EntityEdgeDTO(UserDO fromUser, EntityDO toEntity){
        this.fromUser = fromUser;
        this.toEntity = toEntity;
    }

    @Override
    public String getFrom() {
        return "u_" + fromUser.getId();
    }

    @Override
    public String getTo() {
        return "e_" + toEntity.getId();
    }

    @Override
    public String getColor() {
        return COLOR;
    }

    @Override
    public String getRating() {
        return toEntity.getRating() + "";
    }
}
