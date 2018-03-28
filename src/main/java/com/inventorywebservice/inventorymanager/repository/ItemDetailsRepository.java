package com.inventorywebservice.inventorymanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inventorywebservice.inventorymanager.model.ItemDetailsModel;


public interface ItemDetailsRepository extends CrudRepository<ItemDetailsModel, Long>  {
	
	List<ItemDetailsModel> findAll();
	
}
