1. 添加MybatisPlusTest后如果配置线上数据库则需要配置非测试数据库
    ```text
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    ```
2. 如果不想回滚添加@Rollback(false)注解即可
3. 如果测试类与启动类包不同，则需要使用ContextConfiguration指定
    ```text
    @ContextConfiguration(classes = HelloWorldApplication.class)
    ```
   