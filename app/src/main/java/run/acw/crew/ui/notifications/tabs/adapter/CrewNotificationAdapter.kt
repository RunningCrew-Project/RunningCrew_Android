package run.acw.crew.ui.notifications.tabs

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import run.acw.runningcrew.databinding.RecyclerViewItemCrewNotificationBinding

class CrewNotificationAdapter(
    diffUtil: DiffUtil.ItemCallback<String>
) : ListAdapter<String, CrewNotificationHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewNotificationHolder {
        val binding = RecyclerViewItemCrewNotificationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CrewNotificationHolder(binding)
    }

    override fun onBindViewHolder(holder: CrewNotificationHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CrewNotificationHolder(private val binding: RecyclerViewItemCrewNotificationBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) {
    }
}