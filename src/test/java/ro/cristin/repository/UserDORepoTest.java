package ro.cristin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cristin.Application;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserDORepoTest {


    @Autowired
    private UserDORepo userRepo;

    @Autowired
    private EntityDORepo entityRepo;

    @Test
    @Transactional
    public void testCreateUser() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        user1 = userRepo.save(user1);
        assertNotNull(user1.getEmail());
        //userRepo.delete(user1);

    }

    @Test
    public void testDeleteUser() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        user1 = userRepo.save(user1);
        userRepo.delete(user1);
        assertNull(userRepo.findOne(user1.getId()));
    }

    @Test
    @Transactional
    public void testUpdateUser() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        user1 = userRepo.save(user1);
        user1.setName("Salajan");
        userRepo.save(user1);
        UserDO dbUser = userRepo.findOne(user1.getId());
        assertEquals(dbUser.getName(),"Salajan");
        //userRepo.delete(user1);
    }

    @Test
    @Transactional
    public void testCreateUserUser() {

        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        assertNotNull(user1.getName());
        UserDO user2 = new UserDO("salajan.alex@yahoo.com", "Salajan","Alex","password");
        UserDO user3 = new UserDO("pirpidel.sebastian@yahoo.com", "Pirpidel","Sebastian","password");
        user2.addUser(user3);
        //user2 = userRepo.save(user2);
        user1.addUser(user2);
        assertNotNull(user3.getName());
        user1 = userRepo.save(user1);
        //userRepo.delete(user2);
        //userRepo.delete(user1);
        //userRepo.delete(user2);
        //userRepo.delete(user3);
        }

    @Test
    public void testDeleteUserUser() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        assertNotNull(user1.getName());
        UserDO user2 = new UserDO("salajan.alex@yahoo.com", "Salajan","Alex","password");
        UserDO user3 = new UserDO("pirpidel.sebastian@yahoo.com", "Pirpidel","Sebastian","password");
        user2.addUser(user3);
        user1.addUser(user2);
        assertNotNull(user2.getName());
        user1 = userRepo.save(user1);
        userRepo.delete(user1);
        assertNull(userRepo.findOne(user1.getId()));
        userRepo.delete(user2);
        userRepo.delete(user3);
        assertNull(userRepo.findOne(user2.getId()));
        assertNull(userRepo.findOne(user3.getId()));
    }

    @Test
    @Transactional
    public void testUpdateUserUser() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        assertNotNull(user1.getName());
        UserDO user2 = new UserDO("salajan.alex@yahoo.com", "Salajan","Alex","password");
        user1.addUser(user2);
        user1 = userRepo.save(user1);
        user2.setName("Pirpidel");
        userRepo.save(user1);
        UserDO dbuser = userRepo.findOne(user2.getId());
        assertEquals(dbuser.getName(),"Pirpidel");
        //userRepo.delete(user1);
        //userRepo.delete(user2);
    }

    @Test
    @Transactional
    public void testCreateUserEntity() {

        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        assertNotNull(user1.getName());
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film",7);
        user1.addEntity(entity1);
        user1 = userRepo.save(user1);
        assertNotNull(entity1.getName());
        //userRepo.delete(user1);
        //entityRepo.delete(entity1);
    }

    @Test
    public void testDeleteUserEntity() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        assertNotNull(user1.getName());
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film",7);
        user1.addEntity(entity1);
        user1 = userRepo.save(user1);
        userRepo.delete(user1);
        entityRepo.delete(entity1);
        assertNull(entityRepo.findOne(entity1.getId()));
        assertNull(userRepo.findOne(user1.getId()));

    }

    @Test
    @Transactional
    public void testUpdateUserEntity() {
        UserDO user1 = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        assertNotNull(user1.getName());
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film",7);
        user1.addEntity(entity1);
        user1 = userRepo.save(user1);
        entity1.setName("Mud");
        entityRepo.save(entity1);
        EntityDO dbentity = entityRepo.findOne(entity1.getId());
        assertEquals(dbentity.getName(),"Mud");
       //userRepo.delete(user1);
       //entityRepo.delete(entity1);
    }
}