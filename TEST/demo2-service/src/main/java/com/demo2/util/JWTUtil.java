package com.demo2.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;
import java.util.Random;

public class JWTUtil {
    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK 85$%^dgcsv32234545fdf>?N<:{LWPW";

    private static Key getKeyInstance() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return signingKey;
    }

    private static String getRandomSignKey() {
        StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < (int) (Math.random() * 15); i++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }

    public static String createJavaWebToken(Map<String, Object> claims) {
        // JwtBuilder builder = Jwts.builder().
        // setHeaderParam("typ", "JWT")
        // .setIssuedAt(new Date()) // 创建时间
        // .setSubject("") // 用户信息
        // .setAudience("") // 个人签名
        // .signWith(signatureAlgorithm, signingKey);
        // claims.put("sign", getRandomSignKey());
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    // public static Claims parseJWT(String jsonWebToken, String base64Security)
    // {
    // try {
    // Claims claims = Jwts.parser()
    // .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
    // .parseClaimsJws(jsonWebToken).getBody();
    // return claims;
    // } catch (Exception ex) {
    // return null;
    // }
    // }
    public static Map<String, Object> parserJavaWebToken(String jwt) {
        try {
            Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
            return null;
        }
    }

    // public static void main(String[] args) {
    //     StudentDO student = new StudentDO();
    //     student.setId(69L);
    //     Map<String, Object> claims = new HashMap<String, Object>();
    //     claims.put(Gloal.TOKEN_STUDENT_INFO_KEY, student);
    //     String token = JWTUtil.createJavaWebToken(claims);
    //     System.out.println(token);
    // }
}
