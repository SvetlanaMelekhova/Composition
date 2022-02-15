package com.svetlana.learn.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.svetlana.learn.composition.R
import com.svetlana.learn.composition.databinding.FragmentGameBinding
import com.svetlana.learn.composition.domain.entity.GameResult
import com.svetlana.learn.composition.domain.entity.GameSettings
import com.svetlana.learn.composition.domain.entity.Level

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    private lateinit var level: Level

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvSum.setOnClickListener {
                launchGameFinishFragment(
                    GameResult(
                        winner = false,
                        countOfRightAnswers = 5,
                        countOfQuestions = 5,
                        gameSettings = GameSettings(0, 0, 0, 0)
                    )
                )
            }
        }
    }

    private fun launchGameFinishFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        level = requireArguments().getSerializable(KEY_LEVEL) as Level
    }

    companion object {

        private const val KEY_LEVEL = "key_level"
        const val NAME = "game_fragment"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_LEVEL, level)
                }
            }
        }
    }
}