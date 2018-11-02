package id.web.muhammadibrahim.khobar.menu.main.views.fragments

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*

import id.web.muhammadibrahim.khobar.R
import id.web.muhammadibrahim.khobar.databinding.FragmentUniversityBinding
import id.web.muhammadibrahim.khobar.menu.main.views.activities.MainActivity

class UniversityFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = UniversityFragment()
    }

    lateinit var binding: FragmentUniversityBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_university, container, false)
        return binding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ((activity as AppCompatActivity) as MainActivity).setupToolbar("University")
        ((activity as AppCompatActivity) as MainActivity).getBottomNavigation().visibility = View.GONE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
