package com.kmkunk.kunmarket.products;

import com.kmkunk.kunmarket.products.dto.ProductCategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 참고 https://galid1.tistory.com/774
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryResponseDto createProductCategory() {
        Map<Long, List<ProductCategoryResponseDto>> groups = productCategoryRepository.findAll()
                .stream()
                .map(m -> new ProductCategoryResponseDto(
                        m.getProductCategoryId(), m.getName(), m.getParentProductCategoryId()))
                .collect(Collectors.groupingBy(g -> g.getParentProductCategoryId()));
        ProductCategoryResponseDto root =
                new ProductCategoryResponseDto(0L, "기본", null);
        addChildCategories(root, groups);
        return root;
    }

    private void addChildCategories(ProductCategoryResponseDto parent,
                                    Map<Long, List<ProductCategoryResponseDto>> groups) {
        //1. parent id로 child 찾기
        List<ProductCategoryResponseDto> child = groups.get(parent.getProductCategoryId());

        //재귀 종료 조건
        if (child == null) {
            return;
        }

        //2. child 카테고리 세팅
        parent.setChildProductCategories(child);

        //3. 재귀를 이용한 child 카테고리의 child 카테고리 세팅
        child.stream()
                .forEach(c -> {
                    addChildCategories(c, groups);
                });
    }
}
