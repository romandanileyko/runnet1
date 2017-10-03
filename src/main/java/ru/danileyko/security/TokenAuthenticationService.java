package ru.danileyko.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by danil on 13.09.2017.
 */
public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 3600_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "";
    static final String HEADER_STRING = "Authorization";


    static void addAuthentication(HttpServletResponse res, String username, Collection<? extends GrantedAuthority> authorities) {
        System.out.println("Input authorities: "+ authorities);
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .claim("roles",authorities)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        List<GrantedAuthority> grantedAuthorityList=null;
        List<String> list = new ArrayList<>();
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            List<String> roles = (ArrayList)claims.get("roles");
            for (Object role:roles){
                HashMap<String,String> map = (HashMap<String,String>)role;
                list.addAll(map.values());
            }
            String stringAuthority  = CreateCommaSeparatedtring(list);
            grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthority);
            System.out.println("commaSeparatedString"+stringAuthority);
            grantedAuthorityList.stream().forEach(p->System.out.println("grantedAuthorityList: "+p));
            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, grantedAuthorityList) :
                    null;
        }
        return null;
    }

    private static String CreateCommaSeparatedtring(List<String> list){
        StringBuilder authorityString = new StringBuilder();
        for(String string: list){
            authorityString.append(string);
            authorityString.append(",");
        }
        return authorityString.length() >0 ? authorityString.substring(0,authorityString.length()-1) : "";
    }

}
