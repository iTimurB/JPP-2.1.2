import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Configuration
//является источниками определения бинов
public class AppConfig {
    private final static Logger LOGGER = Logger.getLogger(AppConfig.class.getName());

    //по умолчанию scope "singleton"
    @Bean(name = "helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    @Bean(name = "cat")
    @Scope("prototype")
    public Cat getCat() {
        Cat cat = new Cat();
        cat.setName("Cat");
        return cat;
    }

    @PostConstruct
    public void init() {
        LOGGER.info("PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        LOGGER.info("PreDestroy");
    }
}