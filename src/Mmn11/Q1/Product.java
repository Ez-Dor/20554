package Mmn11.Q1;


public class Product {
    String _name;
    float _price,
            _amount;

/**
 * Constructor
 * @param name - product name (String)
 * @param price -  product price (int)
 * @param amount - product amount (int)
 * */
    public Product(String name, float price, float amount) {
        _name = name;
        _price = price;
        _amount = amount;
    }

    @Override
    public String toString() {
        return "[Name: " + _name + " Price: " + _price + " Amount: " + _amount + "]";
    }

    /****************************
     * Get and Set functions....
     *****************************/


    public void setName(String name) {
        _name = name;
    }

    public void setPrice(int price) {
        _price = price;
    }

    public void setAmount(int amount) {
        _amount = amount;
    }

    public float getAmount() {
        return _amount;
    }

    public String getName() {
        return _name;
    }

    public float getPrice() {
        return _price;
    }
}
