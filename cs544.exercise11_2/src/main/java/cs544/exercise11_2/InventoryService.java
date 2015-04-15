/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise11_2;

 
public class InventoryService implements IInventoryService {

    public InventoryService() {
    }
 
     

    public int getNumberInStock(int productnumber) {
        return productnumber - 200;
    }

    

}
