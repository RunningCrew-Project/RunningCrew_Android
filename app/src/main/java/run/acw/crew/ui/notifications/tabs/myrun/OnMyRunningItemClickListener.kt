package run.acw.crew.ui.notifications.tabs.myrun

import run.acw.runningcrew.databinding.RecyclerViewItemMyRunningNotificationBinding

interface OnMyRunningItemClickListener  {
    fun onItemClicked(item:RecyclerViewItemMyRunningNotificationBinding)
    //휴대전화의 현재 시간을 받아서 recycler view item에 설정된 시간과 비교해야함.
    //binding을 받아서 처리해도 괜찮을 거 같음.
}