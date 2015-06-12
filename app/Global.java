
// //
// // public class Global extends GlobalSettings {
// //
// // private Injector injector;
// //
// // @Override
// // public void onStart(Application app) {
// // // // bindings
// // //
// // injector = Guice.createInjector(new MyBatisModule() {
// // @Override
// // protected void initialize() {
// // bindDataSourceProvider(new Provider<DataSource>() {
// // @Override
// // public DataSource get() {
// // // use db as configured in conf/application.conf
// // return DB.getDataSource("development");
// // }
// // });
// // bindTransactionFactoryType(JdbcTransactionFactory.class);
// //
// // final Properties myBatisProperties = new Properties();
// // myBatisProperties.setProperty("mybatis.environment.id", "development");
// // Names.bindProperties(binder(), myBatisProperties);
// // bind(BrandsDao.class).to(BrandsDaoImpl.class);
// // addMapperClass(BrandsMapper.class);
// // }
// // });
// // // ,
// // // new XMLMyBatisModule() {
// // // @Override
// // // protected void initialize() {
// // //
// // // setEnvironmentId("development");
// // // setClassPathResource("mybatis-config.xml");
// // // // addProperties(properties);
// // // // bindDataSourceProvider();
// // // // bindTransactionFactoryType(JdbcTransactionFactory.class);
// // // // DB.getDataSource("development");
// // // }
// // // }
// // // );
// // // injector = Guice.createInjector(new XMLMyBatisModule() {
// // // @Override
// // // protected void initialize() {
// // // setClassPathResource("mybatis-config.xml");
// // // setEnvironmentId("development");
// // // }
// // // });
// //
// // // addMapperClass(BrandsMapper.class);
// //
// // // install(new XMLMyBatisModule() {
// // //
// // // @Override
// // // protected void initialize() {
// // // setClassPathResource("dest-config.xml");
// // // setEnvironmentId("development");
// // // }
// // // });
// // // expose(BrandsMapper.class);
// //
// //
// // }
// //
// // @Override
// // public <A> A getControllerInstance(Class<A> clazz) throws Exception {
// // return injector.getInstance(clazz);
// // }
// //
// // }
// import java.util.ArrayList;
// import java.util.List;
//
// import javax.sql.DataSource;
//
// import mapper.BrandsMapper;
//
// import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
// import org.mybatis.guice.MyBatisModule;
// import org.mybatis.guice.XMLMyBatisModule;
// import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
//
// import play.Application;
// import play.GlobalSettings;
// import play.db.DB;
//
// import com.google.inject.Guice;
// import com.google.inject.Injector;
// import com.google.inject.Module;
// import com.google.inject.Provider;
//
// import dao.BrandsDao;
// import dao.BrandsDaoImpl;
//
//
//
// public class Global extends GlobalSettings {
//
// private static final Injector INJECTOR = createInjector();
//
// @Override
// public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
// return INJECTOR.getInstance(controllerClass);
// }
//
// private static Injector createInjector() {
// List<Module> modules = createMyBatisModule();
// // this.injector = ;
// return Guice.createInjector(modules);
// }
// @Override
// public void onStart(Application app) {
// createInjector();
// }
// protected static List<Module> createMyBatisModule() {
// List<Module> modules = new ArrayList<Module>();
// // modules.add(JdbcHelper.HSQLDB_IN_MEMORY_NAMED);
// modules.add(new MyBatisModule() {
//
// @Override
// protected void initialize() {
// bindDataSourceProvider(new Provider<DataSource>() {
// @Override
// public DataSource get() {
// // use db as configured in conf/application.conf
// return DB.getDataSource("development");
// }
// });
// bindDataSourceProviderType(PooledDataSourceProvider.class);
// bindTransactionFactoryType(JdbcTransactionFactory.class);
// addMapperClass(BrandsMapper.class);
// bind(BrandsDao.class).to(BrandsDaoImpl.class);
// }
//
// });
//
// modules.add(new XMLMyBatisModule() {
//
// @Override
// protected void initialize() {
// setEnvironmentId("development");
// setClassPathResource("mybatis-config.xml");
// }
// });
//
// // modules.add(new Module() {
// // public void configure(Binder binder) {
// //
// // bindProperties(binder, createTestProperties());
// // binder.bind(FooService.class).to(FooServiceDaoImpl.class);
// // binder.bind(UserDao.class).to(UserDaoImpl.class);
// // }
// // });
//
// return modules;
// }
// }
import java.util.ArrayList;
import java.util.List;

import org.mybatis.guice.XMLMyBatisModule;

import play.Application;
import play.GlobalSettings;
import service.ItemService;
import service.ItemServiceImpl;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Global extends GlobalSettings {

  private Injector injector;

  @Override
  public void onStart(Application app) {
    // injector = Guice.createInjector(new MyBatisModule() {
    // @Override
    // protected void initialize() {
    // bindDataSourceProvider(new Provider<DataSource>() {
    // @Override
    // public DataSource get() {
    // // use db as configured in conf/application.conf
    // return DB.getDataSource("development");
    // }
    // });
    // bindTransactionFactoryType(JdbcTransactionFactory.class);
    // final Properties myBatisProperties = new Properties();
    // myBatisProperties.setProperty("mybatis.environment.id", "development");
    // Names.bindProperties(binder(), myBatisProperties);
    // }
    // });
    List<Module> modules = this.createMyBatisModule();
    this.injector = Guice.createInjector(modules);
    System.out.println("********************阿斯顿发顺风大是大非");
  }

  @Override
  public <A> A getControllerInstance(Class<A> clazz) throws Exception {
    return injector.getInstance(clazz);
  }

  public List<Module> createMyBatisModule() {
    List<Module> modules = new ArrayList<Module>();

    modules.add(new XMLMyBatisModule() {

      @Override
      protected void initialize() {
        setEnvironmentId("development");
        setClassPathResource("mybatis-config.xml");
      }

    });

    modules.add(new Module() {
      public void configure(Binder binder) {

        binder.bind(ItemService.class).to(ItemServiceImpl.class);
      }
    });

    return modules;
  }
}
