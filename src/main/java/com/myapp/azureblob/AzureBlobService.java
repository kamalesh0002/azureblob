package com.myapp.azureblob;


import com.azure.identity.AzureCliCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobContainerItem;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class AzureBlobService {
    private final BlobServiceClient blobServiceClient;
    //ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredentialBuilder().build();

    public AzureBlobService() {
        // Initialize the BlobServiceClient with DefaultAzureCredential
        this.blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://resourceazadmin8f2e.blob.core.windows.net/")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

    public List<String> listContainers() {
        List<String> containerNames = new ArrayList<>();
        blobServiceClient.listBlobContainers().forEach(container -> containerNames.add(container.getName()));
        return containerNames;
    }

    public void createContainer(String containerName) {
        blobServiceClient.createBlobContainer(containerName);
    }
}
