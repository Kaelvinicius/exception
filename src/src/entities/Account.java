package entities;

import entities.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public void withDraw(Double amount) throws DomainException {
        if (amount > this.withDrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        if (this.balance == 0){
            throw new DomainException("There´s no value to take out");
        }
        if(this.balance < amount ){
            throw new DomainException("Not enough balance");
        }

        this.balance -= amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    @Override
    public String toString() {
        return "New balance: $" + this.balance;
    }
}
