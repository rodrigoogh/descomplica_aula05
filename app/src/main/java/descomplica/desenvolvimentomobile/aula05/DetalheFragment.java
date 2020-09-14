package descomplica.desenvolvimentomobile.aula05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetalheFragment extends Fragment {

    static DetalheFragment newInstance() {
        return new DetalheFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhe, container, false);

        Curso curso = (Curso) getArguments().getSerializable("CURSO");

        ((TextView) view.findViewById(R.id.nome)).setText(curso.getNome());
        ((TextView) view.findViewById(R.id.periodo)).setText(curso.getPeriodo());
        ((TextView) view.findViewById(R.id.descricao)).setText(curso.getDescricao());

        return view;
    }
}
