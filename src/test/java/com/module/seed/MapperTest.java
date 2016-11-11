package com.module.seed;

import com.module.seed.mapper.DepartmentMapper;
import com.module.seed.mapper.FloorMapper;
import com.module.seed.mapper.SubcompanyMapper;
import com.module.seed.model.Department;
import com.module.seed.model.Floor;
import com.module.seed.model.Subcompany;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles("local")
public class MapperTest {


    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private SubcompanyMapper subcompanyMapper;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

    @Before
    public void before() {
        logger.debug("do some thing before test here...");
    }

    @Test
    public void testBaseCRUD() {
        // test delete
        departmentMapper.deleteById(13);
        Department department = new Department();
        department.setId(13);
        department.setName("seasunTestDepartment");
        department.setCity("珠海");
        department.setAssistantId(123);
        department.setDescription("this is 描述");
        department.setActiveFlag(true);
        department.setCreateTime(new Date());
        department.setUpdateTime(new Date());

        // test insert
        departmentMapper.insert(department);

        // test find
        Department department1 = departmentMapper.findById(13);
        logger.debug("find by id result is:{}", department1.getName());

        // test findAll
        List<Department> departmentList =departmentMapper.findAll();
        logger.debug("total size is:{}", departmentList.size());

        // test update
        departmentMapper.updateNameById(13, "新部门");
        Department department2 = departmentMapper.findByName("新部门");
        logger.debug("find by name result is:{}", department2.getName());
    }

    @Test
    public void testAutoIncreaseId() {
        floorMapper.deleteByPrimaryKey(12L);
        Floor floor = new Floor();
        floor.setName("珠海一楼");
        floor.setCity("珠海");
        floorMapper.insert(floor);
        // here, id will auto increase .
        logger.debug("new floor id is:{}",floor.getId());
    }

    @Test
    public void testXmlDymSql() {
        Subcompany subcompany = new Subcompany();
        subcompany.setId(1L);
        subcompany.setName("dym名称");
        subcompany.setCode("oo8");
        subcompanyMapper.updateByPrimaryKeySelective(subcompany);
        Subcompany subcompany1 = subcompanyMapper.selectByPrimaryKey(1L);
        logger.debug("subcompany after update :{}",subcompany1.getName());
    }

    @Test
    public void otherTests() {
        logger.debug("do some other test here...");
//        project
    }

    @After
    public void after() {
        logger.debug("do some thing after test here...");
    }

}
