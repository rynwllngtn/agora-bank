package dev.rynwllngtn.agorasystem.configurations;

import dev.rynwllngtn.agorasystem.entities.account.accounts.AccountChecking;
import dev.rynwllngtn.agorasystem.entities.account.accounts.AccountSaving;
import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.repositories.account.AccountRepository;
import dev.rynwllngtn.agorasystem.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Random;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() > 0) {
            return;
        }

        Random random = new Random();
        for (int i = 1; i <= 50; i++) {

            String cpf = String.format("%011d", random.nextInt(1000000000));
            User user = new User(cpf, "password");
            user.setName(String.format("User Number %d", i));
            user.setEmail(String.format("user%d@email.com", i));
            userRepository.save(user);

            switch (random.nextInt(4)) {
                case 1 -> {
                    AccountChecking accountChecking = new AccountChecking(user);
                    accountRepository.save(accountChecking);
                }
                case 2 -> {
                    AccountSaving accountSaving = new AccountSaving(user);
                    accountRepository.save(accountSaving);
                }
                case 3 -> {
                    AccountChecking accountChecking = new AccountChecking(user);
                    AccountSaving accountSaving = new AccountSaving(user);
                    accountRepository.saveAll(Arrays.asList(accountChecking, accountSaving));
                }
            }
        }
    }

}