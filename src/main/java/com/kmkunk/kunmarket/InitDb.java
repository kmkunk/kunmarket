package com.kmkunk.kunmarket;

import com.kmkunk.kunmarket.products.ProductCategory;
import com.kmkunk.kunmarket.products.ProductCategoryService;
import com.kmkunk.kunmarket.products.dto.ProductCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {

        private final EntityManager em;
        private final ProductCategoryService productCategoryService;

        public void dbInit() {
            List<ProductCategory> productCategories = createProductCategories();
            for (ProductCategory productCategory : productCategories) {
                em.persist(productCategory);
            }
//            ProductCategoryResponseDto root = productCategoryService.createProductCategory();
        }

        public List<ProductCategory> createProductCategories() {
            ProductCategory category1 = ProductCategory.builder()
                    .name("카테고리1")
                    .parentProductCategoryId(0L)
                    .build();
            ProductCategory category2 = ProductCategory.builder()
                    .name("카테고리2")
                    .parentProductCategoryId(0L)
                    .build();
            ProductCategory category11 = ProductCategory.builder()
                    .name("카테고리1-1")
                    .parentProductCategoryId(1L)
                    .build();
            ProductCategory category12 = ProductCategory.builder()
                    .name("카테고리1-2")
                    .parentProductCategoryId(1L)
                    .build();
            ProductCategory category21 = ProductCategory.builder()
                    .name("카테고리2-1")
                    .parentProductCategoryId(2L)
                    .build();
            ProductCategory category22 = ProductCategory.builder()
                    .name("카테고리2-2")
                    .parentProductCategoryId(2L)
                    .build();
            ProductCategory category23 = ProductCategory.builder()
                    .name("카테고리2-3")
                    .parentProductCategoryId(2L)
                    .build();

            List<ProductCategory> categories =
                    List.of(category1, category2, category11, category12, category21, category22, category23);
            return categories;
        }
    }
}
