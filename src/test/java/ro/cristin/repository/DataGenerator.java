package ro.cristin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cristin.Application;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;
import ro.cristin.service.EntityDOService;
import ro.cristin.service.UserDOService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DataGenerator {

    @Autowired
    private UserDORepo userRepo;

    @Autowired
    private EntityDORepo entityRepo;

    @Autowired
    private AttributeDORepo attributeDORepo;

    @Test
    public void generateData(){
        attributeDORepo.deleteAll();
        userRepo.deleteAll();
        entityRepo.deleteAll();
        UserDO cristin = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin","passw");
        cristin = userRepo.save(cristin);
        EntityDO entity1 = new EntityDO("A", "Drama","Film",5);
        entity1 = entityRepo.save(entity1);
        EntityDO entity2 = new EntityDO("B", "Drama","Film",3);
        entity2 = entityRepo.save(entity2);
        EntityDO entity3 = new EntityDO("C", "Drama","Film",1);
        entity3 = entityRepo.save(entity3);
        cristin.addEntity(entity1);
        cristin.addEntity(entity2);
        cristin.addEntity(entity3);
        cristin = userRepo.save(cristin);


        UserDO sneaky = new UserDO("salajan.alex@yahoo.ro", "Salajan","Alex","passw");
        sneaky = userRepo.save(sneaky);
        EntityDO entity4 = new EntityDO("D", "Drama","Film",3);
        entity4 = entityRepo.save(entity4);
        EntityDO entity5 = new EntityDO("E", "Drama","Film",2);
        entity5 = entityRepo.save(entity5);
        EntityDO entity6 = new EntityDO("F", "Drama","Film",4);
        entity6 = entityRepo.save(entity6);
        sneaky.addEntity(entity4);
        sneaky.addEntity(entity5);
        sneaky.addEntity(entity6);
        sneaky.addEntity(entity1);
        sneaky.addEntity(entity2);
        sneaky = userRepo.save(sneaky);


        UserDO pirpi = new UserDO("pirpidel.sebastian@yahoo.ro", "Pirpidel","Sebastian","passw");
        pirpi = userRepo.save(pirpi);
        EntityDO entity7 = new EntityDO("G", "Drama","Film",4);
        entity7 = entityRepo.save(entity7);
        EntityDO entity8 = new EntityDO("H", "Drama","Film",3);
        entity8 = entityRepo.save(entity8);
        EntityDO entity9 = new EntityDO("I", "Drama","Film",1);
        entity9 = entityRepo.save(entity9);
        pirpi.addEntity(entity7);
        pirpi.addEntity(entity8);
        pirpi.addEntity(entity9);
        pirpi.addEntity(entity1);
        pirpi = userRepo.save(pirpi);



        UserDO lupoaie = new UserDO("lupoaie.robert@yahoo.ro", "Lupoaie","Robert","passw");
        lupoaie = userRepo.save(lupoaie);
        EntityDO entity10 = new EntityDO("J", "Drama","Film",5);
        entity10 = entityRepo.save(entity10);
        EntityDO entity11 = new EntityDO("K", "Drama","Film",2);
        entity11 = entityRepo.save(entity11);
        EntityDO entity12 = new EntityDO("L", "Drama","Film",1);
        entity12 = entityRepo.save(entity12);
        lupoaie.addEntity(entity10);
        lupoaie.addEntity(entity11);
        lupoaie.addEntity(entity12);
        lupoaie.addEntity(entity1);
        lupoaie.addEntity(entity2);
        lupoaie = userRepo.save(lupoaie);


        sneaky.addUser(pirpi);
        sneaky.addUser(lupoaie);
        sneaky = userRepo.save(sneaky);
        cristin.addUser(sneaky);
        userRepo.save(cristin);

    }
}
