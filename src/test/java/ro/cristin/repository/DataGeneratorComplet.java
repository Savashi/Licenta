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
public class DataGeneratorComplet {

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
        EntityDO entity1 = new EntityDO("Movie", "Titanic","Drama");
        entity1 = entityRepo.save(entity1);
        EntityDO entity2 = new EntityDO("Movie", "Super 8","Mystery");
        entity2 = entityRepo.save(entity2);
        EntityDO entity3 = new EntityDO("Movie", "Mowgli","Adventure");
        entity3 = entityRepo.save(entity3);
        EntityDO entity13 = new EntityDO("Book", "Noapte nesfarsita","Mystery");
        entity13 = entityRepo.save(entity13);
        EntityDO entity14 = new EntityDO("Book", "Moara cu noroc","Drama");
        entity14 = entityRepo.save(entity14);
        EntityDO entity15 = new EntityDO("Book", "Enders Game","S.F.");
        entity15 = entityRepo.save(entity15);
        EntityDO entity16 = new EntityDO("Music", "Chantage","Pop");
        entity16 = entityRepo.save(entity16);
        EntityDO entity17 = new EntityDO("Music", "Zombie","Rock");
        entity17 = entityRepo.save(entity17);
        EntityDO entity18 = new EntityDO("Music", "One Kiss","Pop");
        entity18 = entityRepo.save(entity18);
        EntityDO entity19 = new EntityDO("Game", "Witcher 3","Adventure");
        entity19 = entityRepo.save(entity19);
        EntityDO entity20 = new EntityDO("Game", "Darksiders","Adventure");
        entity20 = entityRepo.save(entity20);
        EntityDO entity21 = new EntityDO("Game", "GTA V","Open World");
        entity21 = entityRepo.save(entity21);
        UserEntityDO userEntityDO1 = new UserEntityDO(cristin,entity1,9);
        userEntityDORepo.save(userEntityDO1);
        UserEntityDO userEntityDO2 = new UserEntityDO(cristin,entity2,6);
        userEntityDORepo.save(userEntityDO2);
        UserEntityDO userEntityDO3 = new UserEntityDO(cristin,entity3,4);
        userEntityDORepo.save(userEntityDO3);

        UserEntityDO userEntityDO18 = new UserEntityDO(cristin,entity13,7);
        userEntityDORepo.save(userEntityDO18);
        UserEntityDO userEntityDO19 = new UserEntityDO(cristin,entity14,7);
        userEntityDORepo.save(userEntityDO19);
        UserEntityDO userEntityDO20 = new UserEntityDO(cristin,entity15,8);
        userEntityDORepo.save(userEntityDO20);

        UserEntityDO userEntityDO21 = new UserEntityDO(cristin,entity16,10);
        userEntityDORepo.save(userEntityDO21);
        UserEntityDO userEntityDO22 = new UserEntityDO(cristin,entity17,2);
        userEntityDORepo.save(userEntityDO22);
        UserEntityDO userEntityDO23 = new UserEntityDO(cristin,entity18,7);
        userEntityDORepo.save(userEntityDO23);

        UserEntityDO userEntityDO24 = new UserEntityDO(cristin,entity19,3);
        userEntityDORepo.save(userEntityDO24);
        UserEntityDO userEntityDO25 = new UserEntityDO(cristin,entity20,8);
        userEntityDORepo.save(userEntityDO25);
        UserEntityDO userEntityDO26 = new UserEntityDO(cristin,entity21,8);
        userEntityDORepo.save(userEntityDO26);


        UserDO sneaky = new UserDO("salajan.alex@yahoo.ro", "Salajan","Alex");
        sneaky = userRepo.save(sneaky);
        EntityDO entity4 = new EntityDO("Movie", "Everybody Knows","Drama");
        entity4 = entityRepo.save(entity4);
        EntityDO entity5 = new EntityDO("Movie", "Disobedience","Drama");
        entity5 = entityRepo.save(entity5);
        EntityDO entity6 = new EntityDO("Movie", "Blue Valentine","Romance");
        entity6 = entityRepo.save(entity6);
        EntityDO entity22 = new EntityDO("Book", "Harry Potter","Fantasy");
        entity22 = entityRepo.save(entity22);
        EntityDO entity23 = new EntityDO("Book", "Hunger Games","Adventure");
        entity23 = entityRepo.save(entity23);
        EntityDO entity24 = new EntityDO("Book", "Da Vinci Code","Thriller");
        entity24 = entityRepo.save(entity24);
        EntityDO entity25 = new EntityDO("Music", "Bangarang","Electric");
        entity25 = entityRepo.save(entity25);
        EntityDO entity26 = new EntityDO("Music", "Tenis Court","Dubstep");
        entity26 = entityRepo.save(entity26);
        EntityDO entity27 = new EntityDO("Music", "In The Club","Rap");
        entity27 = entityRepo.save(entity27);
        EntityDO entity28 = new EntityDO("Game", "Assassins Creed","Adventure");
        entity28 = entityRepo.save(entity28);
        EntityDO entity29 = new EntityDO("Game", "God of War","Adventure");
        entity29 = entityRepo.save(entity29);
        EntityDO entity30 = new EntityDO("Game", "FIFA 2018","Sport");
        entity30 = entityRepo.save(entity30);
        UserEntityDO userEntityDO4 = new UserEntityDO(sneaky,entity4,10);
        userEntityDORepo.save(userEntityDO4);
        UserEntityDO userEntityDO5 = new UserEntityDO(sneaky,entity5,6);
        userEntityDORepo.save(userEntityDO5);
        UserEntityDO userEntityDO6 = new UserEntityDO(sneaky,entity6,9);
        userEntityDORepo.save(userEntityDO6);
        UserEntityDO userEntityDO7 = new UserEntityDO(sneaky,entity1,9);
        userEntityDORepo.save(userEntityDO7);
        UserEntityDO userEntityDO8 = new UserEntityDO(sneaky,entity2,7);
        userEntityDORepo.save(userEntityDO8);


        UserEntityDO userEntityDO27 = new UserEntityDO(sneaky,entity22,7);
        userEntityDORepo.save(userEntityDO27);
        UserEntityDO userEntityDO28 = new UserEntityDO(sneaky,entity23,5);
        userEntityDORepo.save(userEntityDO28);
        UserEntityDO userEntityDO29 = new UserEntityDO(sneaky,entity24,10);
        userEntityDORepo.save(userEntityDO29);
        UserEntityDO userEntityDO30 = new UserEntityDO(sneaky,entity13,6);
        userEntityDORepo.save(userEntityDO30);
        UserEntityDO userEntityDO31 = new UserEntityDO(sneaky,entity15,7);
        userEntityDORepo.save(userEntityDO31);

        UserEntityDO userEntityDO32 = new UserEntityDO(sneaky,entity25,9);
        userEntityDORepo.save(userEntityDO32);
        UserEntityDO userEntityDO33 = new UserEntityDO(sneaky,entity26,6);
        userEntityDORepo.save(userEntityDO33);
        UserEntityDO userEntityDO34 = new UserEntityDO(sneaky,entity27,8);
        userEntityDORepo.save(userEntityDO34);
        UserEntityDO userEntityDO35 = new UserEntityDO(sneaky,entity16,5);
        userEntityDORepo.save(userEntityDO35);

        UserEntityDO userEntityDO36 = new UserEntityDO(sneaky,entity28,6);
        userEntityDORepo.save(userEntityDO36);
        UserEntityDO userEntityDO37 = new UserEntityDO(sneaky,entity29,9);
        userEntityDORepo.save(userEntityDO37);
        UserEntityDO userEntityDO38 = new UserEntityDO(sneaky,entity30,10);
        userEntityDORepo.save(userEntityDO38);
        UserEntityDO userEntityDO39 = new UserEntityDO(sneaky,entity20,7);
        userEntityDORepo.save(userEntityDO39);
        UserEntityDO userEntityDO40 = new UserEntityDO(sneaky,entity21,8);
        userEntityDORepo.save(userEntityDO40);


        UserDO pirpi = new UserDO("pirpidel.sebastian@yahoo.ro", "Pirpidel","Sebastian");
        pirpi = userRepo.save(pirpi);
        EntityDO entity7 = new EntityDO("Movie", "Locke","Drama");
        entity7 = entityRepo.save(entity7);
        EntityDO entity8 = new EntityDO("Movie", "American Pie","Comedy");
        entity8 = entityRepo.save(entity8);
        EntityDO entity9 = new EntityDO("Movie", "Shame","Drama");
        entity9 = entityRepo.save(entity9);
        EntityDO entity31 = new EntityDO("Book", "Tara Duncan","Fantasy");
        entity31 = entityRepo.save(entity31);
        EntityDO entity32 = new EntityDO("Book", "The Spooks Apprentice","Adventure");
        entity32 = entityRepo.save(entity32);
        EntityDO entity33 = new EntityDO("Book", "Maitreyi","Romance");
        entity33 = entityRepo.save(entity33);
        EntityDO entity34 = new EntityDO("Music", "Candy Shop","Rap");
        entity34 = entityRepo.save(entity34);
        EntityDO entity35 = new EntityDO("Music", "Dale Papi","Pop");
        entity35 = entityRepo.save(entity35);
        EntityDO entity36 = new EntityDO("Music", "Don't worry be Happy","Reggae");
        entity36 = entityRepo.save(entity36);
        EntityDO entity37 = new EntityDO("Game", "Need For Speed","Cars");
        entity37 = entityRepo.save(entity37);
        EntityDO entity38 = new EntityDO("Game", "League of Legends","Online");
        entity38 = entityRepo.save(entity38);
        EntityDO entity39 = new EntityDO("Game", "Metin2","MMORPG");
        entity39 = entityRepo.save(entity39);
        UserEntityDO userEntityDO9 = new UserEntityDO(pirpi,entity7,8);
        userEntityDORepo.save(userEntityDO9);
        UserEntityDO userEntityDO10 = new UserEntityDO(pirpi,entity8,9);
        userEntityDORepo.save(userEntityDO10);
        UserEntityDO userEntityDO11 = new UserEntityDO(pirpi,entity9,3);
        userEntityDORepo.save(userEntityDO11);
        UserEntityDO userEntityDO12 = new UserEntityDO(pirpi,entity1,9);
        userEntityDORepo.save(userEntityDO12);

        UserEntityDO userEntityDO41 = new UserEntityDO(pirpi,entity31,7);
        userEntityDORepo.save(userEntityDO41);
        UserEntityDO userEntityDO42 = new UserEntityDO(pirpi,entity32,6);
        userEntityDORepo.save(userEntityDO42);
        UserEntityDO userEntityDO43 = new UserEntityDO(pirpi,entity33,9);
        userEntityDORepo.save(userEntityDO43);
        UserEntityDO userEntityDO44 = new UserEntityDO(pirpi,entity13,10);
        userEntityDORepo.save(userEntityDO44);
        UserEntityDO userEntityDO45 = new UserEntityDO(pirpi,entity15,5);
        userEntityDORepo.save(userEntityDO45);

        UserEntityDO userEntityDO46 = new UserEntityDO(pirpi,entity34,2);
        userEntityDORepo.save(userEntityDO46);
        UserEntityDO userEntityDO47 = new UserEntityDO(pirpi,entity35,6);
        userEntityDORepo.save(userEntityDO47);
        UserEntityDO userEntityDO48 = new UserEntityDO(pirpi,entity36,10);
        userEntityDORepo.save(userEntityDO48);
        UserEntityDO userEntityDO49 = new UserEntityDO(pirpi,entity17,7);
        userEntityDORepo.save(userEntityDO49);
        UserEntityDO userEntityDO50 = new UserEntityDO(pirpi,entity18,8);
        userEntityDORepo.save(userEntityDO50);

        UserEntityDO userEntityDO51 = new UserEntityDO(pirpi,entity37,4);
        userEntityDORepo.save(userEntityDO51);
        UserEntityDO userEntityDO52 = new UserEntityDO(pirpi,entity38,3);
        userEntityDORepo.save(userEntityDO52);
        UserEntityDO userEntityDO53 = new UserEntityDO(pirpi,entity39,9);
        userEntityDORepo.save(userEntityDO53);
        UserEntityDO userEntityDO54 = new UserEntityDO(pirpi,entity19,7);
        userEntityDORepo.save(userEntityDO54);
        UserEntityDO userEntityDO55 = new UserEntityDO(pirpi,entity20,7);
        userEntityDORepo.save(userEntityDO55);




        UserDO lupoaie = new UserDO("lupoaie.robert@yahoo.ro", "Lupoaie","Robert");
        lupoaie = userRepo.save(lupoaie);
        EntityDO entity10 = new EntityDO("Movie", "Jumanji","Comedy");
        entity10 = entityRepo.save(entity10);
        EntityDO entity11 = new EntityDO("Movie", "The Post","Drama");
        entity11 = entityRepo.save(entity11);
        EntityDO entity12 = new EntityDO("Movie", "Hard Candy","Thriller");
        entity12 = entityRepo.save(entity12);
        EntityDO entity40 = new EntityDO("Book", "The Fault In Our Stars","Romance");
        entity40 = entityRepo.save(entity40);
        EntityDO entity41 = new EntityDO("Book", "Sherlock Holmes","Mystery");
        entity41 = entityRepo.save(entity41);
        EntityDO entity42 = new EntityDO("Book", "Inferno","Thriller");
        entity42 = entityRepo.save(entity42);
        EntityDO entity43 = new EntityDO("Music", "Bellyache","Pop");
        entity43 = entityRepo.save(entity43);
        EntityDO entity44 = new EntityDO("Music", "Rigolleto","Opera");
        entity44 = entityRepo.save(entity44);
        EntityDO entity45 = new EntityDO("Music", "Mask Off","Trap");
        entity45 = entityRepo.save(entity45);
        EntityDO entity46 = new EntityDO("Game", "Deus Ex","RPG");
        entity46 = entityRepo.save(entity46);
        EntityDO entity47 = new EntityDO("Game", "Counter Strike","Shooter");
        entity47 = entityRepo.save(entity47);
        EntityDO entity48 = new EntityDO("Game", "Metro 2033","Shooter");
        entity48 = entityRepo.save(entity48);
        UserEntityDO userEntityDO13 = new UserEntityDO(lupoaie,entity10,8);
        userEntityDORepo.save(userEntityDO13);
        UserEntityDO userEntityDO14 = new UserEntityDO(lupoaie,entity11,6);
        userEntityDORepo.save(userEntityDO14);
        UserEntityDO userEntityDO15 = new UserEntityDO(lupoaie,entity12,10);
        userEntityDORepo.save(userEntityDO15);
        UserEntityDO userEntityDO16 = new UserEntityDO(lupoaie,entity1,9);
        userEntityDORepo.save(userEntityDO16);
        UserEntityDO userEntityDO17 = new UserEntityDO(lupoaie,entity2,2);
        userEntityDORepo.save(userEntityDO17);

        UserEntityDO userEntityDO56 = new UserEntityDO(lupoaie,entity40,8);
        userEntityDORepo.save(userEntityDO56);
        UserEntityDO userEntityDO57 = new UserEntityDO(lupoaie,entity41,10);
        userEntityDORepo.save(userEntityDO57);
        UserEntityDO userEntityDO58 = new UserEntityDO(lupoaie,entity42,6);
        userEntityDORepo.save(userEntityDO58);
        UserEntityDO userEntityDO59 = new UserEntityDO(lupoaie,entity13,6);
        userEntityDORepo.save(userEntityDO59);
        UserEntityDO userEntityDO60 = new UserEntityDO(lupoaie,entity15,6);
        userEntityDORepo.save(userEntityDO60);

        UserEntityDO userEntityDO61 = new UserEntityDO(lupoaie,entity43,2);
        userEntityDORepo.save(userEntityDO61);
        UserEntityDO userEntityDO62 = new UserEntityDO(lupoaie,entity44,9);
        userEntityDORepo.save(userEntityDO62);
        UserEntityDO userEntityDO63 = new UserEntityDO(lupoaie,entity45,9);
        userEntityDORepo.save(userEntityDO63);
        UserEntityDO userEntityDO64 = new UserEntityDO(lupoaie,entity17,5);
        userEntityDORepo.save(userEntityDO64);
        UserEntityDO userEntityDO65 = new UserEntityDO(lupoaie,entity18,3);
        userEntityDORepo.save(userEntityDO65);

        UserEntityDO userEntityDO66 = new UserEntityDO(lupoaie,entity46,1);
        userEntityDORepo.save(userEntityDO66);
        UserEntityDO userEntityDO67 = new UserEntityDO(lupoaie,entity47,8);
        userEntityDORepo.save(userEntityDO67);
        UserEntityDO userEntityDO68 = new UserEntityDO(lupoaie,entity48,10);
        userEntityDORepo.save(userEntityDO68);
        UserEntityDO userEntityDO69 = new UserEntityDO(lupoaie,entity19,10);
        userEntityDORepo.save(userEntityDO69);
        UserEntityDO userEntityDO70 = new UserEntityDO(lupoaie,entity20,7);
        userEntityDORepo.save(userEntityDO70);

        sneaky.addUser(pirpi);
        sneaky.addUser(lupoaie);
        lupoaie.addUser(sneaky);
        pirpi.addUser(sneaky);
        cristin.addUser(sneaky);
        sneaky.addUser(cristin);
        userRepo.save(cristin);
        userRepo.save(sneaky);
        userRepo.save(pirpi);
        userRepo.save(lupoaie);
    }
}
