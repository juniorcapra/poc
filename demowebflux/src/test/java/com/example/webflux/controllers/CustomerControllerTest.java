package com.example.webflux.controllers;



import com.example.webflux.dao.models.Customer;
import com.example.webflux.dao.services.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Iterator;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
    public CustomerControllerTest() {
    }

//    @Autowired
//    public WebApplicationContext context;


    @Autowired
    private CustomerServiceImpl customerService;


//    private MockMvc mvc;
//
//
//    @Before
//    public void setup(){
//        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//    }

//    @Test
//   public void testaRequisicaoIdSucesso() throws Exception {
//
//        String url = "/customer/all";
//       this.mvc.perform(get(url))
//               .andExpect(status().isOk())
//               .andExpect(jsonPath("first_name", equalTo("Junior")));
//   }



    @Before


    @Test
    public void testSaveCustomer() {

        Customer customer = new Customer();
        customer.setEmail("lucas@dextra-sw.com");
        customer.setFirstName("Lucas");
        customer.setLastName("Capra");
        customer.setAddress(null);

        StepVerifier.create(customerService.buscarTodos())
            .expectNextMatches(customer1 -> customer1.getFirstName().equals("Junior"))
            .verifyComplete();









    }




}
