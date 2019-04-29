package com.leyou.auth;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTest
 * @Description TODO
 * @Author wq
 * @Date 2019/4/3 17:51
 * @Version 1.0.0
 */
public class JwtTest {

    public static void main(String[] args) {

        //证书文件
        String key_location = "key/xcnew.keystore";
        // 密钥库密码
        String keystore_password = "xuechengkeystore";
        ClassPathResource resource = new ClassPathResource(key_location);
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, keystore_password.toCharArray());

        String keypassword = "xuecheng";
        //密钥别名
        String alias = "xckey";

        //密钥对（密钥和公钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias,keypassword.toCharArray());

        //私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();

        //定义payload信息
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "123");
        tokenMap.put("name", "mrt");
        tokenMap.put("roles", "r01,r02");
        tokenMap.put("ext", "1");


        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner(aPrivate));
        //取出jwt令牌
        String token = jwt.getEncoded();
        System.out.println("token="+token);

        test();


    }

    public static void test(){
        //jwt令牌
        String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHQiOiIxIiwicm9sZXMiOiJyMDEscjAyIiwibmFtZSI6Im1ydCIsImlkIjoiMTIzIn0.liH20-T_znNYBuiVReSEndgAu2mgTtThC2j6c0o2FTPpWvSNwZvKmdwTal35cIGhcz19oPv2Vryd54bDuH1Ew7PkqRgNbADg-rj0u9y3L69To1GgwUHyzTHKWP9wNo18b8KVUkUWo3ub9hEYziceL5Rsw0si14tlHzW-xDaWA7qAGu75h8CCE4aR-XPmrgDTx4GGwxTfzq_Cxp-b5DqUYqdz40wCRzlT6dO2OJVUV7-xszMvy1aDV3eatZgQ4fwIQ_bmgdbWNA5oqlCWslR2W_glwZCc6lYa_GVzdtowY21vlKe2JHCm2YrVrP6bfSeOvrfH0fUX8xXZFVy8uVj2zA";
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvqwCDzsmKzW1o1/GeBe2g5QEk9AsUowjrM9F0KfxXHL+tQmNTSvkAjW1pKeU9ArPvjaId9MQKfMbRTlMUl/iDXEydJD3bPqqfcT+JUbMhK9LhUfSpGNcZOrGl9D7KO02C1OE0dD982g+9/c3YAVM0YtfcQRwwBvnPtrQqs3Tulw5GmcMehaPeAdaeD9gBJ/Y2PWgGF7NfFWsa3FyWy4k5N9bePCvaOfoKB7Uk1eAW6t/wJhzIpzSAr/QYtYLfWCzBB/WOozdHvcmKAwP3s4m3P97j/LItUfrChNVIPM3kzSuzTrfFBrUvMMC0e3YzF9bzQ/+XTNPTfVWOGHt3DJSFQIDAQAB-----END PUBLIC KEY-----";
        // 校验jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));
        // 获取jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims.toString());
        // jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }


}
