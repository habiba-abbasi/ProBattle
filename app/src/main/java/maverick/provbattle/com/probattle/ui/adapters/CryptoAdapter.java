package maverick.provbattle.com.probattle.ui.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import maverick.provbattle.com.probattle.R;
import maverick.provbattle.com.probattle.databinding.CryptoItemBinding;
import maverick.provbattle.com.probattle.ui.model.CryptoModel;



public class CryptoAdapter  extends RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>{

    List<CryptoModel> list;

   public CryptoAdapter(List<CryptoModel> list){
        this.list=list;
    }
    @Override
    public CryptoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CryptoItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.crypto_item,parent,false);

        return new CryptoViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(CryptoViewHolder holder, int position) {

        holder.setItem(list.get(position),position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CryptoViewHolder extends RecyclerView.ViewHolder{

        CryptoItemBinding binding;

        public CryptoViewHolder(CryptoItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void setItem(CryptoModel model,int position){

            //setting items
            binding.name.setText(model.getName());
            binding.symbol.setText(model.getSymbol());
            binding.rank.setText(model.getRank());
            binding.priceInUSD.setText(model.getPrice_usd());
            binding.priceINBTc.setText(model.getPrice_btc());
            binding.availableSupply.setText(model.getAvailable_supply());
            binding.totalSupply.setText(model.getTotal_supply());
        }
    }
}
