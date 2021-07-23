package com.prince.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.prince.mall.goods.entity.Brand;
import com.prince.mall.goods.service.BrandService;
import com.prince.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Project mall <br\>
 * Package com.prince.mall.goods.controller <br\>
 * <p>
 * Description : 品牌控制器 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 6:43
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * Description :  添加
     * @param brand
     * @return RespResult
     * @throws
     * @since 2021/7/7 7:01
     * @author StrangePrince
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand) {
        brandService.save(brand);
        return RespResult.ok();
    }

    /**
     * Description :  修改
     * @param brand
     * @return RespResult
     * @throws
     * @since 2021/7/7 7:01
     * @author StrangePrince
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand) {
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /**
     * Description :  修改
     * @param id
     * @return RespResult
     * @throws
     * @since 2021/7/7 7:01
     * @author StrangePrince
     */
    @DeleteMapping("{id}")
    public RespResult delete(@PathVariable(value = "id") String id) {
        brandService.removeById(id);
        return RespResult.ok();
    }

    /**
     * Description :
     * @param
     * @return RespResult {@link RespResult}
     * @throws
     * @since 2021/7/7 7:43
     * @author StrangePrince
     */
    @GetMapping("list")
    public RespResult<List<Brand>> getList() {
        return RespResult.ok(brandService.list());
    }

    /**
     * Description :
     * @param
     * @return RespResult {@link RespResult}
     * @throws
     * @since 2021/7/7 7:43
     * @author StrangePrince
     */
    @PostMapping("search")
    public RespResult<List<Brand>> getList(@RequestBody Brand brand) {
        return RespResult.ok(brandService.queryList(brand));
    }

    @PostMapping("search/{page}/{size}")
    public RespResult<Page<Brand>> getPage(@RequestBody Brand brand, @PathVariable Long page, @PathVariable Long size) {
        return RespResult.ok(brandService.queryPage(brand, page, size));
    }
}
