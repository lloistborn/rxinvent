package com.faisal.reactivetemplate.dao;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InventoryEvent {
  private Inventory inventory;
  private Date date;
}
