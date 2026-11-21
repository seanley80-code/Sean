package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.RecordVoiceOver
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.RecordVoiceOver
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.components.TtsSettingsSheet
import com.example.ui.screens.CategoryDetailScreen
import com.example.ui.screens.FavoritesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.theme.SontanaTheme
import com.example.ui.viewmodel.ConversationViewModel

object AppRoutes {
    const val HOME = "home"
    const val PRACTICE = "practice"
    const val FAVORITES = "favorites"
    const val CATEGORY_DETAIL = "category/{categoryId}"
    fun categoryDetail(categoryId: String) = "category/$categoryId"
}

private data class TopLevelDestination(
    val route: String,
    val labelRes: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val testTag: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SontanaTheme {
                SontanaApp()
            }
        }
    }
}

@Composable
fun SontanaApp(
    viewModel: ConversationViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    var showSettingsSheet by remember { mutableStateOf(false) }

    val topDestinations = remember {
        listOf(
            TopLevelDestination(
                route = AppRoutes.HOME,
                labelRes = R.string.nav_home,
                selectedIcon = Icons.Rounded.Home,
                unselectedIcon = Icons.Outlined.Home,
                testTag = "nav_home_tab"
            ),
            TopLevelDestination(
                route = AppRoutes.PRACTICE,
                labelRes = R.string.nav_practice,
                selectedIcon = Icons.Rounded.RecordVoiceOver,
                unselectedIcon = Icons.Outlined.RecordVoiceOver,
                testTag = "nav_practice_tab"
            ),
            TopLevelDestination(
                route = AppRoutes.FAVORITES,
                labelRes = R.string.nav_favorites,
                selectedIcon = Icons.Rounded.Bookmark,
                unselectedIcon = Icons.Outlined.BookmarkBorder,
                testTag = "nav_favorites_tab"
            )
        )
    }

    val isTopLevelRoute = currentDestination?.route in setOf(
        AppRoutes.HOME,
        AppRoutes.PRACTICE,
        AppRoutes.FAVORITES
    )

    LaunchedEffect(uiState.playbackState.warningMessage) {
        val msg = uiState.playbackState.warningMessage ?: return@LaunchedEffect
        val result = snackbarHostState.showSnackbar(
            message = msg,
            actionLabel = "ការកំណត់",
            duration = SnackbarDuration.Long
        )
        if (result == SnackbarResult.ActionPerformed) {
            viewModel.openTtsSettings(context)
        }
        viewModel.clearWarning()
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useNavRail = maxWidth >= 840.dp

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background,
            contentWindowInsets = WindowInsets.safeDrawing,
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            bottomBar = {
                if (isTopLevelRoute && !useNavRail) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        tonalElevation = 3.dp
                    ) {
                        topDestinations.forEach { dest ->
                            val selected = currentDestination?.hierarchy?.any { it.route == dest.route } == true
                            NavigationBarItem(
                                selected = selected,
                                onClick = {
                                    navController.navigate(dest.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = stringResource(dest.labelRes)
                                    )
                                },
                                label = { Text(text = stringResource(dest.labelRes)) },
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (isTopLevelRoute && useNavRail) {
                    NavigationRail(
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        topDestinations.forEach { dest ->
                            val selected = currentDestination?.hierarchy?.any { it.route == dest.route } == true
                            NavigationRailItem(
                                selected = selected,
                                onClick = {
                                    navController.navigate(dest.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = stringResource(dest.labelRes)
                                    )
                                },
                                label = { Text(text = stringResource(dest.labelRes)) },
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = AppRoutes.HOME,
                    modifier = Modifier.weight(1f)
                ) {
                    composable(AppRoutes.HOME) {
                        HomeScreen(
                            uiState = uiState,
                            onSearchQueryChange = viewModel::updateSearchQuery,
                            onSelectSpeed = viewModel::selectSpeechSpeed,
                            onCategoryClick = { categoryId ->
                                navController.navigate(AppRoutes.categoryDetail(categoryId))
                            },
                            onSpeakPhrase = viewModel::speakPhrase,
                            onSpeakAllThree = viewModel::speakAllThree,
                            onToggleFavorite = viewModel::toggleFavorite,
                            onOpenSettings = {
                                viewModel.refreshTtsAvailability()
                                showSettingsSheet = true
                            }
                        )
                    }

                    composable(
                        route = AppRoutes.CATEGORY_DETAIL,
                        arguments = listOf(
                            navArgument("categoryId") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val categoryId = backStackEntry.arguments?.getString("categoryId").orEmpty()
                        CategoryDetailScreen(
                            categoryId = categoryId,
                            uiState = uiState,
                            onBack = { navController.popBackStack() },
                            onSelectSpeed = viewModel::selectSpeechSpeed,
                            onSpeakPhrase = viewModel::speakPhrase,
                            onSpeakAllThree = viewModel::speakAllThree,
                            onSpeakDialogue = { lang ->
                                viewModel.speakCategoryDialogue(categoryId, lang)
                            },
                            onStopAudio = viewModel::stopAudio,
                            onToggleFavorite = viewModel::toggleFavorite,
                            onOpenSettings = {
                                viewModel.refreshTtsAvailability()
                                showSettingsSheet = true
                            }
                        )
                    }

                    composable(AppRoutes.PRACTICE) {
                        PracticeScreen(
                            uiState = uiState,
                            onSelectPracticeCategory = viewModel::selectPracticeCategory,
                            onSelectSpeed = viewModel::selectSpeechSpeed,
                            onSpeakPhrase = viewModel::speakPhrase,
                            onSpeakAllThree = viewModel::speakAllThree,
                            onToggleFavorite = viewModel::toggleFavorite
                        )
                    }

                    composable(AppRoutes.FAVORITES) {
                        FavoritesScreen(
                            uiState = uiState,
                            onSelectSpeed = viewModel::selectSpeechSpeed,
                            onSpeakPhrase = viewModel::speakPhrase,
                            onSpeakAllThree = viewModel::speakAllThree,
                            onToggleFavorite = viewModel::toggleFavorite
                        )
                    }
                }
            }
        }
    }

    if (showSettingsSheet) {
        TtsSettingsSheet(
            showReadingText = uiState.showReadingText,
            showKhmerPhonetic = uiState.showKhmerPhonetic,
            playbackState = uiState.playbackState,
            onToggleReadingText = viewModel::setShowReadingText,
            onToggleKhmerPhonetic = viewModel::setShowKhmerPhonetic,
            onOpenSystemTtsSettings = { viewModel.openTtsSettings(context) },
            onDismiss = { showSettingsSheet = false }
        )
    }
}
