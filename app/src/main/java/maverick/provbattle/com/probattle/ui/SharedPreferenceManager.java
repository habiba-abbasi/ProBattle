package maverick.provbattle.com.probattle.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import maverick.provbattle.com.probattle.ui.model.CryptoModel;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Habiba Abbasii on 31/03/2018.
 */

public class SharedPreferenceManager {
    static String PREFERNCE_NAME="CRYPTO_DETAIL";

    public static void putDetailsInShared(Context context,String json){

        SharedPreferences.Editor editor =context.getSharedPreferences(PREFERNCE_NAME, MODE_PRIVATE).edit();

        editor.putString("crypto",json);
        editor.apply();
    }

    public static ArrayList<CryptoModel> getDetails(Context context){

        ArrayList<CryptoModel> list=new ArrayList<>();
        String jsonList=null;

        SharedPreferences prefs = context.getSharedPreferences(PREFERNCE_NAME, MODE_PRIVATE);
         jsonList = prefs.getString("crypto", null);

        if (jsonList != null) {
           jsonList = prefs.getString("crypto", "No name defined");//"No name defined" is the default value.
        }

        list=new Gson().fromJson(jsonList, new TypeToken<ArrayList<CryptoModel>>(){}.getType());

        return list;
    }
}
