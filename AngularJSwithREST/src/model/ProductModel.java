package model;

import orm.Product;

public class ProductModel extends AbstractModel<Product> {
	public ProductModel() {
		super(Product.class);
	}
}
