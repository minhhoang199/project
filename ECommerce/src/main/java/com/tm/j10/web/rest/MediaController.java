package com.tm.j10.web.rest;

import com.tm.j10.service.MediaService;
import com.tm.j10.web.rest.vm.MediaVM;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/medias")
@RestController
public class MediaController {
    private MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping(value = "",
        consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> addNewMedia(MediaVM mediaVM){
        this.mediaService.addMedia(mediaVM);
        return ResponseEntity.ok("Upload succeed");
    }
}
