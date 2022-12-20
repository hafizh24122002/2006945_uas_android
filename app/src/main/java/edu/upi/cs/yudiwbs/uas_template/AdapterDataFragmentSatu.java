package edu.upi.cs.yudiwbs.uas_template;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDataFragmentSatu extends RecyclerView.Adapter<ViewHolderData> {
    ArrayList<DataModelFragmentSatu> data;

    public AdapterDataFragmentSatu(ArrayList<DataModelFragmentSatu> data) { this.data = data; }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_fragment_satu_row, parent, false);
        return new ViewHolderData(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        DataModelFragmentSatu m = data.get(position);
        String text = m.getType() + "\n" + m.getActivity();
        holder.tvType.setText(text);
    }

    @Override
    public int getItemCount() { return data.size(); }
}
