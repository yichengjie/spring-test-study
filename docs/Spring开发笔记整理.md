1. 打印容器中的Bean的名称
    ```java
    @Slf4j
    public class ContextUtils {
        // 打印出 容器中的 bean 的类名
        public static void printlnBeansClassName(ApplicationContext context) {
            String[] definitionNames = context.getBeanDefinitionNames();
            AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
            for (String definitionName : definitionNames) {
                Class<?> type = beanFactory.getType(definitionName);
                assert type != null;
                log.info("name : {}", type.getName());
            }
            log.info("names count = {}", definitionNames.length);
        }
    }
    ```