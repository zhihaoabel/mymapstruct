package com.abel.mapstruct.mapper;

import com.abel.mapstruct.dto.CarDTO;
import com.abel.mapstruct.dto.DivisionDTO;
import com.abel.mapstruct.dto.EmployeeDTO;
import com.abel.mapstruct.dto.PersonDTO;
import com.abel.mapstruct.enums.ExternalOrderType;
import com.abel.mapstruct.enums.OrderType;
import com.abel.mapstruct.model.Car;
import com.abel.mapstruct.model.Employee;
import com.abel.mapstruct.model.Person;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class MapstructApplicationTests {
    private final Logger log = LoggerFactory.getLogger(MapstructApplicationTests.class);

    @Autowired
    CarMapper carMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    OrderMapper orderMapper;

    PersonMapper personMapper;

    private Car car;

    private Person person;

    /**
     * 组装car 和 person
     */
    @PostConstruct
    public void init() {
        // 获取personMapper
        personMapper = Mappers.getMapper(PersonMapper.class);

        // 组装car
        ArrayList<String> features = new ArrayList<>();
        features.add("GPS");
        car = new Car("Ford", 5, features, 10000.0, new Date());

        // 组装person
        person = new Person(1D, "张三");
    }

    /**
     * 默认componentModel
     */
    @Test
    void test1() {
        PersonDTO personDTO = personMapper.personToPersonDTO(person);
        log.info("personDTO: {}", personDTO);
    }

    /**
     * spring管理的componentModel
     */
    @Test
    void test2() {
        CarDTO carDTO = carMapper.carToCarDto(car);
        log.info("carDTO: {}", carDTO);
    }

    /**
     * 各种类型映射
     */
    @Test
    void test3() {
        CarDTO carDTO = carMapper.carToCarDto(car);
        log.info("carDTO: {}", carDTO);
    }

    /**
     * 映射反转
     */
    @Test
    void test4() {
        CarDTO carDTO = carMapper.carToCarDto(car);
        log.info("carDTO: {}", carDTO);

        Car inverse = carMapper.toCar(carDTO);
        log.info("inverse: {}", inverse);
    }

    /**
     * 默认忽略属性，手动映射
     */
    @Test
    void test5() {
        CarDTO ignored = carMapper.ignoreProps(car);
        log.info("ignored: {}", ignored);
    }

    /**
     * 自定义映射
     */
    @Test
    void test6() {
        CarDTO custom = carMapper.custom(car);
        log.info("custom: {}", custom);
    }

    /**
     * Spring BeanUtils
     * 1. 大量反射，效率低
     * 2. 不够灵活
     */
    @Test
    void test7() {
        CarDTO carDTO = new CarDTO();
        BeanUtils.copyProperties(car, carDTO);
        log.info("carDTO: {}", carDTO);
    }

    /**
     * Apache BeanUtils
     * 1. 反射，日志打印等等，效率低
     */
    @SneakyThrows
    @Test
    void test8() {
        CarDTO carDTO = new CarDTO();
        org.apache.commons.beanutils.BeanUtils.copyProperties(carDTO, car);
        log.info("carDTO: {}", carDTO);
    }

    /**
     * 复杂映射 - 嵌套映射
     */
    @Test
    void test9() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDivision(new DivisionDTO(1, "Division1"));
        Employee entity = employeeMapper.employeeDTOtoEmployee(dto);
        log.info("entity: {}", entity);
    }

    /**
     * expression
     */
    @Test
    void test10() {
        PersonDTO personDTO = personMapper.personWIthRandomId(person);
        log.info("personDTO: {}", personDTO);
    }

    /**
     * 枚举互转
     */
    @Test
    void test11() {
        log.info("OrderType.NORMAL.name(): {}", OrderType.NORMAL.name());
        ExternalOrderType externalOrderType = orderMapper.orderTypeToExternalOrderType(OrderType.NORMAL);
        log.info("externalOrderType: {}", externalOrderType);
    }
}
