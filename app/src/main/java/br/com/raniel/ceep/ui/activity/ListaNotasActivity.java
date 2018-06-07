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

        List<Nota> todasNotas = notasDeExemplo();
        configuraRecyclerView(todasNotas);
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();

        for(int i = 1; i <= 1000; i++) {
            dao.insere(new Nota("nota " + i,
                    "descrição " + i));
        }

        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recycleview);
        configuraAdapter(todasNotas, listaNotas);
//        configuraLayoutManager(listaNotas); //configura o layoutmanager por codigo, porém pode-se configurar direito no xml quando ele for fixo com app:layoutManager
//                                              para colocar um gridlayout adiciona-se o app:spanCount para definir o numero de colunas
    }

    private void configuraLayoutManager(RecyclerView listaNotas) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(manager);
    }

    private void configuraAdapter(List<Nota> todasNotas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}
