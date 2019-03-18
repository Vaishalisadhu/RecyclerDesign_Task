package a.com.recyclerdesign;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {


    private Context mCtx;

    private List<DataModel> dataModelList;

    public DataAdapter(Context mCtx, List<DataModel> dataModelList) {

        this.mCtx = mCtx;
        this.dataModelList = dataModelList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_items, null);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);


        if(dataModel.getTitle().equalsIgnoreCase("HDFC")){

            holder.linMain.setBackground(ContextCompat.getDrawable(mCtx,R.drawable.border));
            }
            else {
            holder.linMain.setBackground(ContextCompat.getDrawable(mCtx,R.drawable.border_blue));
        }
        holder.bankName.setText(dataModel.getTitle());
        holder.amount.setText(String.format("Rs.%s.00", dataModel.getPrice()));
        holder.finalAmount.setText(String.format("Rs.%s.00", dataModel.getPrice()));
        /*holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(dataModel.getImage()));*/
        Picasso.with(mCtx)
                .load(dataModel.getImage())
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }


    class DataViewHolder extends RecyclerView.ViewHolder {

        TextView bankName, amount, finalAmount;
        ImageView imageView;
        LinearLayout linMain;

        public DataViewHolder(View itemView) {
            super(itemView);

            bankName = itemView.findViewById(R.id.bankName);
            amount = itemView.findViewById(R.id.amount);
            finalAmount = itemView.findViewById(R.id.finalAmount);
            imageView = itemView.findViewById(R.id.imageView);
            linMain = itemView.findViewById(R.id.linMain);
        }
    }
}