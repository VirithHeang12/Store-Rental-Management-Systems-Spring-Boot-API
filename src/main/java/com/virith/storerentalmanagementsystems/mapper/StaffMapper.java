package com.virith.storerentalmanagementsystems.mapper;

import com.virith.storerentalmanagementsystems.dto.StaffDTO;
import com.virith.storerentalmanagementsystems.model.Staff;

public class StaffMapper {
    public static Staff toStaff(StaffDTO staffDTO) {
        Staff staff = new Staff();
        staff.setStaffFirstName(staffDTO.getStaffFirstName());
        staff.setStaffLastName(staffDTO.getStaffLastName());
        staff.setSex(staffDTO.getSex());
        staff.setBirthDate(staffDTO.getBirthDate());
        staff.setIdentityCardNumber(staffDTO.getIdentityCardNumber());
        staff.setStaffPosition(staffDTO.getStaffPosition());
        staff.setHouseNo(staffDTO.getHouseNo());
        staff.setStreetNo(staffDTO.getStreetNo());
        staff.setSangkat(staffDTO.getSangkat());
        staff.setKhan(staffDTO.getKhan());
        staff.setProvinceOrCity(staffDTO.getProvinceOrCity());
        staff.setContactNumber(staffDTO.getContactNumber());
        staff.setPersonalNumber(staffDTO.getPersonalNumber());
        staff.setSalary(staffDTO.getSalary());
        staff.setHiredDate(staffDTO.getHiredDate());
        staff.setStoppedWork(staffDTO.getStoppedWork());

        return staff;
    }

    public static StaffDTO toStaffDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setStaffFirstName(staff.getStaffFirstName());
        staffDTO.setStaffLastName(staff.getStaffLastName());
        staffDTO.setSex(staff.getSex());
        staffDTO.setBirthDate(staff.getBirthDate());
        staffDTO.setIdentityCardNumber(staff.getIdentityCardNumber());
        staffDTO.setStaffPosition(staff.getStaffPosition());
        staffDTO.setHouseNo(staff.getHouseNo());
        staffDTO.setStreetNo(staff.getStreetNo());
        staffDTO.setSangkat(staff.getSangkat());
        staffDTO.setKhan(staff.getKhan());
        staffDTO.setProvinceOrCity(staff.getProvinceOrCity());
        staffDTO.setContactNumber(staff.getContactNumber());
        staffDTO.setPersonalNumber(staff.getPersonalNumber());
        staffDTO.setSalary(staff.getSalary());
        staffDTO.setHiredDate(staff.getHiredDate());
        staffDTO.setStoppedWork(staff.getStoppedWork());
        return staffDTO;
    }
}
