package panomate.interview.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Interview Project",
                version = "0.1-dev",
                description = "Interview Project API Documentation"
        ),
        servers = {
                @Server(
                        description = "Local ENV 1",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Local ENV 2",
                        url = "http://localhost:8443"
                )
        }
)
public class OpenAPIConfig { }
