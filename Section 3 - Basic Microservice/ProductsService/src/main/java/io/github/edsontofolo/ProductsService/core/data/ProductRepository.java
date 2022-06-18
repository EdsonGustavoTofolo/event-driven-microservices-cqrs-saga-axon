package io.github.edsontofolo.ProductsService.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
