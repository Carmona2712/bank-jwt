package com.raca.testbank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private ExtendsTokenInfo extendsTokenInfo;


    /**
     * Este método se utiliza para configurar la seguridad del Servidor de Autorización.
     * Sobrescribe el método configure de AuthorizationServerConfigurerAdapter.
     *
     * @param security Esta es la instancia de AuthorizationServerSecurityConfigurer que proporciona métodos para
     *                 ajustar la configuración de seguridad del Servidor de Autorización.
     * @throws Exception Esta excepción se lanza cuando hay un error durante el proceso de configuración.
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // Esta línea permite a cualquier cliente acceder a la clave del token.
        security.tokenKeyAccess("permitAll()")
                // Esta línea asegura que sólo los clientes autenticados pueden comprobar el token.
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("testbank")
                .secret(passwordEncoder.encode("12345"))
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
    tokenEnhancerChain.setTokenEnhancers(Arrays.asList(extendsTokenInfo,accessTokenConverter()));

       endpoints.authenticationManager(this.authenticationManager)
               .accessTokenConverter(accessTokenConverter())
               .tokenEnhancer(tokenEnhancerChain);

    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        return jwtAccessTokenConverter;
    }
}
