package packt.dbatista.services.sample.config.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.monitor.GithubPropertyPathNotificationExtractor;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

    @Bean
    public GithubPropertyPathNotificationExtractor githubPropertyPathNotificationExtractor() {
        return new GithubPropertyPathNotificationExtractor();
    }

}
