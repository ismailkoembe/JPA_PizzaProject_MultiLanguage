/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pizza.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author schulung
 */
@Converter
public class LocalDateConverter implements AttributeConverter<java.time.LocalDate, java.sql.Date> {

  @Override
  public java.sql.Date convertToDatabaseColumn(java.time.LocalDate entityValue) {
    return entityValue == null ? null : java.sql.Date.valueOf(entityValue);
  }

  @Override
  public java.time.LocalDate convertToEntityAttribute(java.sql.Date dbValue) {
    return dbValue == null ? null : dbValue.toLocalDate(); 
  }
}
