import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld bean1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());
        System.out.println("Ссылки been и bean1 ссылаются на один объект-бин? " + (bean == bean1));

        Cat cat1 = applicationContext.getBean("cat", Cat.class);
        cat1.setName("Мурка");
        System.out.println(cat1.getName());
        Cat cat2 = applicationContext.getBean("cat", Cat.class);
        cat2.setName("Рыжик");
        System.out.println(cat2.getName());
        System.out.println("Ссылки cat1 и cat2 ссылаются на один объект-бин? " + (cat1 == cat2));
    }
}