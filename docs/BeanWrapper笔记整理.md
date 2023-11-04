1. 获取类的属性列表
    ```java
    public class BeanWrapperTest {
        @Test
        public void hello(){
            BeanWrapper beanWrapper = new BeanWrapperImpl(MapperScannerConfigurer.class);
            List<String> propertyNames = Stream.of(beanWrapper.getPropertyDescriptors())
                    .map(PropertyDescriptor::getName)
                    .toList();
            log.info("propertyNames : {}", propertyNames);
            // basePackage, processPropertyPlaceHolders, sqlSessionFactory ...
        }
    }
    ```