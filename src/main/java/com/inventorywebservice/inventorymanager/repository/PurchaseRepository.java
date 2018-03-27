package com.inventorywebservice.inventorymanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inventorywebservice.inventorymanager.model.PurchaseModel;

public interface PurchaseRepository  extends CrudRepository<PurchaseModel, Long>  {
	
	List<PurchaseModel> findByuserUuid(String userUuid);
	
}
