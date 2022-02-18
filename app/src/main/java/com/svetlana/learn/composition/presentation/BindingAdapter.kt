package com.svetlana.learn.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.svetlana.learn.composition.R
import com.svetlana.learn.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, percent: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        percent
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult.countOfQuestions, gameResult.countOfRightAnswers)
    )
}

@BindingAdapter("isWinner")
fun bindIsWinner(imageView: ImageView, isWinner: Boolean) {
    imageView.setImageResource(getSmileResId(isWinner))
}

private fun getSmileResId(isWinner: Boolean) = if (isWinner) {
    R.drawable.ic_smile
} else {
    R.drawable.ic_sad
}

private fun getPercentOfRightAnswers(countOfQuestions: Int, countOfRightAnswers: Int) =
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
