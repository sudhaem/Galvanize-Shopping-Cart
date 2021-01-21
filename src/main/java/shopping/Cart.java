package shopping;

import java.util.*;

public class Cart {

    private Object obj;

    Map<Item, Integer> items = new LinkedHashMap<>();

    public Map<Item, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        if(obj == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addItem(Item item) {

        if(items.containsKey(item)) {
            items.put(item,items.get(item)+1);
        }
        else {
            items.put(item,1);
        }



    }

    public int getSubTotal() {
        int sum = 0;
        for( Item item : items.keySet()) {
            sum+= item.getPrice();
        }
        return sum;
    }

    public List<String> getItemizedList() {
        List<String> itemizedList = new ArrayList<>();
        for (Item item : items.keySet()) {
            itemizedList.add("Name = " + item.getItemName() + "," + " Price = " + item.getPrice()
            + "," + " Quantity = " + items.get(item));
        }
        return itemizedList;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<String> getOnSaleItems() {
        List<String> itemizedList = new ArrayList<>();

        for (Item item : items.keySet()) {
            if (item.isSale()) {
                itemizedList.add("Name = " + item.getItemName() + "," + " Price = " + item.getPrice()
                        + "," + " Quantity = " + items.get(item));
            }
        }
        return itemizedList;

    }
}
