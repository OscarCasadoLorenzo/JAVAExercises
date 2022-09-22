package spring.springboot.EnterpriseApplication.application.Token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import spring.springboot.EnterpriseApplication.application.Person.PersonService;
import spring.springboot.EnterpriseApplication.domain.PersonEntity;
import spring.springboot.EnterpriseApplication.insfraestructure.repository.PersonRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenService implements TokenInterface{

    @Value("${secretkey}")
    String secretKey;

    @Autowired
    PersonRepository personRepository;

    private String generateJWTToken(Integer id, String user, String role){
        List<GrantedAuthority> grantedAuthorities;
        if(role.equals("admin"))
            grantedAuthorities= AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        else grantedAuthorities= AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId(id.toString())
                .setSubject(user)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
        return "Bearer " + token;
    }

    @Override
    public String getToken(String email, String password) {
        PersonEntity userLogin = null;
        if(personRepository.findByEmail(email).size() != 0) {
            userLogin = personRepository.findByEmail(email).get(0);
            if (userLogin.getPassword().equals(password)) {
                return generateJWTToken(userLogin.getId(), userLogin.getEmail(), userLogin.getRol());
            } else return "Incorrect password. Try again.";
        } else return "User with email: " + userLogin.getEmail() + " doesnt exits.";
    }

    @Override
    public ResponseEntity checkToken(String token) {
        if(token != null)
            return new ResponseEntity(null, HttpStatus.OK);
        else return  new ResponseEntity(null, HttpStatus.FORBIDDEN);
    }
}
