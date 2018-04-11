package com.tam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tam.model.Device;

@Repository
public interface DeviceRepository extends MongoRepository < Device, String > {
    
//   @Query("{ 'macAddress' : ?0 }") 
   Device findByMacAddress(String macAddress);
}