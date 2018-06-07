package br.com.raniel.ceep.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.raniel.ceep.R;
import br.com.raniel.ceep.dao.NotaDAO;
import br.com.raniel.ceep.model.Nota;
import br.com.raniel.ceep.ui.recyclerViewAdapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recycleview);

        NotaDAO dao = new NotaDAO();

        for(int i = 1; i <= 1000; i++) {
            dao.insere(new Nota("nota " + i,
                    "descrição " + i));
        }

        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));

        LinearLayoutManager manager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(manager);
    }
}
