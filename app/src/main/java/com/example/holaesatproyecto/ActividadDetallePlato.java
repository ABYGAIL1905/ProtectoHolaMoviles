package com.example.holaesatproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.holaesatproyecto.modelo.Producto;

public class ActividadDetallePlato extends AppCompatActivity {
   //// DETALEEEEEEEEEEEEEEEEEEEEEE
    private Producto producto;
    ImageView imagenVer;
    TextView txtnombre ,txtdescripcion,txtprecio, txtstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);
        imagenVer=findViewById(R.id.imagen_detalleid);
        txtnombre=findViewById(R.id.textdetallenombrePlato);
        txtdescripcion=findViewById(R.id.textdetalle_descripcion);
        txtprecio=findViewById(R.id.textdetallle_precio);
        txtstock=findViewById(R.id.textdetalle_stock);


    }

    public void iniciarActividad(){
        producto= (Producto) getIntent().getExtras().getSerializable("itemDetalle");//mismo nombre que el adapter
        imagenVer.setImageResource(producto.getFoto());/// FOTO EN  TIPO INT PASAR A STRING
        txtnombre.setText(producto.getNombre());
        txtdescripcion.setText(producto.getDescripcion());



    }
}