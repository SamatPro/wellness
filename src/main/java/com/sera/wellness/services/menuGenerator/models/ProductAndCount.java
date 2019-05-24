package com.sera.wellness.services.menuGenerator.models;

import com.sera.wellness.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductAndCount {
    private Product product;
    private Short count;
}
