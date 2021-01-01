# 皮卡丘系统 Model 模块使用指南

## 背景

皮卡丘 model 模块负责持久化数据,ORM 框架采用 mybatis-plus

## 生成代码

由于 mybatis mapper.xml 编写繁琐极易出错,故 皮卡丘 使用 idea 插件自动生成.

1. 打开 idea 插件中心,安装插件 Free Mybatis plugin ,安装完毕,重启启用.
2. 打开 idea 配置中心,按照如下配置:
   ![](https://itguang.oss-cn-beijing.aliyuncs.com/20210101164128.png)

3. 打开 pikachu 项目, 点击右边窗口 DataSource 窗口,连接数据,进行 mybatis 代码生成

![](https://itguang.oss-cn-beijing.aliyuncs.com/20201227155329.png)

4. 生成完毕,可以看到 model 模块多了几个文件

![](https://itguang.oss-cn-beijing.aliyuncs.com/20201227155514.png)

5. 最后在生成 的 xxxRepository 类就是操作数据库的持久化接口



自动生成的 Mapper 文件,默认支持 Example 方式, 也可以继承 Mybatis-Plus 提供的 BaseMapper,获得额外的功能

```java
@Mapper
public interface SysLogRepository extends BaseMapper<SysLog> {
    long countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

    SysLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}
```



## 查询使用

查询可以通过两种方式:

1. XXXExample

```java
    public List<SysLog> findByName(String name) {
        SysLogExample example = new SysLogExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andUsernameLike(name);
        List<SysLog> tbUsers = sysLogRepository.selectByExample(example);
        return tbUsers;
    }
```

2. QueryWapper

```java
    public List<SysLog> findByWapper(String name) {
        QueryWrapper<SysLog> wrapper = new QueryWrapper<>();
        wrapper.eq("username", name)
                .orderByDesc("id");
        List<SysLog> selectPage = sysLogRepository.selectList(wrapper);
        return selectPage;
    }
```




## 分页使用

```java
/**
 * Wrapper 分页 - 可用
 *  com.baomidou.mybatisplus.extension.plugins.pagination.Page
 *
 * @param page
 * @param name
 * @return
 */
public Page<SysLog> findByPage(Page page, String name) {
    QueryWrapper<SysLog> wrapper = new QueryWrapper<>();
    wrapper.eq("username", name);
    Page<SysLog> selectPage = sysLogRepository.selectPage(page, wrapper);
    return selectPage;
}
```



```java
public List<SysLog> findByPage2(Pageable page, String name) {
    SysLogExample example = new SysLogExample();
    example.createCriteria().andUsernameLike(name);
    // Mybatis-generate 生成的 Example 自带的分页
    example.setLimit(page.getPageSize());
    example.setOffset(page.getOffset());
    return sysLogRepository.selectByExample(example);
}
```

> 注意 PaheHelper 分页插件极度影响性能,最好不要使用,本项目也没有集成

## 枚举使用

持久化时枚举使用

加入我们有一张表:

```sql
CREATE TABLE `emun_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT NULL COMMENT 'l类型枚举',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
```

其中 type 和 status 为枚举值,我们想在 java 中使用 Enum 类型时该怎么做呢?

很简单,只需要三步:

第一步: 定义枚举类型: 

```java
@AllArgsConstructor
@Getter
public enum TestType {
    ONE(1, "一"),
    TWO(2, "二");

   // 使用注解方式,标注持久化时使用哪个字段入库
    @EnumValue
    private final int code;

    private final String name;
}
```

```java
@AllArgsConstructor
@Getter
public enum TestStatus implements IEnum<Integer> {
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    PROCESS(3, "进行中..."),
    ;

    private final int code;

    private final String name;

    // 使用继承接口的方式,指定持久化时使用的值
    @Override
    public Integer getValue() {
        return this.code;
    }
}
```

第二步: 替换生成的 Entity 实体类

```java
@Data
public class EmunTest implements Serializable {
    private Integer id;

    /**
     * 类型枚举
     */
    private TestType type;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private TestStatus status;

    private static final long serialVersionUID = 1L;
}
```



第三步: 返回前端的 VO 类添加序列化器:

```java
@Data
public class TestEnumVO {
    private Integer id;

    /**
     * 类型枚举
     */
    @JsonSerialize(using = EnumToListSerializer.class)
    private TestType type;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    @JsonSerialize(using = EnumToListSerializer.class)
    private TestStatus status;
}
```



测试结果:

```json
{
    "id": 1,
    "type": [
        "ONE",
        "一",
        1
    ],
    "name": "测试",
    "status": [
        "SUCCESS",
        "成功",
        1
    ]
}
```

> 注意当前端提交枚举字段的时候,取的 是 数组的第一个值,即 ONE 或者 SUCCESS 等





