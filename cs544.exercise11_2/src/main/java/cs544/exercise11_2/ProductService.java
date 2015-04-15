package cs544.exercise11_2;

import java.util.*;

public class ProductService implements IProductService {

    public ProductService() {
    }

    private IInventoryService inventoryService;
    private Collection<Product> productList = new ArrayList<Product>();

    public IInventoryService getInventoryService() {
        return inventoryService;
    }

    public void setInventoryService(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public ProductService(IInventoryService inventoryService) {
        productList.add(new Product(234, "LCD TV", 895.50));
        productList.add(new Product(239, "DVD player", 315.00));
        productList.add(new Product(423, "Plasma TV", 992.55));
        this.inventoryService = inventoryService;
    }

    public Product getProduct(int productNumber) {
        for (Product product : productList) {
            if (product.getProductNumber() == productNumber) {
                return product;
            }
        }
        return null;
    }

    public int getNumberInStock(int productnr) {
        return inventoryService.getNumberInStock(productnr);
    }

}
