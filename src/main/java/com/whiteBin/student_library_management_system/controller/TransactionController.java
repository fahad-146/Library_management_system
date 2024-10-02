package com.whiteBin.student_library_management_system.controller;


import com.whiteBin.student_library_management_system.requestdto.TransactionRequestDto;
import com.whiteBin.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto) throws ParseException {
        String response = transactionService.createTransaction(transactionRequestDto);
        return  response;
    }
}
