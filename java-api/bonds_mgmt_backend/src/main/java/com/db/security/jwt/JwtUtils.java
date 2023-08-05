package com.db.security.jwt;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.db.security.services.UserDetailsImpl;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	@Value("${db.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	@Value("${db.app.jwtSecret}")
	private String jwtSecret;

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

	public String generateJwtToken(Authentication authentication) {
		Map<String, Object> jwt_value = new HashMap<String, Object>();
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		jwt_value.put("username", userPrincipal.getUsername());
		jwt_value.put("email", userPrincipal.getEmail());
		jwt_value.put("role", userPrincipal.getRole());
		return Jwts.builder().setClaims(jwt_value).setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public String getEmailFromJWT(String token) {
		return (String) Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("email");
	}
	
	public String getRoleFromJWT(String token) {
		return (String) Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("role");
	}


}
