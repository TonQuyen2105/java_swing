/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Entity;

/**
 *
 * @author acebi
 */
public class Products {
    private int ProductID;
    private String ProductName;
    private float Price;
    private int Stock;
    private int Size;
    private String PicturePath;
    private int ColorID;
    private int CategoryID;
    private int DescriptionID;
          
    public Products (int ProductID, String ProductName, float Price, int Stock, int Size, String PicturePath, int ColorID, int CategoryID, int DescriptionID) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Price = Price;
        this.Stock = Stock;
        this.Size = Size;
        this.PicturePath = PicturePath;
        this.ColorID = ColorID;
        this.CategoryID = CategoryID;
        this.DescriptionID = DescriptionID;
    }
    public int getProductID() { return ProductID; }
    public void setProductID() { this.ProductID = ProductID; }
   
    public String getProductName() { return ProductName; }
    public void setProductName() { this.ProductName = ProductName; }

//    public String getProductBaseName() { return ProductName; }
//    public void setProductBaseName() { this.ProductName = ProductName; }
    
    public float getPrice() { return Price; }
    public void setPrice() { this.Price = Price; }
    
    public int getStock() { return Stock; }
    public void setStock() { this.Stock = Stock; }
    
    public int getSize() { return Size; }
    public void setSize() { this.Size = Size; }
    
    public String getPicturePath() { return PicturePath; }
    public void setPicturePath() { this.PicturePath = PicturePath; }
    
    public int getColorID() { return ColorID; }
    public void setColorID() { this.ColorID = ColorID; }
    
    public int getCategoryID() { return CategoryID; }
    public void setCategoryID() { this.CategoryID = CategoryID; }
    
    public int getDescriptionID() { return DescriptionID; }
    public void setDescriptionID() { this.DescriptionID = DescriptionID; }
}
