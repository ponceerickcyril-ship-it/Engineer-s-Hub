package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CalculatorType
import com.example.ui.navigation.AppScreen
import com.example.ui.navigation.NavigationState
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.CalculatorsScreen
import com.example.ui.screens.ConceptsScreen
import com.example.ui.screens.DashboardScreen
import com.example.ui.screens.DiagramsScreen
import com.example.ui.screens.FieldsScreen
import com.example.ui.screens.FormulaLibraryScreen
import com.example.ui.screens.GlobalSearchScreen
import com.example.ui.screens.LearningCenterScreen
import com.example.ui.screens.MaterialsScreen
import com.example.ui.screens.ProjectIdeasScreen
import com.example.ui.screens.RealWorldScreen
import com.example.ui.screens.UnitConverterScreen
import com.example.ui.theme.BackgroundDark
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderSubtle
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TechCyanDark
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                EngineeringHubApp()
            }
        }
    }
}

@Composable
fun EngineeringHubApp() {
    var navState by remember { mutableStateOf(NavigationState()) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // Handle back button: return to dashboard if on another screen
    BackHandler(enabled = navState.currentScreen != AppScreen.DASHBOARD || drawerState.isOpen) {
        if (drawerState.isOpen) {
            coroutineScope.launch { drawerState.close() }
        } else {
            navState = navState.copy(currentScreen = AppScreen.DASHBOARD)
        }
    }

    val headerQuickTabs = listOf(
        AppScreen.DASHBOARD,
        AppScreen.CALCULATORS,
        AppScreen.FORMULAS,
        AppScreen.FIELDS,
        AppScreen.MATERIALS,
        AppScreen.CONVERTER,
        AppScreen.DIAGRAMS,
        AppScreen.LEARNING,
        AppScreen.PROJECTS,
        AppScreen.REAL_WORLD
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = DeepNavy,
                drawerContentColor = TextPrimary,
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Drawer Header
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(TechCyan.copy(alpha = 0.15f))
                                    .border(1.dp, TechCyan.copy(alpha = 0.4f), RoundedCornerShape(10.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Construction,
                                    contentDescription = null,
                                    tint = TechCyan,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "THE HUB",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = TechCyan,
                                    letterSpacing = 1.8.sp
                                )
                                Text(
                                    text = "ENGINEERING HUB",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Black,
                                    color = TextPrimary,
                                    letterSpacing = 0.5.sp
                                )
                            }
                        }
                    }

                    HorizontalDivider(
                        color = BorderDark,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    // Navigation Items
                    Text(
                        text = "CORE MODULES",
                        style = MaterialTheme.typography.labelSmall,
                        color = TextTertiary,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.2.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                    AppScreen.values().filter { it != AppScreen.GLOBAL_SEARCH }.forEach { screen ->
                        val isSelected = navState.currentScreen == screen
                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = screen.title,
                                    tint = if (isSelected) TechCyan else TextSecondary,
                                    modifier = Modifier.size(20.dp)
                                )
                            },
                            label = {
                                Text(
                                    text = screen.title,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) TechCyan else TextPrimary
                                )
                            },
                            selected = isSelected,
                            onClick = {
                                navState = navState.copy(currentScreen = screen)
                                coroutineScope.launch { drawerState.close() }
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = TechCyan.copy(alpha = 0.12f),
                                unselectedContainerColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .padding(horizontal = 10.dp, vertical = 2.dp)
                                .testTag("drawer_item_${screen.name}")
                        )
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                // High Density Custom Header with Pills
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(DeepNavy)
                        .border(width = 1.dp, color = BorderDark)
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "THE HUB",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = TechCyan,
                                letterSpacing = 2.0.sp
                            )
                            Text(
                                text = if (navState.currentScreen == AppScreen.DASHBOARD) "ENGINEERING HUB" else navState.currentScreen.title.uppercase(),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black,
                                color = TextPrimary,
                                letterSpacing = (-0.3).sp
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            // Search Button
                            Box(
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(SurfaceVariantDark)
                                    .border(1.dp, BorderDark, RoundedCornerShape(10.dp))
                                    .clickable {
                                        navState = navState.copy(currentScreen = AppScreen.GLOBAL_SEARCH)
                                    }
                                    .testTag("top_bar_search_button"),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = TechCyan,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            // Drawer / Menu Button
                            Box(
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(TechCyan.copy(alpha = 0.1f))
                                    .border(1.dp, TechCyan.copy(alpha = 0.25f), RoundedCornerShape(10.dp))
                                    .clickable {
                                        coroutineScope.launch {
                                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                                        }
                                    }
                                    .testTag("top_bar_menu_button"),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu",
                                    tint = TechCyan,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Horizontal Quick-Pills Navigation Strip
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(headerQuickTabs) { screen ->
                            val isSelected = navState.currentScreen == screen
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(if (isSelected) TechCyanDark else SurfaceVariantDark)
                                    .border(
                                        1.dp,
                                        if (isSelected) TechCyanDark else BorderDark,
                                        RoundedCornerShape(20.dp)
                                    )
                                    .clickable {
                                        navState = navState.copy(currentScreen = screen)
                                    }
                                    .padding(horizontal = 12.dp, vertical = 5.dp)
                                    .testTag("quick_tab_${screen.name}")
                            ) {
                                Text(
                                    text = screen.title,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                                    color = if (isSelected) Color.White else TextSecondary
                                )
                            }
                        }
                    }
                }
            },
            bottomBar = {
                // High Density 5-Column Navigation Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(DeepNavy)
                        .border(1.dp, BorderDark)
                        .padding(horizontal = 6.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 1. Home (Dashboard)
                    BottomNavDenseItem(
                        title = "HOME",
                        icon = Icons.Default.GridView,
                        isSelected = navState.currentScreen == AppScreen.DASHBOARD,
                        onClick = { navState = navState.copy(currentScreen = AppScreen.DASHBOARD) },
                        testTag = "nav_bottom_DASHBOARD"
                    )

                    // 2. Lib (Formulas)
                    BottomNavDenseItem(
                        title = "LIB",
                        icon = Icons.Default.Functions,
                        isSelected = navState.currentScreen == AppScreen.FORMULAS,
                        onClick = { navState = navState.copy(currentScreen = AppScreen.FORMULAS) },
                        testTag = "nav_bottom_FORMULAS"
                    )

                    // 3. Calc (Calculators)
                    BottomNavDenseItem(
                        title = "CALC",
                        icon = Icons.Default.Calculate,
                        isSelected = navState.currentScreen == AppScreen.CALCULATORS,
                        onClick = { navState = navState.copy(currentScreen = AppScreen.CALCULATORS) },
                        testTag = "nav_bottom_CALCULATORS"
                    )

                    // 4. Learn (Learning Center)
                    BottomNavDenseItem(
                        title = "LEARN",
                        icon = Icons.Default.School,
                        isSelected = navState.currentScreen == AppScreen.LEARNING,
                        onClick = { navState = navState.copy(currentScreen = AppScreen.LEARNING) },
                        testTag = "nav_bottom_LEARNING"
                    )

                    // 5. More (Open Drawer)
                    BottomNavDenseItem(
                        title = "MORE",
                        icon = Icons.Default.MoreHoriz,
                        isSelected = false,
                        onClick = {
                            coroutineScope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        },
                        testTag = "nav_bottom_MORE"
                    )
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(BackgroundDark)
            ) {
                AnimatedContent(
                    targetState = navState.currentScreen,
                    transitionSpec = {
                        fadeIn() togetherWith fadeOut()
                    },
                    label = "ScreenTransition"
                ) { targetScreen ->
                    when (targetScreen) {
                        AppScreen.DASHBOARD -> DashboardScreen(
                            onNavigate = { screen -> navState = navState.copy(currentScreen = screen) },
                            onOpenCalculator = { calcType ->
                                navState = navState.copy(
                                    currentScreen = AppScreen.CALCULATORS,
                                    selectedCalculator = calcType
                                )
                            },
                            onOpenField = { fieldId ->
                                navState = navState.copy(
                                    currentScreen = AppScreen.FIELDS,
                                    activeFieldId = fieldId
                                )
                            },
                            onOpenSearch = {
                                navState = navState.copy(currentScreen = AppScreen.GLOBAL_SEARCH)
                            }
                        )

                        AppScreen.FIELDS -> FieldsScreen(
                            initialSelectedFieldId = navState.activeFieldId
                        )

                        AppScreen.CONCEPTS -> ConceptsScreen(
                            initialConceptId = navState.activeConceptId
                        )

                        AppScreen.FORMULAS -> FormulaLibraryScreen(
                            onOpenCalculator = { calcType ->
                                navState = navState.copy(
                                    currentScreen = AppScreen.CALCULATORS,
                                    selectedCalculator = calcType
                                )
                            }
                        )

                        AppScreen.CALCULATORS -> CalculatorsScreen(
                            initialCalculator = navState.selectedCalculator
                        )

                        AppScreen.CONVERTER -> UnitConverterScreen()

                        AppScreen.MATERIALS -> MaterialsScreen()

                        AppScreen.REAL_WORLD -> RealWorldScreen()

                        AppScreen.DIAGRAMS -> DiagramsScreen()

                        AppScreen.LEARNING -> LearningCenterScreen()

                        AppScreen.PROJECTS -> ProjectIdeasScreen()

                        AppScreen.ABOUT -> AboutScreen()

                        AppScreen.GLOBAL_SEARCH -> GlobalSearchScreen(
                            initialQuery = navState.searchQuery,
                            onNavigate = { target -> navState = navState.copy(currentScreen = target) },
                            onOpenCalculator = { calcType ->
                                navState = navState.copy(
                                    currentScreen = AppScreen.CALCULATORS,
                                    selectedCalculator = calcType
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavDenseItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    testTag: String
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .testTag(testTag),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = if (isSelected) TechCyan else TextTertiary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
            color = if (isSelected) TechCyan else TextTertiary,
            fontSize = 9.sp
        )
    }
}
