package com.virith.storerentalmanagementsystems.service.impl;

import com.virith.storerentalmanagementsystems.dto.StaffDTO;
import com.virith.storerentalmanagementsystems.exception.StaffNotFoundException;
import com.virith.storerentalmanagementsystems.mapper.StaffMapper;
import com.virith.storerentalmanagementsystems.model.Staff;
import com.virith.storerentalmanagementsystems.repository.StaffRepository;
import com.virith.storerentalmanagementsystems.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Override
    public StaffDTO addNewStaff(StaffDTO staffDTO, MultipartFile file) {
        Staff staff = StaffMapper.toStaff(staffDTO);
        try {
            staff.setPhoto(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        staffRepository.save(staff);
        return staffDTO;
    }

    @Override
    public byte[] getPhoto(Integer staffID) {
        Staff staff = staffRepository
                .findById(staffID)
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        return staff.getPhoto();
    }

    @Override
    public StaffDTO getStaffById(Integer staffID) {
        Staff staff = staffRepository.findById(staffID).orElseThrow(() -> new StaffNotFoundException("StaffID", String.valueOf(staffID)));
        return StaffMapper
                .toStaffDTO(staff);
    }
}
