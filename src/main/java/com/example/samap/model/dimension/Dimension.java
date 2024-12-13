package com.example.samap.model.dimension;


import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Embeddable
public class Dimension {

    @Basic(optional = false)
    public String dimensionsName;

    @Basic(optional = false)
    public String symbolName;


    public String getDimensionsName() {
        return dimensionsName;
    }

    public void setDimensionsName(String dimensionsName) {
        this.dimensionsName = dimensionsName;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

}
