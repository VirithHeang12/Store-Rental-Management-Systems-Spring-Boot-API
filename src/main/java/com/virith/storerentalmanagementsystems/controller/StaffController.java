package com.virith.storerentalmanagementsystems.controller;

import com.virith.storerentalmanagementsystems.dto.StaffDTO;
import com.virith.storerentalmanagementsystems.service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/v1/staffs")
@Validated
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @PostMapping(value = "", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<String> addNewStaff(@RequestPart(value = "data") @Valid StaffDTO staffDTO, @RequestPart(value = "file") MultipartFile file) {
        staffService.addNewStaff(staffDTO, file);
        return ResponseEntity.ok("Staff added successfully");
    }

    @GetMapping(value = "{id}/photo", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getPhotoByStaffId(@PathVariable(value = "id") Integer staffID) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentDispositionFormData("attachment", "profile" + ".jpg");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(staffService.getPhoto(staffID));
    }
}
