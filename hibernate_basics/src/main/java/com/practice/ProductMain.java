package com.practice;



public class ProductMain {
    public static void main(String[] args) {

        ProductDetails pd = new ProductDetails();

        // INSERT
//        Product p = new Product();
//        p.setId(2);
//        p.setName("phone");
//        p.setQuantity(2);
//        p.setPrice(51000);
//
//        pd.insertProduct(p);

        // FIND
//        Product found = pd.findProduct(1);
//        if (found != null) {
//            System.out.println(
//                found.getId() + " " +
//                found.getName() + " " +
//                found.getQuantity() + " " +
//                found.getPrice()
//            );
//        }
//
//        // UPDATE
 //       pd.updateProduct(1, 60000, 10);
//
//        // DELETE
//        pd.deleteProduct(1);
        
        //FIND ALL 
        pd.findAll();

        pd.close();
    }
}

