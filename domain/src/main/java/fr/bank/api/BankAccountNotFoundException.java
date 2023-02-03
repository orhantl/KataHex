package fr.bank.api;

public class BankAccountNotFoundException extends RuntimeException {
    public BankAccountNotFoundException(String s) {
        super(String.format("bank account id does not exist : %s", s));
    }
}
