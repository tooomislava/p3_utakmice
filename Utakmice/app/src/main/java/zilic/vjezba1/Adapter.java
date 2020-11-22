package zilic.vjezba1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Red> {

    private List<Utakmica> utakmice;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;

    public Adapter(Context context){
        layoutInflater = LayoutInflater.from(context);
        utakmice=new ArrayList<>();
    }

    public void setUtakmice(List<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

    @NonNull
    @Override
    public Red onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.red_layout, parent, false);
        return new Red(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Red holder, int position) {
        Utakmica u = this.utakmice.get(position);
        holder.domacin.setText(u.getDomacin());
        holder.gost.setText(u.getGost());
    }

    @Override
    public int getItemCount() {
        return this.utakmice==null ? 0 : this.utakmice.size();
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView domacin;
        private TextView gost;

        public Red(@NonNull View itemView) {
            super(itemView);
            domacin = itemView.findViewById(R.id.domacin);
            gost = itemView.findViewById(R.id.gost);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null){
                itemClickListener.onItemClick(utakmice.get(getAdapterPosition()));
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(Utakmica utakmica);
    }

}
