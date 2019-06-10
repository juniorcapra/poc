package com.example.webflux.dao.repositories;


import com.example.webflux.dao.models.Address;
import com.example.webflux.dao.models.Customer;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class AddressCustomerRepositoryImpl {


    ConnectionFactory connectionFactory;
    DatabaseClient databaseClient;

    public AddressCustomerRepositoryImpl(ConnectionFactory connectionFactory) {


        this.connectionFactory = connectionFactory;
        this.databaseClient = DatabaseClient.create(connectionFactory);

    }



 public Flux<Address> buscarAdd(){
     return databaseClient.execute().sql("select * from addresses addr\n" +
             "join customers cst \n" +
             "on cst.id = addr.customer_id").as(Address.class).fetch().all();


//     Flux<Map<String, Object>> rows = databaseClient.execute()
//             .sql("SELECT id, name, manual FROM legoset")
//             .fetch()
//             .all();
 }

}
