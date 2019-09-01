package com.hackpro.appsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	private static final String SECURITY_CONSTRAINT = "isAuthenticated()";

	@Autowired
	private AuthenticationManager authenticationManager;

	// Secret Id -> Hack-Pro-Secret

	@Value("${security.oauth2.client.id}")
	private String CLIENT_ID;

	@Value("${security.oauth2.client.client-secret}")
	private String CLIENT_SECRET_ID;

	@Value("${security.oauth2.client.authorized-grant-types}")
	private String[] CLIENT_AUTHORIZED_TYPES;

	@Value("${security.oauth2.client.authorities}")
	private String[] AUTHORITIES;

	@Value("${security.oauth2.client.scope}")
	private String[] SCOPE;

	@Value("${security.oauth2.client.resource-ids}")
	private String[] RESOURCE_IDS;

	@Value("${security.oauth2.client.access-token-validity-seconds}")
	private int ACCESS_TOKEN_VALIDITY_SECONDS;

	@Value("${security.oauth2.client.refresh-token-validity-seconds}")
	private int REFRESH_TOKEN_VALIDITY_SECONDS;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess(SECURITY_CONSTRAINT);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(CLIENT_ID).secret(CLIENT_SECRET_ID).authorizedGrantTypes(CLIENT_AUTHORIZED_TYPES)
				.authorities(AUTHORITIES).scopes(SCOPE).resourceIds(RESOURCE_IDS)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}

}
