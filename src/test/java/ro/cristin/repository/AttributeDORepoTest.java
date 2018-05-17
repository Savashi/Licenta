package ro.cristin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cristin.Application;
import ro.cristin.model.AttributeDO;
import ro.cristin.model.EntityDO;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AttributeDORepoTest {
    
    @Autowired
    AttributeDORepo attributeRepo;

    @Autowired
    EntityDORepo entityRepo;

    @Test
    @Transactional
    public void testCreateAttribute() {

        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film",7);
        assertNotNull(entity1.getName());
        AttributeDO attribute1 = new AttributeDO("Regizor", "Steven Spielberg");
        entity1.addAttribute(attribute1);
        assertNotNull(attribute1.getName());
        entity1 = entityRepo.save(entity1);
        //attributeRepo.delete(attribute1);
        //entityRepo.delete(entity1);
    }

    @Test
    public void testDeleteAttribute() {
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film",7);
        assertNotNull(entity1.getName());
        AttributeDO attribute1 = new AttributeDO("Regizor", "Steven Spielberg");
        entity1.addAttribute(attribute1);
        entity1 = entityRepo.save(entity1);
        attributeRepo.delete(attribute1);
        entityRepo.delete(entity1);
        assertNull(entityRepo.findOne(entity1.getId()));
        assertNull(attributeRepo.findOne(attribute1.getId()));
    }

    @Test
    @Transactional
    public void testUpdateAttribute() {
        EntityDO entity1 = new EntityDO("Titanic", "Drama","Film",7);
        assertNotNull(entity1.getName());
        AttributeDO attribute1 = new AttributeDO("Regizor", "Steven Spielberg");
        entity1.addAttribute(attribute1);
        entity1 = entityRepo.save(entity1);
        attribute1.setValue("Martin Scorsese");
        attributeRepo.save(attribute1);
        AttributeDO dbAttribute = attributeRepo.findOne(attribute1.getId());
        assertEquals(dbAttribute.getValue(),"Martin Scorsese");
        //entityRepo.delete(entity1);
    }


}