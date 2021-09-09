package com.codegym.product_management.Dto;
import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> cartMap = new HashMap <>();
    public CartDto(){
    }

    public Map < ProductDto, Integer > getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map < ProductDto, Integer > cartMap) {
        this.cartMap = cartMap;
    }

    public void addProductToCart (ProductDto productDto){
        if (cartMap.containsKey(productDto)){
            Integer currentValue = cartMap.get(productDto);
            cartMap.put(productDto,currentValue+1);
        }else {
            cartMap.put(productDto,1);
        }
    }



}
