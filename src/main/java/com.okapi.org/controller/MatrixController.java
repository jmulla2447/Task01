package com.okapi.org.controller;

import com.okapi.org.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixController {

    @Autowired
    MatrixService matrixService;


}
