package com.example.foodapp.model

import com.example.foodapp.R

enum class ImageButtonType(val resId: Int) {
    SELECTED(R.drawable.ic_round_star_24),
    UNSELECTED(R.drawable.ic_round_star_border_24);

    fun changeType(): ImageButtonType {
        return if (this == UNSELECTED) {
            SELECTED
        } else {
            UNSELECTED
        }
    }
}