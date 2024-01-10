package dev.isa.tumit.sbggjapi;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
@ContextConfiguration(initializers = AbstractContainerTest.Initializer.class)
public abstract class AbstractContainerTest {

//    @SuppressWarnings("rawtypes")
//    static MSSQLServerContainer mssql =
//            (MSSQLServerContainer) new MSSQLServerContainer("mcr.microsoft.com/mssql/server:2022-latest")
//                    .acceptLicense()
//                    .withReuse(true);
//
//    @DynamicPropertySource
//    public static void propertySource(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mssql::getJdbcUrl);
//        registry.add("spring.datasource.username", mssql::getUsername);
//        registry.add("spring.datasource.password", mssql::getPassword);
//    }
//
//    @BeforeAll
//    static void beforeAll() {
//        mssql.start();
//    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @SuppressWarnings({"rawtypes", "resource"})
        static MSSQLServerContainer mssql =
                (MSSQLServerContainer) new MSSQLServerContainer("mcr.microsoft.com/mssql/server:2022-latest")
                        .acceptLicense()
                        .withReuse(true);

        public static Map<String, Object> getProperties() {
            Startables.deepStart(Stream.of(mssql)).join();
            return Map.of(
                    "spring.datasource.url", mssql.getJdbcUrl(),
                    "spring.datasource.username", mssql.getUsername(),
                    "spring.datasource.password",mssql.getPassword()
            );
        }

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            var env = applicationContext.getEnvironment();
            env.getPropertySources().addFirst(new MapPropertySource("testcontainers", getProperties()));
        }
    }
}
