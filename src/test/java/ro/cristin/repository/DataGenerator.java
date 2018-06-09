package ro.cristin.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cristin.Application;
import ro.cristin.model.EntityDO;
import ro.cristin.model.UserDO;
import ro.cristin.model.UserEntityDO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DataGenerator {

    @Autowired
    private UserDORepo userRepo;

    @Autowired
    private EntityDORepo entityRepo;

    @Autowired
    private UserEntityDORepo userEntityDORepo;



    @Test
    public void generateData(){
        userEntityDORepo.deleteAll();
        userRepo.deleteAll();
        entityRepo.deleteAll();
        UserDO cristin = new UserDO("sava.cristin@yahoo.ro", "Sava","Cristin");
        cristin = userRepo.save(cristin);
        EntityDO entity1 = new EntityDO("A", "Drama","Film");
        entity1 = entityRepo.save(entity1);
        EntityDO entity2 = new EntityDO("B", "Drama","Film");
        entity2 = entityRepo.save(entity2);
        EntityDO entity3 = new EntityDO("C", "Drama","Film");
        entity3 = entityRepo.save(entity3);
        UserEntityDO userEntityDO1 = new UserEntityDO(cristin,entity1,5);
        userEntityDORepo.save(userEntityDO1);
        UserEntityDO userEntityDO2 = new UserEntityDO(cristin,entity2,4);
        userEntityDORepo.save(userEntityDO2);
        UserEntityDO userEntityDO3 = new UserEntityDO(cristin,entity3,1);
        userEntityDORepo.save(userEntityDO3);


        UserDO sneaky = new UserDO("salajan.alex@yahoo.ro", "Salajan","Alex");
        sneaky = userRepo.save(sneaky);
        EntityDO entity4 = new EntityDO("D", "Drama","Film");
        entity4 = entityRepo.save(entity4);
        EntityDO entity5 = new EntityDO("E", "Drama","Film");
        entity5 = entityRepo.save(entity5);
        EntityDO entity6 = new EntityDO("F", "Drama","Film");
        entity6 = entityRepo.save(entity6);
        UserEntityDO userEntityDO4 = new UserEntityDO(sneaky,entity4,5);
        userEntityDORepo.save(userEntityDO4);
        UserEntityDO userEntityDO5 = new UserEntityDO(sneaky,entity5,4);
        userEntityDORepo.save(userEntityDO5);
        UserEntityDO userEntityDO6 = new UserEntityDO(sneaky,entity6,1);
        userEntityDORepo.save(userEntityDO6);
        UserEntityDO userEntityDO7 = new UserEntityDO(sneaky,entity1,5);
        userEntityDORepo.save(userEntityDO7);
        UserEntityDO userEntityDO8 = new UserEntityDO(sneaky,entity2,3);
        userEntityDORepo.save(userEntityDO8);


        UserDO pirpi = new UserDO("pirpidel.sebastian@yahoo.ro", "Pirpidel","Sebastian");
        pirpi = userRepo.save(pirpi);
        EntityDO entity7 = new EntityDO("G", "Drama","Film");
        entity7 = entityRepo.save(entity7);
        EntityDO entity8 = new EntityDO("H", "Drama","Film");
        entity8 = entityRepo.save(entity8);
        EntityDO entity9 = new EntityDO("I", "Drama","Film");
        entity9 = entityRepo.save(entity9);
        UserEntityDO userEntityDO9 = new UserEntityDO(pirpi,entity7,5);
        userEntityDORepo.save(userEntityDO9);
        UserEntityDO userEntityDO10 = new UserEntityDO(pirpi,entity8,4);
        userEntityDORepo.save(userEntityDO10);
        UserEntityDO userEntityDO11 = new UserEntityDO(pirpi,entity9,1);
        userEntityDORepo.save(userEntityDO11);
        UserEntityDO userEntityDO12 = new UserEntityDO(pirpi,entity1,5);
        userEntityDORepo.save(userEntityDO12);




        UserDO lupoaie = new UserDO("lupoaie.robert@yahoo.ro", "Lupoaie","Robert");
        lupoaie = userRepo.save(lupoaie);
        EntityDO entity10 = new EntityDO("J", "Drama","Film");
        entity10 = entityRepo.save(entity10);
        EntityDO entity11 = new EntityDO("K", "Drama","Film");
        entity11 = entityRepo.save(entity11);
        EntityDO entity12 = new EntityDO("L", "Drama","Film");
        entity12 = entityRepo.save(entity12);
        UserEntityDO userEntityDO13 = new UserEntityDO(lupoaie,entity10,5);
        userEntityDORepo.save(userEntityDO13);
        UserEntityDO userEntityDO14 = new UserEntityDO(lupoaie,entity11,4);
        userEntityDORepo.save(userEntityDO14);
        UserEntityDO userEntityDO15 = new UserEntityDO(lupoaie,entity12,1);
        userEntityDORepo.save(userEntityDO15);
        UserEntityDO userEntityDO16 = new UserEntityDO(lupoaie,entity1,5);
        userEntityDORepo.save(userEntityDO16);
        UserEntityDO userEntityDO17 = new UserEntityDO(lupoaie,entity2,3);
        userEntityDORepo.save(userEntityDO17);

        sneaky.addUser(pirpi);
        sneaky.addUser(lupoaie);
        sneaky = userRepo.save(sneaky);
        cristin.addUser(sneaky);
        userRepo.save(cristin);
    }
}
