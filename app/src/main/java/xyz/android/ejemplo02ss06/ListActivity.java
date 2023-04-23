package xyz.android.ejemplo02ss06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.android.ejemplo02ss06.model.Persona;

public class ListActivity extends AppCompatActivity {
    private List<Persona> personas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        personas.add(new Persona("Juan Pedro", 30, "https://picsum.photos/id/118/1500/1000"));
        personas.add(new Persona("Ana Dina", 25, "https://picsum.photos/id/124/3504/2336"));
        personas.add(new Persona("Pedro Pablo", 40, "https://picsum.photos/id/127/4032/2272"));
        personas.add(new Persona("María Sol", 35, "https://picsum.photos/id/129/4910/3252"));

        ListView listView = findViewById(R.id.list_view);
        TextView emptyView = findViewById(R.id.lista_vacia);

        MyListAdapter adapter = new MyListAdapter(this, R.layout.list_item, personas);
        listView.setAdapter(adapter);

        // Verificación de si la lista está vacía
        if (personas.isEmpty()) {
            listView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            listView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona personaSeleccionada = (Persona) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("selectedItem", personaSeleccionada);
                startActivity(intent);

            }
        });
    }
}