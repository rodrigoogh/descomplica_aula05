package descomplica.desenvolvimentomobile.aula05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CursoListFragment.OnListSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,
                    CursoListFragment.newInstance(),
                    "cursoListFragment").commit();
        }
    }

    @Override
    public void onSelected(Curso curso) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("CURSO", curso);

        DetalheFragment detalheFragment = DetalheFragment.newInstance();
        detalheFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, detalheFragment, "detalheFragment")
                .addToBackStack(null)
                .commit();
    }
}