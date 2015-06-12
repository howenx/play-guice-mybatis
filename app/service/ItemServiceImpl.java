package service;

import javax.inject.Inject;

import mapper.BrandsMapper;

import org.mybatis.guice.transactional.Isolation;
import org.mybatis.guice.transactional.Transactional;

import domain.Brands;

public class ItemServiceImpl implements ItemService {

  @Inject
  private BrandsMapper brandsMapper;


  @Transactional(isolation = Isolation.SERIALIZABLE)
  public Brands getBrands(Integer brandId) {
    System.out.println("This is : "+brandId);
    return this.brandsMapper.getBrands(brandId);
  }
}
