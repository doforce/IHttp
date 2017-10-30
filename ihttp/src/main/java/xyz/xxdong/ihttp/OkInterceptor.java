package xyz.xxdong.ihttp;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pc on 2017/10/30.
 */

public class OkInterceptor implements Interceptor {

    private Map<String,String> mHeaders;

    public OkInterceptor(Map<String,String> headers){
        this.mHeaders = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request()
                .newBuilder();
                for (Map.Entry<String,String> headers:mHeaders.entrySet()){
                    builder.addHeader(headers.getKey(),headers.getValue());
                }
        return chain.proceed(builder.build());
    }
}
