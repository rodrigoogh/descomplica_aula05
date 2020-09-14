package descomplica.desenvolvimentomobile.aula05;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class CursoListFragment extends Fragment {

    private CursoListFragment.OnListSelected listener;
    private String[] nomes;
    private String[] descricoes;
    private String[] periodos;

    static CursoListFragment newInstance() {
        return new CursoListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        Context context = getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new CursoListAdapter());

        return recyclerView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Resources resources = context.getResources();
         nomes = resources.getStringArray(R.array.cursos);
         periodos = resources.getStringArray(R.array.periodos);
         descricoes = resources.getStringArray(R.array.descricoes);

        if (context instanceof CursoListFragment.OnListSelected) {
            listener = (CursoListFragment.OnListSelected) context;
        }

    }

    public interface OnListSelected {
        void onSelected(Curso curso);
    }

    public class CursoListAdapter extends RecyclerView.Adapter<CursoListAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CursoListAdapter.ViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_lista, parent, false));

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Curso curso = new Curso(
                    nomes[position],
                    periodos[position],
                    descricoes[position]
            );

            holder.bind(curso);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSelected(curso);
                }
            });
        }

        @Override
        public int getItemCount() {
            return nomes.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(@NotNull View itemView) {
                super(itemView);
            }

            public void bind(Curso curso) {
                ((ImageView) itemView.findViewById(R.id.lista_icone)).setImageResource(R.drawable.descomplica_logo_thumb);
                ((TextView) itemView.findViewById(R.id.lista_nome)).setText(curso.getNome());
            }
        }
    }
}
