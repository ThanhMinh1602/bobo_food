package com.example.myapplication.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

private const val ARG_TITLE = "title_param"
private const val ARG_DESCRIPTION = "description_param"
private const val ARG_IMAGE = "image_param"

class OnboardingPageFragment : Fragment() {
    private var pageTitle: String? = null
    private var pageDescription: String? = null
    private  var pageImage : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pageTitle = it.getString(ARG_TITLE)
            pageDescription = it.getString(ARG_DESCRIPTION)
            pageImage = it.getInt(ARG_IMAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvTitle: TextView =  view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val imgOnboading: ImageView = view.findViewById(R.id.onboardImage)
        tvTitle.text = pageTitle
        tvDescription.text = pageDescription
        if(pageImage != 0){
            imgOnboading.setImageResource(pageImage)
        }
    }
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(title: String, description: String, pageImage: Int) =
            OnboardingPageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_DESCRIPTION, description)
                    putInt(ARG_IMAGE, pageImage)
                }
            }
    }
}