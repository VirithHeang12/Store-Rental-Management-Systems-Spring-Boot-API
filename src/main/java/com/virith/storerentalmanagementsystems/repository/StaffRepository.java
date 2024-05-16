package com.virith.storerentalmanagementsystems.repository;

import com.virith.storerentalmanagementsystems.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
