package org.AdventurerInventory;

import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryManagement {

    private final Map<String, Integer> inventory = new LinkedHashMap<>();

    public String getAllItems() {
        if(inventory.isEmpty()){
            return "Инвентарь пуст";
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer>entry: inventory.entrySet()){
            sb.append("\n").append(entry.getKey()).append(" - ").append(entry.getValue());
        }
        return sb.toString();
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public boolean addItem (String name, Integer quantity){
        if (quantity <= 0){
            return false;
        }else {
            inventory.put(name, quantity);
            return true;
        }
    }

    public boolean increaseQuantity (String name, Integer quantity){
        if (quantity <= 0){
            return false;
        }else {
            inventory.put(name, inventory.get(name) + quantity);
            return true;
        }
    }

    public boolean decreaseQuantity (String name, Integer quantity){
        if (quantity <= 0){
            return false;
        } else {
            if((inventory.get(name) - quantity) <= 0){
                inventory.remove(name);
                return true;
            } else{
                inventory.put(name, inventory.get(name) - quantity);
                return true;
            }

        }
    }

    public boolean removeItem(String name){
        if(!inventory.containsKey(name)){
            return false;
        } else{
            inventory.remove(name);
            return  true;
        }
    }

    public boolean containsItem(String name){
        if(!inventory.containsKey(name)){
            return false;
        } else{
            return true;
        }
    }


    public boolean changeQuantity(String name, Integer quantity){
        if (quantity < 0) {
            return false;
        } else if (quantity == 0) {
            inventory.remove(name);
            return true;
        } else {
            inventory.replace(name, quantity);
            return true;

        }
    }



    public Integer searchForItem(String name){
        return inventory.get(name);
    }






}
