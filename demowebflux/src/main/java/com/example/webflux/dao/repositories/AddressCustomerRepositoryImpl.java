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

     public Flux<Map<String, Object>> findWithJoin(){
         return databaseClient.execute()
             .sql("select addr.customer_id, " +
                     "cst.first_name, " +
                     "cst.last_name, " +
                     "cst.email, " +
                     "addr.street, " +
                     "addr.city, " +
                     "addr.state, " +
                     "addr.zip, " +
                     "addr.\"type\" " +
                     "from addresses addr " +
                     "join customers cst " +
                     "on cst.id = addr.customer_id " +
                     "order by addr.customer_id, addr.id")
             .fetch()
             .all();
     }

}