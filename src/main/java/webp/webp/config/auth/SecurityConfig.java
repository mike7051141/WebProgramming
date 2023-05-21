package webp.webp.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuthService oAuthService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/oauth/loginInfo", true)
                .userInfoEndpoint()
                .userService(oAuthService);

        return http.build();
    }
}
