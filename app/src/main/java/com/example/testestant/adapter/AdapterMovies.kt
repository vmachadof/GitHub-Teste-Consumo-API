import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testestant.model.Items
import com.example.testestant.model.ItensViewHolder
import com.example.testestant.R

class AdapterMovies : RecyclerView.Adapter<ItensViewHolder>() {

    private var items = listOf<Items>()

    fun updateItems(newItems: List<Items>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_main, parent, false)

        return ItensViewHolder(view)
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ItensViewHolder, position: Int) {
        holder.bind(items[position])
    }
}


