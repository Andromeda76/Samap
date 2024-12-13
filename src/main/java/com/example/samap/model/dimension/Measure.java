package com.example.samap.model.dimension;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "ENTITY_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SYMBOL_DEPTH")
    public BigDecimal depth;

    @Column(name = "SYMBOL_HEIGHT")
    public BigDecimal height;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

}
