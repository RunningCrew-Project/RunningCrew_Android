package run.acw.crew.ui.notifications.tabs.myrun


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import run.acw.crew.ui.notifications.tabs.adapter.MyRunningNotificationAdapter
import run.acw.crew.util.OnMyRunningItemClickedSnackBar
import run.acw.runningcrew.databinding.NotificationTabMyRunningBinding


class NotificationTabMyRunning : Fragment() {
    private var _binding: NotificationTabMyRunningBinding? = null
    private val binding get() = _binding!!
    private val myRunningViewModel by lazy {
        ViewModelProvider(this).get(NotificationTabMyRunningViewModel::class.java)
    }
    private var snackBar:OnMyRunningItemClickedSnackBar?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG,"onCreateView")

        _binding = NotificationTabMyRunningBinding.inflate(inflater, container, false)
        val root: View = binding.root
        myRunningViewModel.earlyMsg.observe(viewLifecycleOwner) { msgId ->
         //   snackBar=OnMyRunningItemClickedSnackBar.make(root, getString(msgId))
         //   snackBar?.show()
            Toast.makeText(context,"qwd",Toast.LENGTH_SHORT).show()
        }



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onView")
        binding.tabMyRunningRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MyRunningNotificationAdapter(
                diffUtil,
                myRunningViewModel
            ).apply { submitList(List(5) { "" }) }
        }

    }
    override fun onDestroyView() {
        snackBar?.delSnackBar()
        myRunningViewModel.earlyMsg.removeObservers(viewLifecycleOwner)
        myRunningViewModel.resetMsg()
        super.onDestroyView()
    }



    companion object {
        val TAG = "NotificationTabMyRunning"
        private val diffUtil = object : DiffUtil.ItemCallback<String>() {
            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem
        }
    }
}