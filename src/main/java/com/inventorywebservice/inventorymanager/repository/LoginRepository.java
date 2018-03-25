package  com.inventorywebservice.inventorymanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inventorywebservice.inventorymanager.model.EnduserModel;

public interface LoginRepository  extends CrudRepository<EnduserModel, Long>  {
	
	List<EnduserModel> findByuserEmail(String userEmail);
	
	List<EnduserModel> findByuserUUID(String userUUID);
}
