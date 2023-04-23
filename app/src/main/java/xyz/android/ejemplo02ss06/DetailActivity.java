package xyz.android.ejemplo02ss06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xyz.android.ejemplo02ss06.model.Persona;

public class DetailActivity extends AppCompatActivity {
    TextView txtSelectedItem, txtSelectedEdad;
    ImageView imageViewPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtSelectedItem = findViewById(R.id.txt_selected_item);
        txtSelectedEdad = findViewById(R.id.txt_selected_edad);
        imageViewPerfil = findViewById(R.id.imageViewPerfil);

        // Obtener el objeto Persona seleccionado del Intent
        Persona selectedItem = (Persona) getIntent().getSerializableExtra("selectedItem");

        // Mostrar los detalles de la persona seleccionada en la actividad de detalle
        txtSelectedItem.setText(selectedItem.getNombre());
        txtSelectedEdad.setText(String.valueOf(selectedItem.getEdad()));

        imageViewPerfil = findViewById(R.id.imageViewPerfil);
        String imageUrl = selectedItem.getPerfil();
        Picasso.get().load(imageUrl).fit().centerCrop().into(imageViewPerfil);
    }
}