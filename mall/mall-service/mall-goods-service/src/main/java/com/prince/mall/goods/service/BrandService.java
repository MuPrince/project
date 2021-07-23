package com.prince.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.prince.mall.goods.entity.Brand;

import java.util.List;

/**
 * Project mall <br\>
 * Package com.prince.mall.goods.mapper <br\>
 * <p>
 * Description : 品牌Service <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 6:36
 */
public interface BrandService extends IService<Brand> {

    /**
     * Description :  条件查询
     * @param brand
     * @return java.util.List<com.prince.mall.goods.entity.Brand>
     * @throws
     * @since 2021/7/7 7:46
     * @author StrangePrince
     */
    List<Brand> queryList(Brand brand);

    /**
     * Description :  分页查询
     * @param brand
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.prince.mall.goods.entity.Brand>
     * @throws
     * @since 2021/7/7 8:08
     * @author StrangePrince
     */
    Page<Brand> queryPage(Brand brand, Long currentPage, Long size);
}
