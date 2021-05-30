package com.project.blockfish.domainmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KlayDto {
    String userId;
    String hash;
    String contractAddress;

    public String getContractAddress() {
        return contractAddress;
    }
}
