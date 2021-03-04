package br.com.isomano.mycalendar.view.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.isomano.mycalendar.R
import br.com.isomano.mycalendar.databinding.FragmentEventsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsFragment : Fragment(R.layout.fragment_events){

    private val viewModel by viewModels<EventsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEventsBinding.bind(view)

        binding.apply {
            textviewFirst.setOnClickListener { viewModel.rollNextEvent() }
        }

        viewModel.currentEvent.observe(viewLifecycleOwner){
            binding.textviewFirst.text = it.description
        }
    }

}