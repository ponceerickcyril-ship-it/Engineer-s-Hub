package com.example.ui.screens

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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.CalculatorType
import com.example.data.EngineeringData
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.TechBadge
import com.example.ui.navigation.AppScreen
import com.example.ui.theme.BorderDark
import com.example.ui.theme.CardBackground
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow

data class SearchResultItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val snippet: String,
    val categoryBadge: String,
    val icon: ImageVector,
    val targetScreen: AppScreen,
    val calculatorType: CalculatorType? = null
)

@Composable
fun GlobalSearchScreen(
    initialQuery: String = "",
    onNavigate: (AppScreen) -> Unit = {},
    onOpenCalculator: (CalculatorType) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf(initialQuery) }
    var selectedFilter by remember { mutableStateOf("All") }

    val filters = listOf("All", "Formulas", "Fields", "Concepts", "Materials", "Systems", "Glossary", "Projects")

    val allResults = remember(searchQuery) {
        if (searchQuery.trim().length < 2) {
            emptyList()
        } else {
            val q = searchQuery.trim()
            val list = mutableListOf<SearchResultItem>()

            // 1. Formulas
            EngineeringData.formulas.filter {
                it.name.contains(q, ignoreCase = true) ||
                        it.category.displayName.contains(q, ignoreCase = true) ||
                        it.whenUsed.contains(q, ignoreCase = true) ||
                        it.equation.contains(q, ignoreCase = true)
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.name,
                        subtitle = "Formula • ${it.category.displayName}",
                        snippet = "${it.equation} - ${it.whenUsed}",
                        categoryBadge = "Formula",
                        icon = Icons.Default.Functions,
                        targetScreen = AppScreen.FORMULAS,
                        calculatorType = it.calculatorType
                    )
                )
            }

            // 2. Fields
            EngineeringData.fields.filter {
                it.title.contains(q, ignoreCase = true) ||
                        it.shortDescription.contains(q, ignoreCase = true) ||
                        it.commonTechnologies.any { t -> t.contains(q, ignoreCase = true) }
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.title,
                        subtitle = "Engineering Discipline",
                        snippet = it.shortDescription,
                        categoryBadge = "Field",
                        icon = Icons.Default.Construction,
                        targetScreen = AppScreen.FIELDS
                    )
                )
            }

            // 3. Concepts
            EngineeringData.concepts.filter {
                it.name.contains(q, ignoreCase = true) ||
                        it.definition.contains(q, ignoreCase = true) ||
                        it.engineeringApplication.contains(q, ignoreCase = true)
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.name,
                        subtitle = "Concept • ${it.category.displayName}",
                        snippet = it.definition,
                        categoryBadge = "Concept",
                        icon = Icons.Default.MenuBook,
                        targetScreen = AppScreen.CONCEPTS
                    )
                )
            }

            // 4. Materials
            EngineeringData.materials.filter {
                it.name.contains(q, ignoreCase = true) ||
                        it.category.contains(q, ignoreCase = true) ||
                        it.commonUses.any { u -> u.contains(q, ignoreCase = true) }
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.name,
                        subtitle = "Material • ${it.category}",
                        snippet = "Density: ${it.density} | Strength: ${it.yieldStrength} | Uses: ${it.commonUses.joinToString(", ")}",
                        categoryBadge = "Material",
                        icon = Icons.Default.Science,
                        targetScreen = AppScreen.MATERIALS
                    )
                )
            }

            // 5. Real-World Systems
            EngineeringData.realWorldSystems.filter {
                it.title.contains(q, ignoreCase = true) ||
                        it.subtitle.contains(q, ignoreCase = true) ||
                        it.whatEngineersDo.contains(q, ignoreCase = true)
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.title,
                        subtitle = "Real-World System • ${it.iconCategory}",
                        snippet = it.whatEngineersDo,
                        categoryBadge = "System",
                        icon = Icons.Default.Public,
                        targetScreen = AppScreen.REAL_WORLD
                    )
                )
            }

            // 6. Glossary
            EngineeringData.glossaryTerms.filter {
                it.term.contains(q, ignoreCase = true) ||
                        it.definition.contains(q, ignoreCase = true) ||
                        it.category.contains(q, ignoreCase = true)
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.term,
                        subtitle = "Glossary Term • ${it.category}",
                        snippet = it.definition,
                        categoryBadge = "Glossary",
                        icon = Icons.Default.Calculate,
                        targetScreen = AppScreen.LEARNING
                    )
                )
            }

            // 7. Projects
            EngineeringData.projectIdeas.filter {
                it.title.contains(q, ignoreCase = true) ||
                        it.field.contains(q, ignoreCase = true) ||
                        it.objective.contains(q, ignoreCase = true)
            }.forEach {
                list.add(
                    SearchResultItem(
                        id = it.id,
                        title = it.title,
                        subtitle = "Project • ${it.difficulty}",
                        snippet = it.objective,
                        categoryBadge = "Project",
                        icon = Icons.Default.Lightbulb,
                        targetScreen = AppScreen.PROJECTS
                    )
                )
            }

            list
        }
    }

    val filteredResults = allResults.filter { item ->
        when (selectedFilter) {
            "Formulas" -> item.categoryBadge == "Formula"
            "Fields" -> item.categoryBadge == "Field"
            "Concepts" -> item.categoryBadge == "Concept"
            "Materials" -> item.categoryBadge == "Material"
            "Systems" -> item.categoryBadge == "System"
            "Glossary" -> item.categoryBadge == "Glossary"
            "Projects" -> item.categoryBadge == "Project"
            else -> true
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        BlueprintGridBackground(modifier = Modifier.fillMaxSize())

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Search Header Bar
            item {
                Column {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Search all formulas, concepts, tools & systems...", color = TextTertiary) },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TechCyan) },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = TextSecondary)
                                }
                            }
                        },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("global_search_input"),
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

                    // Filter chips
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(filters) { filter ->
                            val isSelected = selectedFilter == filter
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isSelected) TechCyan else SurfaceElevated)
                                    .border(1.dp, if (isSelected) TechCyan else BorderDark, RoundedCornerShape(8.dp))
                                    .clickable { selectedFilter = filter }
                                    .padding(horizontal = 10.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = filter,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) CardBackground else TextPrimary
                                )
                            }
                        }
                    }
                }
            }

            // Results count or quick prompts
            if (searchQuery.trim().length < 2) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = TechCyan.copy(alpha = 0.5f),
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Instant Global Engineering Search",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Search across 100+ formulas, engineering fields, material specs, interactive diagrams, and projects.",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Quick suggestion pills
                        val suggestions = listOf("Ohm's Law", "Bernoulli", "Titanium", "Truss Bridge", "Reynolds", "Young's Modulus")
                        Text("Suggested Searches:", style = MaterialTheme.typography.labelSmall, color = TechCyan)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            suggestions.take(3).forEach { s ->
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(SurfaceElevated)
                                        .border(1.dp, BorderDark, RoundedCornerShape(8.dp))
                                        .clickable { searchQuery = s }
                                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text(s, style = MaterialTheme.typography.labelSmall, color = TextPrimary)
                                }
                            }
                        }
                    }
                }
            } else if (filteredResults.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No results found for \"$searchQuery\" in $selectedFilter",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextSecondary
                        )
                    }
                }
            } else {
                item {
                    Text(
                        text = "Found ${filteredResults.size} matches",
                        style = MaterialTheme.typography.labelSmall,
                        color = TechCyan,
                        fontWeight = FontWeight.Bold
                    )
                }

                items(filteredResults) { result ->
                    EngineeringCard(
                        borderColor = BorderDark,
                        backgroundColor = CardBackground,
                        onClick = {
                            if (result.calculatorType != null) {
                                onOpenCalculator(result.calculatorType)
                            } else {
                                onNavigate(result.targetScreen)
                            }
                        }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(SurfaceElevated),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = result.icon,
                                    contentDescription = null,
                                    tint = TechCyan,
                                    modifier = Modifier.size(22.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = result.title,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = TextPrimary
                                    )
                                    val badgeColor = when (result.categoryBadge) {
                                        "Formula" -> TechCyan
                                        "Field" -> PurpleAccent
                                        "Concept" -> ElectricBlue
                                        "Material" -> SuccessGreen
                                        "System" -> EngineeringOrange
                                        "Project" -> WarningYellow
                                        else -> TechCyan
                                    }
                                    TechBadge(text = result.categoryBadge, color = badgeColor)
                                }

                                Text(
                                    text = result.subtitle,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = TextSecondary
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = result.snippet,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TextSecondary,
                                    maxLines = 2,
                                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
