package com.module.seed.controller;

import com.module.seed.mapper.DepartmentMapper;
import com.module.seed.controller.response.CommonResponse;
import com.module.seed.controller.response.ErrorCode;
import com.module.seed.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping(value = "/apis/departments",method = RequestMethod.GET)
    public ResponseEntity<?> getAllDepartment(){
        logger.info("begin getAllDepartment...");
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @RequestMapping(value = "/apis/department",method = RequestMethod.POST)
    public ResponseEntity<?> updateDepartment(@RequestParam long id,@RequestParam String name){
        logger.info("begin updateDepartment...");
        if(id < 0 ){
            return ResponseEntity.ok(new CommonResponse(ErrorCode.SYSTEM_ERROR,"参数错误,id不能为负数"));
        }
        departmentMapper.updateNameById(id, name);
        return ResponseEntity.ok(new CommonResponse(0,"success"));
    }



}
