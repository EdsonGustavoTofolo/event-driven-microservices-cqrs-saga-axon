package io.github.edsontofolo.ProductsService.command;

import io.github.edsontofolo.ProductsService.core.events.ProductCreatedEvent;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        // Vaidate Create Product Command
        if (command.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equal than zero");
        }
        if (StringUtils.isEmpty(command.getTitle())) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.price = event.getPrice();
        this.title = event.getTitle();
        this.quantity = event.getQuantity();
    }
}
