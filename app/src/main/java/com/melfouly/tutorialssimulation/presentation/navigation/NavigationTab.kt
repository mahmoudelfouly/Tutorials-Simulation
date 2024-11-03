package com.melfouly.tutorialssimulation.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.melfouly.tutorialssimulation.R

enum class NavigationTab(
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    HOME(R.string.home, R.drawable.ic_home),
    CONNECT(R.string.connect, R.drawable.ic_connecter),
    QUESTIONS(R.string.questions, R.drawable.ic_questions),
    TOOLS(R.string.tools, R.drawable.ic_tools),
    PROFILE(R.string.profile, R.drawable.ic_profile)
}