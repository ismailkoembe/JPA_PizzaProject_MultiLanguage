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
public class LocalDateTimeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

  @Override
  public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime entityValue) {
    return entityValue == null ? null : java.sql.Timestamp.valueOf(entityValue);
  }

  @Override
  public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbValue) {
    return dbValue == null ? null : dbValue.toLocalDateTime(); 
  }
}
