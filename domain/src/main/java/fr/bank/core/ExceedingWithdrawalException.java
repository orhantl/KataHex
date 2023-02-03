package fr.bank.core;

public class ExceedingWithdrawalException extends RuntimeException {
    public ExceedingWithdrawalException(String s) {
        super(String.format("Amount : %s, is superior to available balance", s));
    }
}
