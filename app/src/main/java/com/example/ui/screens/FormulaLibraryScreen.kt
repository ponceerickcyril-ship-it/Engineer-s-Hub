package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CalculatorType
import com.example.data.EngineeringData
import com.example.data.FormulaCategory
import com.example.data.FormulaItem
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.MathEquationBox
import com.example.ui.components.SectionHeader
import com.example.ui.components.StepSolutionBox
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow

@Composable
fun FormulaLibraryScreen(
    onOpenCalculator: (CalculatorType) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<FormulaCategory?>(null) }
    var expandedFormulaId by remember { mutableStateOf<String?>(null) }

    val filteredFormulas = EngineeringData.formulas.filter { formula ->
        val matchesCategory = selectedCategory == null || formula.category == selectedCategory
        val matchesSearch = formula.name.contains(searchQuery, ignoreCase = true) ||
                formula.equation.contains(searchQuery, ignoreCase = true) ||
                formula.whenUsed.contains(searchQuery, ignoreCase = true) ||
                formula.variableMeanings.any { it.first.contains(searchQuery, ignoreCase = true) || it.second.contains(searchQuery, ignoreCase = true) }
        matchesCategory && matchesSearch
    }

    Box(modifier = modifier.fillMaxSize()) {
        BlueprintGridBackground(modifier = Modifier.fillMaxSize())

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            item {
                SectionHeader(
                    title = "Formula Library",
                    subtitle = "Searchable engineering equations, variable definitions & worked solutions",
                    icon = Icons.Default.Functions,
                    badgeText = "${EngineeringData.formulas.size} Formulas",
                    badgeColor = TechCyan
                )
            }

            // Search and Category Filter
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search formulas (e.g. V=IR, F=ma, Pressure)...", color = TextTertiary) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TechCyan) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("formulas_search_input"),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = TechCyan,
                        unfocusedBorderColor = BorderDark,
                        focusedContainerColor = SurfaceVariantDark,
                        unfocusedContainerColor = SurfaceVariantDark,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        val isAllSelected = selectedCategory == null
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isAllSelected) TechCyan else SurfaceVariantDark)
                                .border(1.dp, if (isAllSelected) TechCyan else BorderDark, RoundedCornerShape(8.dp))
                                .clickable { selectedCategory = null }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = "All (${EngineeringData.formulas.size})",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = if (isAllSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isAllSelected) DeepNavy else TextSecondary
                            )
                        }
                    }
                    items(FormulaCategory.values()) { category ->
                        val isSelected = selectedCategory == category
                        val catColor = Color(category.colorHex)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) catColor else SurfaceVariantDark)
                                .border(1.dp, if (isSelected) catColor else BorderDark, RoundedCornerShape(8.dp))
                                .clickable { selectedCategory = category }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = category.displayName,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) DeepNavy else TextSecondary
                            )
                        }
                    }
                }
            }

            // Formulas List
            items(filteredFormulas) { formula ->
                val isExpanded = expandedFormulaId == formula.id
                FormulaCard(
                    formula = formula,
                    isExpanded = isExpanded,
                    onToggleExpand = {
                        expandedFormulaId = if (isExpanded) null else formula.id
                    },
                    onOpenCalculator = {
                        if (formula.calculatorType != null) {
                            onOpenCalculator(formula.calculatorType)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun FormulaCard(
    formula: FormulaItem,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit,
    onOpenCalculator: () -> Unit
) {
    val categoryColor = Color(formula.category.colorHex)

    EngineeringCard(
        borderColor = if (isExpanded) categoryColor.copy(alpha = 0.6f) else BorderDark,
        backgroundColor = if (isExpanded) SurfaceVariantDark else CardBackground,
        onClick = onToggleExpand,
        modifier = Modifier.testTag("formula_card_${formula.id}")
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    TechBadge(text = formula.category.displayName, color = categoryColor)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = formula.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = if (isExpanded) categoryColor else TextTertiary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            MathEquationBox(equation = formula.equation, accentColor = categoryColor)

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SI Units: ${formula.siUnits}",
                    style = MaterialTheme.typography.labelSmall,
                    color = WarningYellow,
                    fontWeight = FontWeight.Medium
                )
                if (formula.calculatorType != null) {
                    Button(
                        onClick = onOpenCalculator,
                        colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                        modifier = Modifier.testTag("calc_btn_${formula.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Calculate,
                            contentDescription = null,
                            tint = DeepNavy,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Try in Calculator",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = DeepNavy
                        )
                    }
                }
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(top = 14.dp)) {
                    // Variables Meaning Table
                    Text(
                        text = "Variable Definitions",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = categoryColor
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(SurfaceElevated)
                            .padding(10.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            formula.variableMeanings.forEach { (variable, meaning) ->
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "$variable :",
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold,
                                        color = categoryColor,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.width(36.dp)
                                    )
                                    Text(
                                        text = meaning,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = TextPrimary
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // When it is used
                    Text(
                        text = "When to Use",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = TechCyan
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = formula.whenUsed,
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Step-by-Step Worked Example
                    StepSolutionBox(
                        title = "Worked Example Problem",
                        steps = listOf(
                            "Problem: ${formula.simpleExample}",
                            "Substitution & Solution: ${formula.calculationStep}"
                        ),
                        accentColor = SuccessGreen
                    )
                }
            }
        }
    }
}
