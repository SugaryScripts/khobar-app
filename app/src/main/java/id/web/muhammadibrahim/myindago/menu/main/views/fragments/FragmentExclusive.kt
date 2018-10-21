package id.web.muhammadibrahim.myindago.menu.main.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentExclusiveViewModel

class FragmentExclusive : Fragment() {

    companion object {
        fun newInstance() = FragmentExclusive()
    }

    private lateinit var viewModel: FragmentExclusiveViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exclusive, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentExclusiveViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
