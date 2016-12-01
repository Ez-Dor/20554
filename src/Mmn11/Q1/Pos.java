package Mmn11.Q1;

import java.util.ArrayList;


public class Pos {
    /*
    * _currentPosAccount - should contain the current cash in the POS
    * __accumulateClientShops - should contain the sum of all the shops that happend in the correct POS
    * */
    private float _currentPosAccount,
            __accumulateClientShops;
    private ArrayList _shoppingCart;

    /**
     * Default contractor
     */
    public Pos() {
        _currentPosAccount = 0;
        __accumulateClientShops = 0;
        _shoppingCart = new ArrayList();
    }

    /**
     * Constructor that get a initial cash to the POS
     */
    public Pos(float currentAccount) {
        _currentPosAccount = currentAccount;
        __accumulateClientShops = 0;
        _shoppingCart = new ArrayList();
    }


    /**
     * Add product to the list
     *
     * @param productToAdd:Product
     */
    public void addProductToCart(Product productToAdd) {
        _shoppingCart.add(productToAdd);
    }

    /**
     * Returns product array that each element is a Product object
     */
    public Product[] getProductArray() {
        Product p[] = new Product[_shoppingCart.size()];
        _shoppingCart.toArray(p);
        return p;

    }

    /**
     * Returns a float with the tutal cash to pay
     */
    public float getTotalToPay() {
        float total = 0;
        int shoppingCartLength = _shoppingCart.size();

        for (int i = 0; i < shoppingCartLength; i++) {
            Product p = (Product) _shoppingCart.get(i);
            total += p.getPrice() * p.getAmount();
        }

        return total;
    }

    /**
     * The function get a  float cash and return the change after init to the shopping cart
     */
    public float payment(float cash) {
        float total = getTotalToPay(),
                change = cash - total;
        if (change < 0) {
            throw new Error("Give me my money mada fu***!!!");
        }
        _currentPosAccount += total;
        __accumulateClientShops += total;
        _shoppingCart = new ArrayList();

        return change;
    }

    public float getCurrentPosAccount() {
        return _currentPosAccount;
    }

    public float getAccumulateClientShops() {
        return __accumulateClientShops;
    }
}
