package maverick.provbattle.com.probattle.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CryptoModel {

    String id;
    String name;
    String symbol;
    String rank;
    String price_usd;
    String price_btc;
    @SerializedName("24h_volume_usd")
    String volume_usd;
    String market_cap_usd;
    String available_supply;
    String total_supply;
    String percent_change_1h;
    String percent_change_24h;
    String percent_change_7d;
    String last_updated;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public String getPrice_btc() {
        return price_btc;
    }

    public String getVolume_usd() {
        return volume_usd;
    }

    public String getMarket_cap_usd() {
        return market_cap_usd;
    }

    public String getAvailable_supply() {
        return available_supply;
    }

    public String getTotal_supply() {
        return total_supply;
    }

    public String getPercent_change_1h() {
        return percent_change_1h;
    }

    public String getPercent_change_24h() {
        return percent_change_24h;
    }

    public String getPercent_change_7d() {
        return percent_change_7d;
    }

    public String getLast_updated() {
        return last_updated;
    }
}
