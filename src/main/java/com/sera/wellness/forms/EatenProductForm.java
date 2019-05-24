package com.sera.wellness.forms;

import com.sera.wellness.models.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class EatenProductForm {
    private Long productId;
    private Short count;
}
