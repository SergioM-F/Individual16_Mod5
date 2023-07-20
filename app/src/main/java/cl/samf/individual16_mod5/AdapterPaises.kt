package cl.samf.individual16_mod5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cl.samf.individual16_mod5.databinding.ItemBinding
import coil.load
import okhttp3.Callback

class AdapterPaises : RecyclerView.Adapter <AdapterPaises.ViewHolder>() {

    var paises = mutableListOf<Pais>()
    var callBack: PaisCallBack ?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPaises.ViewHolder {
        var binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPaises.ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    fun setData(listaPaises: List<Pais>) {
        this.paises = listaPaises.toMutableList()
    }

    inner class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pais) {
            binding.textViewItem.text = item.nombre
            binding.imageViewId.load(item.imgUrl)
            binding.cardViewid.setOnClickListener(View.OnClickListener {
            val texto = "Pais:${item.nombre} Poblacion:${item.poblacion}"
                callBack?.showPais(texto)
            })
        }
    }
    interface PaisCallBack{
        fun showPais(s: String)
    }
}