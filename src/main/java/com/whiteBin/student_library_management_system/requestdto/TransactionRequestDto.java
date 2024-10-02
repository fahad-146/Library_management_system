package com.whiteBin.student_library_management_system.requestdto;

import com.whiteBin.student_library_management_system.enums.TransactionName;
import com.whiteBin.student_library_management_system.enums.TransactionStatus;
import com.whiteBin.student_library_management_system.model.Book;
import com.whiteBin.student_library_management_system.model.Card;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class TransactionRequestDto {

    private TransactionName transactionName; //purchase or return
    private TransactionStatus transactionStatus; //success or failed or pending
    private int bookId;
    private int cardId;

}
