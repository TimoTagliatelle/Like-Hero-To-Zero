@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager users() {

        UserDetails scientist = User.withDefaultPasswordEncoder()
                .username("scientist")
                .password("climate123")
                .roles("SCIENTIST")
                .build();

        return new InMemoryUserDetailsManager(scientist);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                // öffentlich
                .requestMatchers("/", "/api/**", "/css/**", "/login").permitAll()

                // admin (WICHTIG: beide Varianten absichern)
                .requestMatchers("/admin", "/admin/**").hasRole("SCIENTIST")

                .anyRequest().permitAll()
            )

            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/admin", true)
                .failureUrl("/login?error")
                .permitAll()
            )

            .logout(logout -> logout
                .logoutSuccessUrl("/")
            );

        return http.build();
    }
}