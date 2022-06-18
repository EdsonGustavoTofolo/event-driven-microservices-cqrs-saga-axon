package io.github.edsontofolo.ProductsService.command.rest;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateProductRestModel {
    @NotBlank(message = "Product title is a required field")
    private String title;
    @Min(value = 1, message = "Price cannot be lower than {value}")
    private BigDecimal price;
    @Min(value = 1, message = "Quantity cannot be lower than {value}")
    @Max(value = 5, message = "Quantity cannot be larger than {value}")
    private Integer quantity;
}
