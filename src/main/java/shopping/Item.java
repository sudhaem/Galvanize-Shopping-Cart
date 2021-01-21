package shopping;

public class Item {

    private int price;
    private String itemName;

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    private boolean sale;

    public Item (int price, String itemName, boolean sale) {
        this.price = price;
        this.itemName = itemName;
        this.sale = sale;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
