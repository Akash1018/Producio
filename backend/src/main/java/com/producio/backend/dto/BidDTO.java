package com.producio.backend.dto;

import lombok.Data;

@Data
public class BidDTO {
    private Long userId;
    private String itemId;
    private Long bidAmount;
}
