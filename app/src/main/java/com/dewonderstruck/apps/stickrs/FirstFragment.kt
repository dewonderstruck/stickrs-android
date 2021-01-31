package com.dewonderstruck.apps.stickrs


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dewonderstruck.apps.stickrs.Bean.StickersBean
import com.dewonderstruck.apps.stickrs.adapter.StickerPackPreviewAdapter
import com.dewonderstruck.apps.stickrs.adapter.StickersAdapter
import com.dewonderstruck.apps.stickrs.glide.cache.ApngOptions
import com.dewonderstruck.apps.stickrs.util.DecryptableStreamUriLoader.DecryptableUri
import com.dewonderstruck.apps.stickrs.util.Optional
import com.dewonderstruck.apps.stickrs.util.StickerManifest
import com.dewonderstruck.apps.stickrs.util.StickerManifest.Sticker
import com.dewonderstruck.apps.stickrs.util.StickerRemoteUri
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.common.util.DeviceProperties
import com.google.firebase.database.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var firstViewModel: FirstViewModel
    private var recyclerView: RecyclerView? = null
    private var adapter: StickersAdapter? = null
    private var adapterr: StickerPackPreviewAdapter? = null
    private var layoutManager: GridLayoutManager? = null

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
        liveData.observe(requireActivity(),
            { databaseref ->
                if (databaseref != null) {
                    val title = databaseref.child("author").getValue(String::class.java)

                } else {
                    Log.d("FirebaseD:", "connection-error")
                }
            })

        recyclerView = root.findViewById(R.id.rvlist)
        recyclerView!!.layoutManager = LinearLayoutManager(requireContext())
        mbase =
            FirebaseDatabase.getInstance("https://production-stickrs-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("manifest")
        Log.d("FirebaseD:", mbase!!.toString())
        val options: FirebaseRecyclerOptions<StickersBean> =
            FirebaseRecyclerOptions.Builder<StickersBean>()
                .setQuery(mbase!!.limitToFirst(5), StickersBean::class.java).setLifecycleOwner(
                    this
                )
                .build()
        adapter = StickersAdapter(options)
        recyclerView?.adapter = adapter
        this.layoutManager = GridLayoutManager(requireContext(), 2)
//        this.touchListener = StickerRolloverTouchListener(this, GlideApp.with(this), this, this)
//        onScreenWidthChanged(getScreenWidth())
        stickerList = root.findViewById<RecyclerView>(R.id.sticker_install_list);
        stickerList?.setLayoutManager(layoutManager);
        //stickerList?.addOnItemTouchListener(touchListener);
        stickerList?.setAdapter(adapterr);
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        if (adapter != null) {
            adapter!!.stopListening()
        }
    }
}


