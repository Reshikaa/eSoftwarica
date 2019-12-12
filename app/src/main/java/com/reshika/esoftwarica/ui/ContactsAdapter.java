package com.reshika.esoftwarica.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reshika.esoftwarica.R;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

    Context mContext;
    List<Contacts> contactsList;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList){
        this.mContext=mContext;
        this.contactsList=contactsList;
    }


    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_contacts,parent,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactsViewHolder holder, final int position) {

        final Contacts contacts=contactsList.get(position);

        holder.imgprofile.setImageResource(contacts.getImageId());
        holder.tvName.setText(contacts.getName());
        holder.tvAge.setText(contacts.getAge());
        holder.tvAddress.setText(contacts.getAddress());
        holder.tvGender.setText(contacts.getGender());
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.delete));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacts con =contactsList.get(position);
                contactsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,contactsList.size());

            }
        });

        String gender=contacts.getGender();

        if(gender=="Male")
        {
            holder.imgprofile.setImageResource(R.drawable.male);
        }

        else if (gender=="Female")
        {
            holder.imgprofile.setImageDrawable(mContext.getResources().getDrawable(R.drawable.female));
        }

        else if (gender=="Others") {
            holder.imgprofile.setImageDrawable(mContext.getResources().getDrawable(R.drawable.others));

        }

        holder.imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Hello!!This is :"+ contacts.getName() , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        ImageView imgprofile,imageView;
        TextView tvGender;
        TextView tvName,tvAge,tvAddress;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgprofile=itemView.findViewById(R.id.imgprofile);
            tvName=itemView.findViewById(R.id.tvName);
            tvAge=itemView.findViewById(R.id.tvAge);
            tvAddress=itemView.findViewById(R.id.tvAddress);
            tvGender=itemView.findViewById(R.id.tvGender);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
