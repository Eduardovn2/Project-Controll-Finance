package br.com.ProjectControlFinance.Model;

import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ToString
public abstract class Wallet{

    @Getter
    private final BankService service;

    //Representa cada um centavo na nossa conta.
    protected final List<Money> money;

    //Metodo construtor, gerando array list de money.
    public Wallet(BankService serviceType) {
        this.service = serviceType;
        this.money = new ArrayList<>();
    }

    //Metodo utilitario da classe.
    protected List<Money> generatedMoney(final long amount, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), service, description, OffsetDateTime.now());
        return Stream.generate(() -> new Money(history)).limit(amount).toList();
    }

    //Define quanto de dinheiro tem na conta.
    public long getFounds(){
        return money.size();
    }

    //Adiciona dinheiro na conta, porem precisa ter um deposito inicial que nao estanciado nesse metodo.
    public void addMoney(final List<Money> money, final BankService service, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), service, description, OffsetDateTime.now());
        money.forEach(m -> m.addHistory(history));
        this.money.addAll(money);
    }

    //Reduz os centavos de Money.
    public List<Money> reduceMoney(final long amount){
        List<Money> toRemove = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            //Remove a primeira instancia de money.
            toRemove.add(this.money.removeFirst());
        }
        return toRemove;
    }

    public List<MoneyAudit> getFinancialTransactions(){
        return money.stream().flatMap(m -> m.getHistory().stream()).toList();
    }


}
