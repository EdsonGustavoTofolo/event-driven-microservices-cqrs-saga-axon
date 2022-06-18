package io.github.edsontofolo.ProductsService.query;

import io.github.edsontofolo.ProductsService.core.data.ProductRepository;
import io.github.edsontofolo.ProductsService.query.rest.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductsQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery query) {
        return this.productRepository.findAll().stream().map(productEntity -> ProductRestModel.builder()
                .productId(productEntity.getProductId())
                .title(productEntity.getTitle())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .build()).toList();
    }
}
