package com.springboot.SMS.global;

import java.util.List;
import java.util.ArrayList;

import com.springboot.SMS.model.Product;

public class Globaldata {
	public static List<Product> cart;
	static {
		cart = new ArrayList<Product>();
	}
}
