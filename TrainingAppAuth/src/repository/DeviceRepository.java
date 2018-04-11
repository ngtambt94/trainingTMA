package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import model.Device;

@Repository
public interface DeviceRepository extends MongoRepository< Device, String > {
    
    Device findByMacAddress(String macAddress);
    
    List<Device> findAll();
    
    Optional<Device> findById(String id);

    void deleteById(String id);
}
