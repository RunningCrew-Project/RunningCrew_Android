package run.acw.crew.ui.notifications.tabs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import run.acw.crew.setOnClick
import run.acw.crew.ui.notifications.tabs.myrun.OnMyRunningItemClickListener
import run.acw.runningcrew.databinding.RecyclerViewItemCrewNotificationBinding
import run.acw.runningcrew.databinding.RecyclerViewItemMyRunningNotificationBinding

class MyRunningNotificationAdapter (diffUtil: DiffUtil.ItemCallback<String>
,private val onClick:OnMyRunningItemClickListener) : ListAdapter<String, MyRunningNotificationHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRunningNotificationHolder {
        val binding = RecyclerViewItemMyRunningNotificationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener{onClick.onItemClicked(binding)}
        return MyRunningNotificationHolder(binding)
    }

    override fun onBindViewHolder(holder: MyRunningNotificationHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class MyRunningNotificationHolder(private val binding: RecyclerViewItemMyRunningNotificationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
    }
}