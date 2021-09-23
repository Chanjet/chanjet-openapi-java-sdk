# chanjet-openapi-java-sdk

欢迎使用 Chanjet OpenApi SDK for Java 。

## 环境要求
1. 使用 Chanjet OpenApi SDK for Java 之前 ，您需要先前往[畅捷通-开发者中心](https://dev.chanjet.com)完成开发者接入的一些准备工作，包括创建应用、获取应用的appKey和appSecret。

## 快速使用
### 原生java项目使用
1. Chanjet OpenApi SDK for Java 需要配合`JKD 1.6`或其以上版本。

### 安装依赖
推荐通过Maven来管理项目依赖，您只需在项目的`pom.xml`文件中声明如下依赖
```xml
<dependency>
    <groupId>com.chanjet</groupId>
    <artifactId>java-sdk-common</artifactId>
    <version>1.1.0-RELEASE</version>
</dependency>
```
### 代码示例
```java
import com.chanjet.openapi.sdk.java.domain.CreateTenantContent;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.CreateTenantRequest;
import com.chanjet.openapi.sdk.java.response.CreateTenantResponse;

public class SdkTest {
    public static void main(String[] args) {
        try {
            //创建client
            DefaultChanjetClient defaultChanjetClient = new DefaultChanjetClient("https://openapi.chanjet.com","zMqBZ...","5DB7FB61... ...");

            //创建请求对象
            CreateTenantRequest createTenantRequest = new CreateTenantRequest();
            
            //设置header参数,接口如无appKey、appSecret、appSecret、Content-Type四个参数之外的请求头，则不需要传
            createTenantRequest.addHeader("key", "value");

            //设置query参数,接口无query参数则不需要传
            createTenantRequest.addQueryParam("key", "value");

            //设置业务参数对象
            CreateTenantContent createTenantContent = new CreateTenantContent();
            createTenantContent.setTenantId("tenant_987... ...");
            createTenantRequest.setBizContent(createTenantContent);
            //发起请求并响应
            CreateTenantResponse createTenantResponse = defaultChanjetClient.execute(createTenantRequest);
            if (createTenantResponse.getResult()) {
                System.out.println("调用成功。");
            } else {
                System.out.println("调用失败，原因：" + createTenantResponse.getError().getMessage());
            }
        } catch (ChanjetApiException e) {
            //做异常处理
            System.out.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
```

### spring-boot项目使用
1. 需要配合`JKD 1.8`或其以上版本。

### 安装依赖
推荐通过Maven来管理项目依赖，您只需在项目的`pom.xml`文件中声明如下依赖
```xml
<dependency>
    <groupId>com.chanjet</groupId>
    <artifactId>java-sdk-spring-starter</artifactId>
    <version>1.1.0-RELEASE</version>
</dependency>
```

### 配置文件
```yaml
chanjet:
  client:
    serverUrl: https://inte-openapi.chanjet.com
    appKey: hdxt...
    appSecret: 10FBDBD5C3... ...
```

### 代码示例
```java
import com.chanjet.openapi.sdk.java.ChanjetClient;
import com.chanjet.openapi.sdk.java.domain.CreateTenantContent;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.CreateTenantRequest;
import com.chanjet.openapi.sdk.java.response.CreateTenantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: zsc
 * @create: 2021/9/20 9:31 下午
 **/
@RequestMapping("test")
@RestController
public class TestController {
    @Autowired
    private ChanjetClient chanjetClient;

    /**
     * 创建租户
     *
     * @return
     */
    @GetMapping("createTenant")
    public CreateTenantResponse createTenant() throws ChanjetApiException {
        //创建租户
        CreateTenantRequest createTenantRequest = new CreateTenantRequest();
        CreateTenantContent createTenantContent = new CreateTenantContent();
        createTenantContent.setTenantId(UUID.randomUUID().toString());
        createTenantRequest.setBizContent(createTenantContent);
        CreateTenantResponse createTenantResponse = chanjetClient.execute(createTenantRequest);
        return createTenantResponse;
    }
}
```
