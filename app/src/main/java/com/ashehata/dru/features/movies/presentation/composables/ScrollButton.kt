package com.ashehata.dru.features.movies.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ScrollButton(
    modifier: Modifier,
    isVisible: Boolean,
    onClicked: () -> Unit,
    icon: ImageVector
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = isVisible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        IconButton(modifier = Modifier
            .clip(CircleShape)
            .background(Color.White),
            onClick = {
                onClicked()
            }) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}