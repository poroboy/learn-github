package com.example.finalproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private List<Service> serviceList;

    public ServiceAdapter(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_service, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        Service service = serviceList.get(position);
        holder.bind(service);
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgService;
        private Button btnBuyPolicy;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgService = itemView.findViewById(R.id.imgService);
            btnBuyPolicy = itemView.findViewById(R.id.btnBuyPolicy);
        }

        public void bind(Service service) {
            txtName.setText(service.getName());
            txtDescription.setText(service.getDescription());
            imgService.setImageResource(service.getImageResourceId());

            btnBuyPolicy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Service selectedService = serviceList.get(position);

                    Intent intent = new Intent(itemView.getContext(), BuyPolicyActivity.class);
                    intent.putExtra("serviceName", selectedService.getName());
                    intent.putExtra("serviceDescription", selectedService.getDescription());
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
