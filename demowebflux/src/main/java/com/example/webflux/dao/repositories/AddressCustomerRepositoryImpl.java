package com.example.webflux.dao.repositories;


import io.r2dbc.spi.ConnectionFactory;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Map;

@Repository
public class AddressCustomerRepositoryImpl {


    ConnectionFactory connectionFactory;
    DatabaseClient databaseClient;

    public AddressCustomerRepositoryImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        this.databaseClient = DatabaseClient.create(connectionFactory);

    }



 public Flux<Map<String, Object>> buscarAdd(){
     return databaseClient.execute()
             .sql("select * from addresses addr\n" +
                     "join customers cst \n" +
                     "on cst.id = addr.customer_id")
             .fetch()
             .all();

 }

}
