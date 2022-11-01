package com.springboot.hello.controller;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HospitalController {

    private final HospitalDao hospitalDao;

    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @PutMapping("/hospital-add")
    public ResponseEntity<String> addHospital(Hospital hospital) {
        log.info("Hospital-add로 요청이 들어왔습니다.");
        hospitalDao.addHospital(hospital);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( "등록되었습니다.");
    }
}
