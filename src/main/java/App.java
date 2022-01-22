import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld singletonBean1 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(singletonBean1.getMessage());
        HelloWorld singletonBean2 = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(singletonBean2.getMessage());

        Cat prototypeBean1 = (Cat) applicationContext.getBean("cat");
        System.out.println(prototypeBean1.getName());
        Cat prototypeBean2 = (Cat) applicationContext.getBean("cat");
        System.out.println(prototypeBean2.getName());

        System.out.println(singletonBean1.equals(singletonBean2));
        System.out.println(prototypeBean1.equals(prototypeBean2));

        applicationContext.close();
    }
}