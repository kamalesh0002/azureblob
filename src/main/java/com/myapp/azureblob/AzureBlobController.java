package com.myapp.azureblob;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// @RequestMapping("/api/containers")
@RestController
public class AzureBlobController {

    private final AzureBlobService blobStorageService;
    
    // @Value("${container.name:default}")
    // private String containerName;

    @GetMapping("/welcome")
    public String Welcome(){
        return "hello World";
    }

    
    public AzureBlobController(AzureBlobService blobStorageService) {
        this.blobStorageService = blobStorageService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listContainers() {
        return ResponseEntity.ok(blobStorageService.listContainers());
    }

    @PostMapping
    public ResponseEntity<Void> createContainer(@RequestParam String containerName) {
        blobStorageService.createContainer(containerName);
        return ResponseEntity.ok().build();
    }
    
}
