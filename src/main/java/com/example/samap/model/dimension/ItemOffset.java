package com.example.samap.model.dimension;


import jakarta.persistence.*;


@Entity
@Table(name = "ItemOffset")
public class ItemOffset extends Measure{
    @Embedded
    @AttributeOverrides(
            value = {
                    @AttributeOverride(name = "dimensionsName",
                        column = @Column(name = "METER_DIMENSION")
                    ),
                    @AttributeOverride(name = "symbolName",
                        column = @Column(name = "SYMBOL_PARAMETER"))
            }
    )
    private Dimension dimension;


    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

}