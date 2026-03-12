package dev.rynwllngtn;

import dev.rynwllngtn.entities.account.Account;
import dev.rynwllngtn.entities.account.accounts.AccountChecking;
import dev.rynwllngtn.entities.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    static void main() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("agorasystemdb");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        User user = new User("11111111111","12345678");
        manager.persist(user);

        Account accountChecking = new AccountChecking(user);
        manager.persist(accountChecking);

        Account fromDbAccount = manager.find(Account.class, accountChecking.getId());
        IO.println(fromDbAccount + "\n\n");
        manager.remove(fromDbAccount);

        User fromDbUser = manager.find(User.class, user.getId());
        IO.println(user);
        manager.remove(fromDbUser);

        manager.getTransaction().commit();
    }

}