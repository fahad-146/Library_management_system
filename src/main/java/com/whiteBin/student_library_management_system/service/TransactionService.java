package com.whiteBin.student_library_management_system.service;

import com.whiteBin.student_library_management_system.converter.TransactionConverter;
import com.whiteBin.student_library_management_system.enums.TransactionName;
import com.whiteBin.student_library_management_system.model.Book;
import com.whiteBin.student_library_management_system.model.Card;
import com.whiteBin.student_library_management_system.model.Transaction;
import com.whiteBin.student_library_management_system.repository.BookRepository;
import com.whiteBin.student_library_management_system.repository.CardRepository;
import com.whiteBin.student_library_management_system.repository.TransactionRepository;
import com.whiteBin.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    public String createTransaction(TransactionRequestDto transactionRequestDto) throws ParseException {
        Transaction transaction= TransactionConverter.convertTransactionRequestDtoIntoTransactionModel(transactionRequestDto);
        Card card= cardRepository.findById(transactionRequestDto.getCardId()).get();
        Book book= bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setCard(card);
        transaction.setBook(book);

        // add the due date to transaction
        if(transactionRequestDto.getTransactionName().equals(TransactionName.PURCHASE)) {
            Date dueDate = new SimpleDateFormat("dd-MM-yyyy").parse(LocalDate.now().plusDays(7).toString());
            transaction.setDueDate(dueDate);
            transaction.setFine(0.00);
        }
//        else {
//            // if transaction name is return due date will already be there
//            // calculate the fine
//            double fineAmount = 0.00;
//            Date currentDate = new Date();
//            if(dueDate.before(currentDate)){
//                // calculate fine
//                long differenceInDays =  TimeUnit.MILLISECONDS.toDays( currentDate.getTime()-dueDate.getTime());
//                fineAmount = differenceInDays * 3;
//                transaction.setFine(fineAmount);
//            }else{
//                // no fine
//                transaction.setFine(fineAmount);
//            }
//        }


        transactionRepository.save(transaction);
        return "Transaction saved";
    }
}
