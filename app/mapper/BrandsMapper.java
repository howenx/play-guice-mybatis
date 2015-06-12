package mapper;

import domain.Brands;

public interface BrandsMapper {
  
//  @Select("SELECT * FROM brands WHERE brand_id = #{brandId}")
//  Brands getBrands(@Param("brandId") Integer brandId);
  Brands getBrands(Integer brandId);
}
