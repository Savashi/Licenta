package ro.cristin.dto;

import org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

public class EntityEdgeDTO implements EdgeDTO {
    private UserDO fromUser;
    private EntityDO toEntity;
    private int rating;
    private static final String COLOR = "red";

    public EntityEdgeDTO(UserDO fromUser, EntityDO toEntity, int rating){
        this.fromUser = fromUser;
        this.toEntity = toEntity;
        this.rating = rating;
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
    public Color getColor() {
        return new Color(COLOR);
    }

    @Override
    public String getLabel() {
        return rating +"*";
    }
}
