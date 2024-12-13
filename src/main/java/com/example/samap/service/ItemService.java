package com.example.samap.service;

import com.example.samap.model.dimension.ItemOffset;
import com.example.samap.facade.ItemOffsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    private final ItemOffsetRepository itemOffsetRepository;

    public ItemService(ItemOffsetRepository itemOffsetRepository) {
        this.itemOffsetRepository = itemOffsetRepository;
    }


    public ItemOffset insertItem(ItemOffset itemOffset) {
        throw new RuntimeException("Hello_World");
//        return itemOffsetRepository.save(itemOffset);
    }

}
