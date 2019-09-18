package com.faisal.reactivetemplate.repository;

import com.faisal.reactivetemplate.dao.Inventory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface InventoryRepository extends ReactiveMongoRepository<Inventory, String> {
  Mono<Inventory> findByType(String type);
}
