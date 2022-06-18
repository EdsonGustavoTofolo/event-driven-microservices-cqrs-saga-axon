package io.github.edsontofolo.ProductsService.command.rest;

import io.github.edsontofolo.ProductsService.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsCommandController {

//    private final Environment environment;
    private final CommandGateway commandGateway;

    @PostMapping
    public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(createProductRestModel.getPrice())
                .quantity(createProductRestModel.getQuantity())
                .title(createProductRestModel.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String returnValue;
        try {
            returnValue = this.commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            returnValue = e.getLocalizedMessage();
        }

        return returnValue;
    }

//    @GetMapping
//    public String getProduct() {
//        return "HTTP Get Handled - Port: " + this.environment.getProperty("local.server.port");
//    }
//
//    @PutMapping
//    public String updateProduct() {
//        return "HTTP Put Handled";
//    }
//
//    @DeleteMapping
//    public String deleteProduct() {
//        return "HTTP Delete Handled";
//    }
}
