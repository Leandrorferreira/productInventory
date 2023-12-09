package com.inventory.productInventory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDto {
    @JsonProperty(value = "name", required = true)
    private String name;
    @JsonProperty(value = "type", required = true)
    private Integer type;
}
