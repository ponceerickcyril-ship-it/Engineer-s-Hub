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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PrecisionManufacturing
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
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
import com.example.data.ConceptCategory
import com.example.data.EngineeringConcept
import com.example.data.EngineeringData
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.MathEquationBox
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderLight
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
fun ConceptsScreen(
    initialConceptId: String? = null,
    modifier: Modifier = Modifier
) {
    var expandedConceptId by remember { mutableStateOf(initialConceptId) }
    var selectedCategory by remember { mutableStateOf<ConceptCategory?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredConcepts = EngineeringData.concepts.filter { concept ->
        val matchesCategory = selectedCategory == null || concept.category == selectedCategory
        val matchesSearch = concept.name.contains(searchQuery, ignoreCase = true) ||
                concept.definition.contains(searchQuery, ignoreCase = true) ||
                concept.simpleExplanation.contains(searchQuery, ignoreCase = true) ||
                concept.engineeringApplication.contains(searchQuery, ignoreCase = true)
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
                    title = "Engineering Concepts",
                    subtitle = "Foundational physics, electricity, thermodynamics & materials",
                    icon = Icons.Default.MenuBook,
                    badgeText = "${EngineeringData.concepts.size} Topics",
                    badgeColor = EngineeringOrange
                )
            }

            // Search Bar
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("Search concepts, formulas, applications...", color = TextTertiary) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TechCyan) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("concepts_search_input"),
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
                                text = "All (${EngineeringData.concepts.size})",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = if (isAllSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isAllSelected) DeepNavy else TextSecondary
                            )
                        }
                    }
                    items(ConceptCategory.values()) { category ->
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

            // Concepts List
            items(filteredConcepts) { concept ->
                val isExpanded = expandedConceptId == concept.id
                ConceptCard(
                    concept = concept,
                    isExpanded = isExpanded,
                    onToggleExpand = {
                        expandedConceptId = if (isExpanded) null else concept.id
                    }
                )
            }
        }
    }
}

@Composable
fun ConceptCard(
    concept: EngineeringConcept,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit
) {
    val categoryColor = Color(concept.category.colorHex)
    val categoryIcon = when (concept.category) {
        ConceptCategory.PHYSICS_MECHANICS -> Icons.Default.PrecisionManufacturing
        ConceptCategory.ELECTRICITY -> Icons.Default.Bolt
        ConceptCategory.THERMODYNAMICS -> Icons.Default.LocalFireDepartment
        ConceptCategory.MATERIALS -> Icons.Default.Science
    }

    EngineeringCard(
        borderColor = if (isExpanded) categoryColor.copy(alpha = 0.5f) else BorderDark,
        backgroundColor = if (isExpanded) SurfaceVariantDark else CardBackground,
        onClick = onToggleExpand,
        modifier = Modifier.testTag("concept_card_${concept.id}")
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
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(categoryColor.copy(alpha = 0.15f))
                            .border(1.dp, categoryColor.copy(alpha = 0.3f), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = categoryIcon,
                            contentDescription = null,
                            tint = categoryColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = concept.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                        }
                        TechBadge(text = concept.category.displayName, color = categoryColor)
                    }
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = if (isExpanded) categoryColor else TextTertiary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = concept.definition,
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary,
                lineHeight = 20.sp
            )

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(top = 14.dp)) {
                    // Formula if applicable
                    if (concept.formula != null) {
                        Text(
                            text = "Governing Equation & SI Units",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = categoryColor
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        MathEquationBox(equation = concept.formula, accentColor = categoryColor)
                        if (concept.units != null) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Units: ${concept.units}",
                                style = MaterialTheme.typography.labelSmall,
                                color = WarningYellow
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    // Simple student explanation
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(SurfaceElevated)
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                text = "💡 Student-Friendly Analogy",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = TechCyan
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = concept.simpleExplanation,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary,
                                lineHeight = 19.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Concrete Example
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(CardBackground)
                            .border(1.dp, BorderDark, RoundedCornerShape(10.dp))
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                text = "📐 Worked Example",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = SuccessGreen
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = concept.example,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Engineering Application
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(categoryColor.copy(alpha = 0.1f))
                            .border(1.dp, categoryColor.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                            .padding(12.dp)
                    ) {
                        Column {
                            Text(
                                text = "⚙️ Real Engineering Application",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = categoryColor
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = concept.engineeringApplication,
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary
                            )
                        }
                    }

                    if (concept.keyInsight.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Key Rule: ${concept.keyInsight}",
                            style = MaterialTheme.typography.labelSmall,
                            color = WarningYellow,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}
