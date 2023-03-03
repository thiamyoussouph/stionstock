package com.udemy.courudemy.Config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@Configuration
public class FlickrConfiguration {
    @Value("${flickr.apikey}")
    private String apikey;
    @Value("${flickr.secret}")
    private String secret;
    @Value("${appkey}")
    private String appkey;
    @Value("${appsecret}")
    private String appsecret;
/**@Bean
    public Flickr getApikey() throws IOException, ExecutionException, InterruptedException, FlickrException {
        Flickr flickr = new Flickr(apikey, secret, new REST());
        OAuth10aService service =new ServiceBuilder(apikey)
                .apiSecret(secret)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));
        final Scanner scanner = new Scanner(System.in);
        final OAuth1RequestToken requestToken = service.getRequestToken();
        final String authorizationUrl = service.getAuthorizationUrl(requestToken);
        System.out.println(authorizationUrl);
        System.out.println("Paste this url in your browser");
        final String oauthVerifier = scanner.nextLine();
        OAuth1AccessToken accessToken = service.getAccessToken(requestToken, oauthVerifier);
        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());
        Auth auth = flickr.getAuthInterface().checkToken(accessToken);
        System.out.println("-----------------------------------------------");
        System.out.println(auth.getToken());
        System.out.println(auth.getTokenSecret());
        return flickr ;
    }**/
@Bean
public  Flickr getFlickr(){
 Flickr   flickr = new Flickr(apikey, secret, new REST());
    Auth auth = new Auth();
    auth.setPermission(Permission.DELETE);
    auth.setToken(appkey);
    auth.setTokenSecret(appsecret);
    RequestContext requestContext = RequestContext.getRequestContext();
    requestContext.setAuth(auth);
    flickr.setAuth(auth);
    return flickr;
}
}
