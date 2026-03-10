package dev.rynwllngtn.enums.account;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum AccountType implements Serializable {

    NONE(0, null),
    CHECKING(1, "Corrente"),
    SAVING(2, "Poupança");

    private final int id;
    private final String label;

}