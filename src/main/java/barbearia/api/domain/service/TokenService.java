package barbearia.api.domain.service;

//import barbearia.api.domain.entity.Barbeiro;
import barbearia.api.domain.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

	@Value("${API.SPRING-LOCALHOST-SECRET}")
	private String SECRET;

	private static final String ISSUER = "";

	public String gerarTokenUser(Usuario login) {
		try {
			var algoritmo = Algorithm.HMAC256(SECRET);
			return JWT.create()
					.withIssuer(ISSUER)
					.withSubject(login.getLogin())
					.withClaim("id", login.getId())
					.withExpiresAt(dataExpiracao())
					.sign(algoritmo);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("erro ao gerar token jwt", exception);
		}
	}

//	public String gerarTokenBarber(Barbeiro login) {
//		try {
//			var algoritmo = Algorithm.HMAC256(SECRET);
//			return JWT.create()
//					.withIssuer(ISSUER)
//					.withSubject(login.getLogin())
//					.withClaim("id", login.getId())
//					.withExpiresAt(dataExpiracao())
//					.sign(algoritmo);
//		} catch (JWTCreationException exception) {
//			throw new RuntimeException("erro ao gerar token jwt", exception);
//		}
//	}

	public String getSubject(String tokenJWT){
		try {
			var algoritmo = Algorithm.HMAC256(SECRET);
			return JWT.require(algoritmo)
					.withIssuer(ISSUER)
					.build()
					.verify(tokenJWT)
					.getSubject();
		} catch (JWTVerificationException exception){
			throw new RuntimeException("Token JWT inválido ou expirado!" +tokenJWT);
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
	}
}
