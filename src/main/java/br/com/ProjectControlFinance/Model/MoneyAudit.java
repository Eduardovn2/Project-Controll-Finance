package br.com.ProjectControlFinance.Model;

import java.util.UUID;
import java.time.OffsetDateTime;

//ID de transação, serviço utilizado, uma descrição e a data e hora realizada.
public record MoneyAudit(

    UUID transactionId,
    BankService targetService,
    String description,
    OffsetDateTime createdAt)
{

        }