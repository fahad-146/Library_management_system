package com.whiteBin.student_library_management_system.converter;

import com.whiteBin.student_library_management_system.model.Transaction;
import com.whiteBin.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoIntoTransactionModel(TransactionRequestDto transactionRequestDto){
        Transaction transaction= Transaction.builder().transactionName(transactionRequestDto.getTransactionName()).transactionStatus(transactionRequestDto.getTransactionStatus()).build();
        return transaction;
    }
}
