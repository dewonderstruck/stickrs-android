package com.dewonderstruck.apps.stickrs


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dewonderstruck.apps.stickrs.Bean.StickersBean
import com.dewonderstruck.apps.stickrs.adapter.StickerPackPreviewAdapter
import com.dewonderstruck.apps.stickrs.adapter.StickersAdapter
import com.dewonderstruck.apps.stickrs.lib.advancedsupport.ads.admob_advanced_native_recyvlerview.AdmobNativeAdAdapter
import com.firebase.ui.database.paging.DatabasePagingOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var firstViewModel: FirstViewModel
    private var recyclerView: RecyclerView? = null
    private var adapter: StickersAdapter? = null
    private var adapterr: StickerPackPreviewAdapter? = null
    private var layoutManager: GridLayoutManager? = null
    private var prg: ProgressBar? = null

    //    private var touchListener: StickerRolloverTouchListener? = null
    var mbase: DatabaseReference? = null
    private var stickerList: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firstViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_first, container, false)
        val viewModel: FirstViewModel = ViewModelProvider(this).get(firstViewModel::class.java)
        val liveData: LiveData<DataSnapshot?> = viewModel.getDataSnapshotLiveData()
        prg = root.findViewById(R.id.progressBar2)
        liveData.observe(requireActivity(),
            { databaseref ->
                if (databaseref != null) {
                    val title = databaseref.child("author").getValue(String::class.java)
                    disclamieranim.visibility = View.GONE
                } else {
                    Log.d("FirebaseD:", "connection-error")
                    prg?.visibility = View.VISIBLE
                }
            })
        recyclerView = root.findViewById(R.id.rvlist)
        val mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.reverseLayout = true
        mLayoutManager.stackFromEnd = true
        val linearLayoutManager = object : LinearLayoutManager(activity, VERTICAL, true)
        {
            override fun onLayoutCompleted(state: RecyclerView.State?)
            {
                super.onLayoutCompleted(state)
                prg?.visibility = View.GONE
                disclamieranim.visibility = View.VISIBLE
                }
        }
        recyclerView!!.layoutManager = linearLayoutManager
        mbase = FirebaseDatabase.getInstance("https://production-stickrs-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("manifest")
        Log.d("FirebaseD:", mbase!!.toString())
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPrefetchDistance(10)
            .setPageSize(20)
            .build()
        val options: DatabasePagingOptions<StickersBean> = DatabasePagingOptions.Builder<StickersBean>()
            .setLifecycleOwner(this)
            .setQuery(mbase!!, config, StickersBean::class.java)
            .build()
        adapter = StickersAdapter(options)
        this.layoutManager = GridLayoutManager(requireContext(), 2)
        stickerList = root.findViewById<RecyclerView>(R.id.sticker_install_list);
        stickerList?.setLayoutManager(layoutManager);
        val admobNativeAdAdapter: AdmobNativeAdAdapter = AdmobNativeAdAdapter.Builder.with(
            "ca-app-pub-9530431913684433/9401300966",  //admob native ad id
            adapter,  //current adapter
            "small" //Set the size "small", "medium" or "custom"
        ).adItemInterval(4) //Repeat interval
            .build()
        recyclerView?.adapter = admobNativeAdAdapter
        recyclerView?.setItemAnimator(null);
        stickerList?.setAdapter(adapterr);
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter!!.startListening()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (adapter != null) {
            adapter!!.stopListening()
       }
    }



}


