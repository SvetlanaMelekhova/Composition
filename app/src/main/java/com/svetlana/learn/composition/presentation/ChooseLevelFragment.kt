package com.svetlana.learn.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.svetlana.learn.composition.R
import com.svetlana.learn.composition.databinding.FragmentChooseLevelBinding
import com.svetlana.learn.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonLevelTest.setOnClickListener {
                launchFragment(Level.TEST)
            }

            buttonLevelEasy.setOnClickListener {
                launchFragment(Level.EASY)
            }

            buttonLevelNormal.setOnClickListener {
                launchFragment(Level.NORMAL)
            }

            buttonLevelHard.setOnClickListener {
                launchFragment(Level.HARD)
            }
        }
    }

    private fun launchFragment(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
                level
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}