package id.web.muhammadibrahim.myindago.menu.main.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.web.muhammadibrahim.myindago.R
import id.web.muhammadibrahim.myindago.menu.main.viewmodels.FragmentProfileViewModel

class FragmentProfile : Fragment() {

    companion object {
        fun newInstance() = FragmentProfile()
    }

    private lateinit var viewModel: FragmentProfileViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
