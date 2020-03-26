package com.zhaojian.pervue;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * 代码生成器类
 */
public class CodeGenerator {
    //程序入口
    public static void main(String[] args) {
        //创建自动生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        //创建配置对象
        GlobalConfig config = new GlobalConfig();
        //设置作者
        config.setAuthor("ZJ");
        //Mapper.xml多一个resultMap的结果
        config.setBaseResultMap(true);
        //Mapper.xml包含sql片段
        config.setBaseColumnList(true);
        //输出路径
        config.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        //输出是否打开
        config.setOpen(false);
        //全局配置
        autoGenerator.setGlobalConfig(config);


        //设置包名
        PackageConfig packageConfig = new PackageConfig();


        //设置包名
        packageConfig.setParent(CodeGenerator.class.getPackage().getName());

        //设置包名
        autoGenerator.setPackageInfo(packageConfig);


        //创建数据源配置的对象
        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        //数据库连接地址
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/kylin?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        //驱动类 名称
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        //用户名
        dataSourceConfig.setUsername("root");
        //密码
        dataSourceConfig.setPassword("root");

        //设置连接数据源
        autoGenerator.setDataSource(dataSourceConfig);

        //生成策略
        StrategyConfig strategyConfig = new StrategyConfig();
        //包含那些表
        strategyConfig.setInclude("lx_goods","lx_sales","lx_goods_sales");
        //strategyConfig.setExclude() 排除那些表
        //排除前缀
        strategyConfig.setTablePrefix("lx_");
        //使用lombok 对实体Bean处理
        strategyConfig.setEntityLombokModel(true);
        //生成策略
        autoGenerator.setStrategy(strategyConfig);


        //执行生成
        autoGenerator.execute();

    }
}
