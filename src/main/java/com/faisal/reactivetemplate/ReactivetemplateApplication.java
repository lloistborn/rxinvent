package com.faisal.reactivetemplate;

import com.faisal.reactivetemplate.dao.Inventory;
import com.faisal.reactivetemplate.repository.InventoryRepository;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ReactivetemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivetemplateApplication.class, args);
	}
}

@Component
class SampleDataCLR implements CommandLineRunner {

  private final InventoryRepository inventoryRepository;

  @Autowired
  SampleDataCLR(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  @Override
  public void run(String... args) {

    inventoryRepository.deleteAll()
        .subscribe(null, null, () -> {
          Stream.of("blouse", "jacket", "jeans", "sweater").forEach(type ->
              inventoryRepository
                  .save(Inventory.builder()
                      .type(type)
                      .size(new Random().nextInt(100))
                      .build())
                  .subscribe(System.out::println));
        });
  }
}