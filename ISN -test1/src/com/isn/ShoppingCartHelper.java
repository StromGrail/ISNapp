package com.isn;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
 
 public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
 
 private static List<Product> catalog;
 private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();
 
 public static List<Product> getCatalog(Resources res){
  if(catalog == null) {
   catalog = new Vector<Product>();
   catalog.add(new Product("Nokia Lumia", res
     .getDrawable(R.drawable.lumia),
     "Business Features	 Document Viewer, Microsoft Word, Microsoft Excel, Microsoft PowerPoint, PDF, PPT, PPTX, XLS, XLSX, TXT, DOC, DOCX\r\nHandset Color	 Gold\r\nForm	 Bar\r\nSIM Size	 Nano SIM", 30000));
   catalog.add(new Product("Samsung Galaxy s5", res
     .getDrawable(R.drawable.galaxys5),
     "Business Features	 Document Viewer, Microsoft Word, Microsoft Excel, Microsoft PowerPoint, PDF, PPT, PPTX, XLS, XLSX, TXT, DOC, DOCX\r\nHandset Color	 Gold\r\nForm	 Bar\r\nSIM Size	 Nano SIM", 13500));
  
   catalog.add(new Product("SkullCandy headphones", res
		     .getDrawable(R.drawable.headphone),
		     "Stereo Sound , Bluetooth connectivity", 7382));
		   catalog.add(new Product("HP Inkjet Printer", res
		     .getDrawable(R.drawable.hp),
		     "HP inkjet printer,Print upto 10000 pages in one refil", 3000));
		   
  
  }
  
  return catalog;
 }
 
 public static void setQuantity(Product product, int quantity) {
  // Get the current cart entry
  ShoppingCartEntry curEntry = cartMap.get(product);
  
  // If the quantity is zero or less, remove the products
  if(quantity <= 0) {
   if(curEntry != null)
    removeProduct(product);
   return;
  }
  
  // If a current cart entry doesn't exist, create one
  if(curEntry == null) {
   curEntry = new ShoppingCartEntry(product, quantity);
   cartMap.put(product, curEntry);
   return;
  }
  
  // Update the quantity
  curEntry.setQuantity(quantity);
 }
 
 public static int getProductQuantity(Product product) {
  // Get the current cart entry
  ShoppingCartEntry curEntry = cartMap.get(product);
  
  if(curEntry != null)
   return curEntry.getQuantity();
  
  return 0;
 }
 
 public static void removeProduct(Product product) {
  cartMap.remove(product);
 }
 
 public static List<Product> getCartList() {
  List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
  for(Product p : cartMap.keySet()) {
   cartList.add(p);
  }
  
  return cartList;
 }
 

}