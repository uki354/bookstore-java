package com.bookstore.bookstore.security;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtService {

	private final long accessTokenDuration = 15778440000L; // 6months

	public String generateJwtToken(User user, String issuer) {

		return JWT.create().withSubject(user.getUsername()).withIssuer(issuer)
				.withExpiresAt(new Date(System.currentTimeMillis() + accessTokenDuration))
				.withClaim("roles",
						user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(getAlgorithm());
	}

	public DecodedJWT verifyJwtToken(String token) {
		JWTVerifier verifier = JWT.require(getAlgorithm()).build();
		return verifier.verify(token);
	}

	private Algorithm getAlgorithm() {
		return Algorithm.HMAC256("secret");
	}
}