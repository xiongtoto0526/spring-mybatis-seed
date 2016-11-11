package com.module.seed.service.impl;

import com.module.seed.mapper.DepartmentMapper;
import com.module.seed.model.Department;
import com.module.seed.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.findAll();
    }
}
