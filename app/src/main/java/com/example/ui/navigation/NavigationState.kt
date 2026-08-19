package com.example.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.data.CalculatorType

enum class AppScreen(
    val title: String,
    val icon: ImageVector,
    val isPrimaryNav: Boolean = true
) {
    DASHBOARD("Dashboard", Icons.Default.Dashboard),
    FIELDS("Fields", Icons.Default.Construction),
    CONCEPTS("Concepts", Icons.Default.MenuBook),
    FORMULAS("Formulas", Icons.Default.Functions),
    CALCULATORS("Calculators", Icons.Default.Calculate),
    CONVERTER("Converter", Icons.Default.SwapHoriz),
    MATERIALS("Materials", Icons.Default.Science),
    REAL_WORLD("Real World", Icons.Default.Public),
    DIAGRAMS("Simulators", Icons.Default.Visibility),
    LEARNING("Learning", Icons.Default.School),
    PROJECTS("Projects", Icons.Default.Lightbulb),
    ABOUT("About", Icons.Default.Info, isPrimaryNav = false),
    GLOBAL_SEARCH("Search", Icons.Default.Dashboard, isPrimaryNav = false)
}

data class NavigationState(
    val currentScreen: AppScreen = AppScreen.DASHBOARD,
    val selectedCalculator: CalculatorType = CalculatorType.OHMS_LAW,
    val searchQuery: String = "",
    val activeFieldId: String? = null,
    val activeConceptId: String? = null,
    val activeMaterialId: String? = null
)
