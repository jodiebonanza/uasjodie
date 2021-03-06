package com.example.uasjodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private ArrayList<Menu> menus;
    private  onitiemClickListener mListener;

    public interface onitiemClickListener{
        void onItemClick(int position );
    }
    public void setonItemClickListener(onitiemClickListener listener){
        mListener =listener;
}
    public MenuAdapter(Context mcontext, ArrayList<Menu>menuonepiece){
        context=mcontext;
        menus=menuonepiece;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menubaru= menus.get(position);
        String gambarbaru =menubaru.getGambar();
        String jabatan=menubaru.getJabatan();
        String nama=menubaru.getNama();

        holder.tvnamadata.setText(nama);
        holder.tvjabatandata.setText(jabatan);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.imdata);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends  RecyclerView.ViewHolder {
        public ImageView imdata;
        public TextView tvjabatandata;
        public TextView tvnamadata;
        public Button btndetail;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
    imdata=itemView.findViewById(R.id.img_menu);
    tvjabatandata=itemView.findViewById(R.id.tv_jabatan);
    tvnamadata=itemView.findViewById(R.id.tv_nama);
    btndetail=itemView.findViewById(R.id.btn_detail);

            btndetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick((position));
                        }
                    }
                }
            });
        }
    }
}
