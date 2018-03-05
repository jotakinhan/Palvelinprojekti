package com.jotakinhan.Palvelinprojekti.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, Long> {
	
	List<Device> findAll();

}
