package br.com.ProjectControlFinance.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
public class Money {

    //Historico de transação
    private List<MoneyAudit> history = new ArrayList<>();


    public Money(final MoneyAudit history) {
        this.history.add(history);
    }

    public void addHistory(final MoneyAudit history){
        this.history.add(history);
    }
}
