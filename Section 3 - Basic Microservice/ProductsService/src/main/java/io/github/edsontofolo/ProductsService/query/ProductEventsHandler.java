package io.github.edsontofolo.ProductsService.query;

import io.github.edsontofolo.ProductsService.core.data.ProductEntity;
import io.github.edsontofolo.ProductsService.core.data.ProductRepository;
import io.github.edsontofolo.ProductsService.core.events.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        this.productRepository.save(productEntity);
    }
}
