package com.faisal.reactivetemplate.rest;

import com.faisal.reactivetemplate.dao.Inventory;
import com.faisal.reactivetemplate.dao.InventoryEvent;
import com.faisal.reactivetemplate.repository.InventoryRepository;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/inventories")
public class InventoryHandler {

  private final InventoryRepository inventoryRepository;

  @Autowired
  public InventoryHandler(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  @GetMapping("/all")
  public Flux<Inventory> getAllInventory() {
    return this.inventoryRepository.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Inventory> getInventoryById(@PathVariable("id") final String empId) {
    return this.inventoryRepository.findById(empId);
  }

  @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<InventoryEvent> getInventoryEvents(@PathVariable("id") final String empId ) {
    return this.inventoryRepository
        .findById(empId)
        .flatMapMany(inventory -> {
          Flux<Long> interval  = Flux.interval(Duration.ofSeconds(2));

          Flux<InventoryEvent> inventoryEventFlux = Flux.fromStream(Stream.generate(() ->
              InventoryEvent.builder()
                  .inventory(inventory)
                  .date(new Date())
                  .build()));

          return Flux.zip(interval, inventoryEventFlux)
              .map(objects -> objects.getT2());
        });
  }
}
