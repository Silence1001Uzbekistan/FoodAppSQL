package uz.silence.foodappsql.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.silence.foodappsql.CLASS.Food
import uz.silence.foodappsql.databinding.RvItemBinding

class RvAdapter(var list: ArrayList<Food>, var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItemBinding) : RecyclerView.ViewHolder(rvItemBinding.root) {

        fun onBind(food: Food, position: Int) {

            rvItemBinding.nameItem.text = food.foodName

            rvItemBinding.root.setOnClickListener {

                onItemClickListener.onItemClick(food, position)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {

        fun onItemClick(food: Food, position: Int)

    }

}