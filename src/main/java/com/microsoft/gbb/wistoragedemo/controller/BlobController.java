package com.microsoft.gbb.wistoragedemo.controller;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlobController {
    @Autowired
    private BlobContainerClient containerClient;

    @GetMapping("/bloblist")
    public String readBlobFile() {
        StringBuilder blobList = new StringBuilder();

        for (BlobItem blobItem : containerClient.listBlobs()) {
            blobList.append(blobItem.getName() + " ");
        }

        return blobList.toString();
    }

}
