package cl.samf.individual16_mod5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.samf.individual16_mod5.databinding.ItemBinding
import coil.load

class AdapterPaises : RecyclerView.Adapter <AdapterPaises.ViewHolder>() {

    var paises = mutableListOf<Pais>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPaises.ViewHolder {
       var binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPaises.ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    fun setData(listaPaises: List<Pais>){
        this.paises = listaPaises.toMutableList()
    }

    class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pais: Pais){
            binding.textViewItem.text = pais.nombre
            binding.imageViewId.load(pais.imgUrl)
        }
    }
}