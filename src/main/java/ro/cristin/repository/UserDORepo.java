package ro.cristin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.cristin.model.UserDO;

public interface UserDORepo extends JpaRepository<UserDO, Integer> {

    @Modifying
    @Query(value = "delete from user_user where idUser=:paramUserId", nativeQuery = true)
    void deleteFromFriends( @Param("paramUserId") int userId);

    @Modifying
    @Query(value = "delete from user where idUser=:paramUserId", nativeQuery = true)
    void deleteFromUser( @Param("paramUserId") int userId);

    @Modifying
    @Query(value = "delete from user_user where idFriend=:paramUserId", nativeQuery = true)
    void deleteFromUserFriends( @Param("paramUserId") int userId);
}