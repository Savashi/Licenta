package ro.cristin.dto;

import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultDTO {

    private String currentUser;
    private List<EntityDO> recommended = new ArrayList<>();
    private UserDO userDO;
    private List<EntityDO> covered = new ArrayList<>();

    public ResultDTO(String currentUser, UserDO userDO) {
        this.currentUser = currentUser;
        this.userDO = userDO;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public List<EntityDO> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<EntityDO> recommended) {
        this.recommended = recommended;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }

    public List<EntityDO> getCovered() {
        return covered;
    }

    public void setCovered(List<EntityDO> covered) {
        this.covered = covered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDTO resultDTO = (ResultDTO) o;
        return Objects.equals(recommended, resultDTO.recommended) &&
                Objects.equals(userDO, resultDTO.userDO) &&
                Objects.equals(covered, resultDTO.covered);
    }

    @Override
    public int hashCode() {

        return Objects.hash(recommended, userDO, covered);
    }
}
