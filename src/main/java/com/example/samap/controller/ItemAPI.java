package com.example.samap.controller;


import java.math.BigDecimal;
import com.example.samap.model.dimension.Dimension;
import com.example.samap.model.dimension.ItemOffset;
import com.example.samap.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemAPI {


    private final ItemService itemService;

    public ItemAPI(ItemService itemService) {
        this.itemService = itemService;
    }

    @Bean
    public ItemOffset saveItem() {
        ItemOffset itemOffset = new ItemOffset();
        Dimension dimension = new Dimension();

        dimension.setDimensionsName("dimension");
        dimension.setSymbolName("symbol");
        itemOffset.setDimension(dimension);

        itemOffset.setDepth(BigDecimal.valueOf(10));
        itemOffset.setHeight(BigDecimal.valueOf(10));

        return itemService.insertItem(itemOffset);
    }
}
