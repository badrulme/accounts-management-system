package com.nahalit.nahalapimanager.apiconfig;

public class AppConfig {
    public static final String CONTEXT_PATH="/nahal/v1";
    public static final String SERVER_PORT="8181";
    public static String[] NONFILTERRING_PATH_PATTERNS =new String[]{"/api/rest/rl/client/common/auth/login**","/core/auth/**",",/csrf", "/v2/api-docs", "/swagger-resources/configuration/ui", "/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/configuration/security", "/swagger-ui.html", "/webjars/**"};
    public static String[] FILTERRING_PATH_PATTERNS =new String[]{"/**"};
    public static final String APPLICATION_JWT_PRIVATE_KEY  ="0E041573DA7FEBD98D5679005566D9584DB9FB638C2C411BA94DE612E519C411";

}
