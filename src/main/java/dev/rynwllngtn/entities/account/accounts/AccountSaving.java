package dev.rynwllngtn.entities.account.accounts;

import dev.rynwllngtn.entities.account.Account;
import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.enums.account.AccountType;

import java.io.Serial;

public class AccountSaving extends Account {

    @Serial
    private static final long serialVersionUID = -5175368657497471716L;

    public AccountSaving(User holder) {
        super(holder);
        this.accountType = AccountType.SAVING;
    }

}