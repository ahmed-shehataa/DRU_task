package com.ashehata.dru.common.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ashehata.dru.R
import com.ashehata.dru.common.models.NetworkError

@Composable
fun NetworkErrorUI(networkError: NetworkError, onTryClicked: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(id = networkError.messageRes))

            Button(onClick = { onTryClicked() }) {
                Text(stringResource(R.string.try_gain))

            }
        }
    }
}