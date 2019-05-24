package com.sera.wellness.services;

import com.sera.wellness.forms.AddPersonalProductForm;
import com.sera.wellness.forms.EatenProductForm;
import com.sera.wellness.models.*;
import com.sera.wellness.repositories.EatenProductSpringDataRepository;
import com.sera.wellness.repositories.ProductSpringDataRepository;
import com.sera.wellness.utils.StuffService;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private ProductSpringDataRepository productRepository;
    @Autowired
    private EatenProductSpringDataRepository eatenProductRepository;
    @Autowired
    private Environment environment;

    private List<Product> convertImgLinks(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getImg() != null) {
                if (!product.getImg().getFileName().contains("/uploads")) {
                    product.getImg().setFileName("/uploads/" + product.getImg().getFileName());
                }
            }
        }
        return products;
    }
    @Override
    public List<Product> getAllProductsToUser(User user) {
        List<Product> products = productRepository.findAllToUser(user.getId());
        return convertImgLinks(products);
    }
    @Override
    public List<Product> getAllPersonalProducts(User user) {
        List<Product> products = productRepository.findAllPersonalByUserId(user.getId());
        return convertImgLinks(products);
    }

    @Override
    public List<Product> getAllCommonProducts() {
        List<Product> products = productRepository.findAllCommonProducts();
        return convertImgLinks(products);
    }

    @Override
    public List<EatenProduct> getAllEatenProductsToday(User user) {
        Date date = Date.valueOf(LocalDate.now());
        List<EatenProduct> eatenProducts = eatenProductRepository.findAllByUser(user, date);
        for (int i = 0; i < eatenProducts.size(); i++) {
            Product product = eatenProducts.get(i).getProduct();
            if (product ==null) {
                throw new IllegalArgumentException("eaten product must contains product");
            }
            if (product.getImg() != null) {
                if (!product.getImg().getFileName().contains("/uploads")) {
                    product.getImg().setFileName("/uploads/" + product.getImg().getFileName());
                }
            }
        }
        return eatenProducts;
    }


    @Override
    public void addPersonalProduct(AddPersonalProductForm form, User user) {
        MultipartFile multiPartFile = form.getImg();
        Product personalProduct = Product.builder()
                .name(form.getName())
                .user(user)
                .calories(form.getCalories())
                .protein(form.getProtein())
                .fats(form.getFats())
                .carbohydrates(form.getCarbohydrates())
                .build();
        if (multiPartFile == null || multiPartFile.isEmpty()) {
            throw new IllegalArgumentException("empty multiPartFile");
        }
        String[] tmp = multiPartFile.getOriginalFilename().split("\\.");
        String type = tmp[tmp.length - 1];
        String fileName = StuffService.generateUniqueFileNameForUsersUploads("imgproducts", user.getId())
                + "." + type;
        File file = new File(environment.getProperty("path.uploads") + fileName);
        System.out.println(file.getAbsolutePath().toString());
        try {
            if (file.createNewFile()) {
                Files.write(file.toPath(), multiPartFile.getBytes());
                personalProduct.setImg(UploadedFile.builder().fileName(fileName).build());
            } else {
                throw new IllegalArgumentException("error of creating new unique file name");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        productRepository.save(personalProduct);
    }

    @Override
    public boolean addEatenProduct(EatenProductForm form, User user) {
        if (productRepository.existsById(form.getProductId())) {
            throw new IllegalArgumentException("no product for youuu");
        } else if (form.getCount() < 0) {
            throw new IllegalArgumentException("must be possitive :)");
        }
        Product productDummy = Product.builder()
                .id(form.getProductId())
                .build();
        Date dateNow = Date.valueOf(LocalDate.now());
        EatenProduct eatenProductExists = null;
        try {
            eatenProductExists = eatenProductRepository.findByProductAndUserAndDate(productDummy, user, dateNow);
            eatenProductExists.setCount((short) (eatenProductExists.getCount() + form.getCount()));
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();//
        }
        if (eatenProductExists != null) {
            eatenProductRepository.save(eatenProductExists);
            return false;
        } else {
            EatenProduct eatenProductNotExists = EatenProduct.builder()
                    .date(dateNow)
                    .count(form.getCount())
                    .product(productDummy)
                    .user(user)
                    .build();
            eatenProductRepository.save(eatenProductNotExists);
            return true;
        }
    }

    @Override
    public void deleteEatenToday(Long id) {
        eatenProductRepository.delete(EatenProduct.builder().id(id).build());
    }


}
