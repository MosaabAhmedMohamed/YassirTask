package com.example.yassirtask

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.example.presentation.base.IGlobalState
import com.example.yassirtask.composables.DefaultMessageDialog
import com.example.yassirtask.composables.Error
import com.example.yassirtask.composables.Progress
import com.example.yassirtask.features.NavGraphs
import com.example.yassirtask.theme.YassirComposeTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun App(globalState: IGlobalState) {

    val navController = rememberNavController()

    YassirComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            DestinationsNavHost(
                navGraph = NavGraphs.root,
                navController = navController,
                startRoute = NavGraphs.root.startRoute
            )

            if (globalState.loadingState.value) {
                Progress()
            }

            if (globalState.errorState.value != null) {
                Error(
                    title = stringResource(R.string.error),
                    body = globalState.errorState.value!!,
                )
            }

            if (globalState.successState.value != null) {
                DefaultMessageDialog(
                    title = stringResource(R.string.success),
                    body = globalState.successState.value!!,
                    buttonText = stringResource(R.string.got_it),
                    onNegative = {
                        globalState.idle()
                    },
                    onPositive = {
                        globalState.idle()
                    }
                )
            }

        }
    }
}
