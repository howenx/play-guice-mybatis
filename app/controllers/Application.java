package controllers;

import javax.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;
import service.ItemService;

public class Application extends Controller {

//  @Inject
//  private BrandsDao brandsDao;
  
  @Inject
  private ItemService itemService;
  
  public Result index() {
    
    return ok(views.html.index.render("Your app is running with ds: " + " 品牌信息:"+itemService.getBrands(11022).getBrandNmEn()));
  }

}
