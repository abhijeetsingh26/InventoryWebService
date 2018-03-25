package com.inventorywebservice.inventorymanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventorywebservice.inventorymanager.model.PurchaseModel;

public interface PurchaseRepository  extends CrudRepository<PurchaseModel, Long>  {

}
