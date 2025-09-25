package com.producio.backend.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

import com.producio.backend.model.Item;

public interface ItemRepository extends JpaAttributeConverter<Item, Long> {
    
}
