package br.com.ProjectControlFinance.Model;

import java.util.List;

import static br.com.ProjectControlFinance.Model.BankService.ACCOUNT;

public class AccountWallet extends Wallet{

    private final List<String> pix;

    public AccountWallet(final List<String> pix){
        super(ACCOUNT);
        this.pix = pix;
    }

    public AccountWallet(final long amount, final List<String> pix) {
        super(ACCOUNT);
        this.pix = pix;
        addMoney(amount, "Valor de criação da conta.");
    }

    //Sobrecarga de metodos para gerar o primeiro deposito na conta.
    public void addMoney(final long amount, final String description){
        var money = generatedMoney(amount, description);
        this.money.addAll(money);
    }
}
