package com.kmkunk.kunmarket.products;

import com.kmkunk.kunmarket.products.dto.ProductCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 참고 https://galid1.tistory.com/774
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryResponseDto createProductCategory() {
        Map<Long, List<ProductCategoryResponseDto>> result = productCategoryRepository.findAll()
                .stream()
                .map(m -> new ProductCategoryResponseDto(
                        m.getProductCategoryId(), m.getName(), m.getParentProductCategoryId()))
                .collect(Collectors.groupingBy(g -> g.getParentProductCategoryId()));

        ProductCategoryResponseDto root =
                new ProductCategoryResponseDto(0L, "기본", null);
        //addChildCategories(root, result); 구현 필요
        return root;
    }
}
