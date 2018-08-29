package com.faisal.reactivetemplate.repository;

import com.faisal.reactivetemplate.dao.Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InventoryRepository extends ReactiveMongoRepository<Inventory, String> {

}
