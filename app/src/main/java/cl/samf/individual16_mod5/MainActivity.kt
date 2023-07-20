package cl.samf.individual16_mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.samf.individual16_mod5.databinding.ActivityMainBinding

/* Pasos para crear un recycler view
* [] item layout
*   [] agregar constraints
*   [] cambiar altura de constraints layout de item layout a wrap content
*   [] definir ID
* [] layout con recycler view
* [] asignar layout manager
[] implementar clase Adapter
[]  heredar RecyclerView.Adapter
[] creaciones de los métodos: onCreateViewHolder, getItemCount y onBindViewHolder
[] crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[] Agregar constructor
[] crear objeto, data class
[] Crear lista
[] asignar tamaño de la lista en getItemCount
[] definir Binding Class del Item
[] cambiar view por el binding
[] declarar variable item en onBindViewHolder
[] implementar binding en clase viewHolder
 */
/* [] Adapter+ view holder
* [] obtener los datos
* /*

* */
* */
class MainActivity : AppCompatActivity(), AdapterPaises.PaisCallBack {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapterPaises = AdapterPaises()
        adapterPaises.setData(PaisesLatam.paises)
        adapterPaises.setPaisCallBack(this)
        binding.recyclerView.adapter = adapterPaises

    }

    override fun showPais(s: String) {
        binding.textViewMostrarInfo.text = s
    }

}