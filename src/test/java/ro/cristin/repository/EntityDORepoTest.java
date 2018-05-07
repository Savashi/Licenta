package ro.cristin.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cristin.Application;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EntityDORepoTest {
    
    @Autowired
    EntityDORepo entityRepo;

    @Autowired
    UserDORepo userRepo;

    @Test
    public void testCreateEntityDO() {
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film");
        entity1 = entityRepo.save(entity1);
        assertNotNull(entity1.getName());
        entityRepo.delete(entity1);

    }

    @Test
    public void testDeleteEntityDO() {
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film");
        entity1 = entityRepo.save(entity1);
        entityRepo.delete(entity1);
        assertNull(entityRepo.findOne(entity1.getId()));

    }

    @Test
    public void testUpdateEntityDO() {
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film");
        entity1 = entityRepo.save(entity1);
        entity1.setName("3 billboards outside ebbing missouri");
        entityRepo.save(entity1);
        EntityDO dbEntityDO = entityRepo.findOne(entity1.getId());
        assertEquals(dbEntityDO.getName(),"3 billboards outside ebbing missouri");
        entityRepo.delete(entity1);


    }


   
}