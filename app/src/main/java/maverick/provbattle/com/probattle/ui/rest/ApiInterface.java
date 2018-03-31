package maverick.provbattle.com.probattle.ui.rest;

import java.util.List;

import maverick.provbattle.com.probattle.ui.model.CryptoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Habiba Abbasii on 31/03/2018.
 */

public interface ApiInterface {



    //userlist with parameter , if more thn one paramters are required thn use Ex: @QueryMap Map<String,String> options
   // @GET("/api/users?")
    @GET("/v1/ticker/?")
    Call<List<CryptoModel>> getCryptoList(@Query("limit") int page);


}

