package xyz.android.ejemplo02ss06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import xyz.android.ejemplo02ss06.model.Persona;

public class MyListAdapter extends ArrayAdapter<Persona> {

    private final Context context;
    private final List<Persona> listaPersonas;

    public MyListAdapter(Context context, int resource, List<Persona> listaPersonas) {
        super(context, resource, listaPersonas);
        this.context = context;
        this.listaPersonas = listaPersonas;
    }

    @Override
    public int getCount() {
        return listaPersonas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtItem = rowView.findViewById(R.id.txt_item);
        txtItem.setText(String.format("%s - %s", listaPersonas.get(position).getNombre(), listaPersonas.get(position).getEdad()));

        return rowView;
    }
}
