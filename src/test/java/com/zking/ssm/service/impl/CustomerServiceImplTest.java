package com.zking.ssm.service.impl;

import com.zking.ssm.model.Customer;
import com.zking.ssm.model.Order;
import com.zking.ssm.service.ICustomerService;
import com.zking.ssm.service.IOrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;
public class CustomerServiceImplTest extends BaseTest{

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IOrderService orderService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void queryCustomerOneToMany() {
        /*Order order =
                orderService.querySingleOrderByManyToOne(1);
        System.out.println(order);*/
//        List<Customer> customers = customerService.queryCustomerOneToMany();
//        for (Customer customer : customers) {
//            System.out.println(customer);
//        }
        Locale china=Locale.CHINA;
//        System.out.println(china.getDisplayLanguage());
        System.out.println(china.getLanguage());
    }
}