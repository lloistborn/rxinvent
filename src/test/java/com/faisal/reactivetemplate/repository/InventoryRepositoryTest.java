package com.faisal.reactivetemplate.repository;

import static org.junit.Assert.*;

import com.faisal.reactivetemplate.dao.Inventory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

@DataMongoTest
@RunWith(SpringRunner.class)
public class InventoryRepositoryTest {

  @Autowired
  private InventoryRepository repo;

  @Before
  public void setUp() throws Exception {
    Hooks.onOperatorDebug();
  }

  private static final Inventory clothes = Inventory.builder()
      .id("1")
      .size(20)
      .type("Clothes")
      .build();

  private static final Inventory jeans = Inventory.builder()
      .id("2")
      .size(20)
      .type("Jeans")
      .build();

  @Test
  public void findClothesShouldReturnSuccess() throws Exception {
    org.springframework.cglib.core.KeyFactory kf;

    Publisher<Inventory> setup =
        this.repo
            .deleteAll()
            .checkpoint("saveAllInvent")
            .thenMany(this.repo.saveAll(Flux.just(clothes, jeans)));

    Publisher<Inventory> find = this.repo.findByType("Clothes");

    Publisher<Inventory> composite = Flux.from(setup).thenMany(find);

    StepVerifier.create(composite)
        .expectNextMatches(inventory -> {
          assertEquals(clothes.toString(), inventory.toString());
          return true;
        })
        .verifyComplete();
  }
}