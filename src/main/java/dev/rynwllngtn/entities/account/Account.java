package dev.rynwllngtn.entities.account;

import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.enums.account.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "AccountType", discriminatorType = DiscriminatorType.STRING)
public abstract class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = -5407895841045304833L;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "Id")
    protected UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "holder")
    protected User holder;
    protected BigDecimal balance;
    protected BigDecimal transferLimit;
    protected BigDecimal transferLimitCap;

    @Enumerated(EnumType.STRING)
    @Column(insertable=false, updatable=false)
    protected AccountType accountType;

    public Account(User holder) {
        this.holder = holder;
        balance = BigDecimal.ZERO;
        transferLimit = balance;
        transferLimitCap = transferLimit;
    }

    @Override
    public String toString() {
        return ("Account ID: " + id + "\n" +
                "Holder:\n\n" + holder + "\n\n" +
                "Transaction Limit: " + transferLimit +  " | " + transferLimitCap + "\n" +
                "Balance: " + balance);
    }

}