package api.bookstore;

import api.bookstore.controller.Master;
import api.bookstore.view.Home;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);

        Master masterPage = context.getBean(Master.class);
        masterPage.initialize();
    }

}