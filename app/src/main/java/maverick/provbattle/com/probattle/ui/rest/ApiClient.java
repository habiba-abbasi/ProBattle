package maverick.provbattle.com.probattle.ui.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Habiba Abbasii on 31/03/2018.
 */


public class ApiClient {
//    https://api.coinmarketcap.com/v1/ticker/?limit=10
    public static final String BASE_URL = "https://api.coinmarketcap.com";
    public static Retrofit mInstance = null;

    //singleton method
    public static Retrofit getApiClient() {
        if (mInstance == null) {
            mInstance = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return mInstance;

    }
}
