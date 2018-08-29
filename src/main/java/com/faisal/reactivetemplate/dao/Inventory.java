package com.faisal.reactivetemplate.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@ToString
@Getter
public class Inventory {

  @Id
  private String id;
  private String type;
  private int size;
}