package br.com.ProjectControlFinance.Model;

public record Investment (
            long id,
            long tax,
            long initialFunds
    ){


    public Investment(BankService bankService) {
    }
}


