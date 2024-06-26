package com.virith.storerentalmanagementsystems.service;

import com.virith.storerentalmanagementsystems.dto.StaffDTO;
import com.virith.storerentalmanagementsystems.model.Staff;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface StaffService {
    StaffDTO addNewStaff(StaffDTO staffDTO, MultipartFile image);
    byte[] getPhoto(Integer staffID);
    StaffDTO getStaffById(Integer staffID);
}
