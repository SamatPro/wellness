package com.sera.wellness.services;
import com.sera.wellness.forms.AddPersonalProductForm;
import com.sera.wellness.forms.EatenProductForm;
import com.sera.wellness.models.EatenProduct;
import com.sera.wellness.models.Product;
import com.sera.wellness.models.User;

import java.util.List;

public interface FoodService {
    List<Product> getAllProductsToUser(User user);
    void addPersonalProduct(AddPersonalProductForm form, User user);
    boolean addEatenProduct(EatenProductForm eatenProductForm,User user);
    List<Product> getAllPersonalProducts(User user);
    List<Product> getAllCommonProducts();
    void deleteEatenToday(Long id);
    List<EatenProduct> getAllEatenProductsToday(User user);
}
