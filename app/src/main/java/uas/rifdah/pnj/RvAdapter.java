package uas.rifdah.pnj;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uas.rifdah.pnj.model.Bunga;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private List<Bunga> dataList = new ArrayList<>();
    private onViewClick listener;

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        Bunga data = dataList.get(position);
        holder.tvNamaBunga.setText(data.getNama());
        holder.tvNamaLatin.setText(data.getNama_latin());
        holder.tvAsalBunga.setText(data.getAsal());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamaBunga, tvNamaLatin, tvAsalBunga;

        public ViewHolder( View itemView){
            super(itemView);
            tvNamaBunga = itemView.findViewById(R.id.nama_bunga);
            tvNamaLatin = itemView.findViewById(R.id.nama_latin);
            tvAsalBunga = itemView.findViewById(R.id.asal_bunga);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onViewClick(getAdapterPosition());
                }
            });
        }
    }

    public void setDataList(List<Bunga> list ){
        this.dataList = list;
        notifyDataSetChanged();
    }

    public void clearDataList(List<Bunga> list ){
        this.dataList = list;
        dataList.clear();
    }

    public interface onViewClick{
        void onViewClick(int position);
    }

    public  void setOnClickListener(onViewClick listener){
        this.listener = listener;
    }
}
