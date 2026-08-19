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
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import com.example.data.EngineeringData
import com.example.data.MaterialItem
import com.example.ui.components.BlueprintGridBackground
import com.example.ui.components.EngineeringCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.TechBadge
import com.example.ui.theme.BorderDark
import com.example.ui.theme.BorderLight
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepNavy
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.EngineeringOrange
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PurpleAccent
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceElevated
import com.example.ui.theme.SurfaceVariantDark
import com.example.ui.theme.TechCyan
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import com.example.ui.theme.TextTertiary
import com.example.ui.theme.WarningYellow

@Composable
fun MaterialsScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryFilter by remember { mutableStateOf("All") }
    var expandedMaterialId by remember { mutableStateOf<String?>(null) }
    var isCompareMode by remember { mutableStateOf(false) }

    var matAIndex by remember { mutableStateOf(0) }
    var matBIndex by remember { mutableStateOf(1) }

    val categories = listOf("All", "Metals & Alloys", "Composites", "Semiconductors & Minerals", "Construction")

    val filteredMaterials = EngineeringData.materials.filter { mat ->
        val matchesSearch = mat.name.contains(searchQuery, ignoreCase = true) ||
                mat.category.contains(searchQuery, ignoreCase = true) ||
                mat.commonUses.any { it.contains(searchQuery, ignoreCase = true) }
        val matchesCategory = when (selectedCategoryFilter) {
            "Metals & Alloys" -> mat.category in listOf("Metals", "Light Alloys", "High-Strength Alloys", "Conductive Metals", "Advanced Alloys")
            "Composites" -> mat.category in listOf("Composites", "Advanced Composites")
            "Semiconductors & Minerals" -> mat.category in listOf("Semiconductors", "Ceramics & Glasses")
            "Construction" -> mat.category in listOf("Ceramics & Composites", "Composite Construction", "Polymers")
            else -> true
        }
        matchesSearch && matchesCategory
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
                    title = "Engineering Materials",
                    subtitle = "Mechanical, thermal & electrical properties with side-by-side comparison",
                    icon = Icons.Default.Science,
                    badgeText = "${EngineeringData.materials.size} Materials",
                    badgeColor = SuccessGreen
                )
            }

            // Mode Toggle Bar (Catalog vs Side-by-Side Compare)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { isCompareMode = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isCompareMode) TechCyan else SurfaceVariantDark
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("btn_materials_catalog")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Science,
                            contentDescription = null,
                            tint = if (!isCompareMode) DeepNavy else TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Catalog View",
                            fontWeight = FontWeight.Bold,
                            color = if (!isCompareMode) DeepNavy else TextPrimary
                        )
                    }

                    Button(
                        onClick = { isCompareMode = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isCompareMode) PurpleAccent else SurfaceVariantDark
                        ),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("btn_materials_compare")
                    ) {
                        Icon(
                            imageVector = Icons.Default.CompareArrows,
                            contentDescription = null,
                            tint = if (isCompareMode) DeepNavy else TextSecondary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Side-by-Side Compare",
                            fontWeight = FontWeight.Bold,
                            color = if (isCompareMode) DeepNavy else TextPrimary
                        )
                    }
                }
            }

            if (isCompareMode) {
                // Side-by-Side Compare View
                item {
                    val matA = EngineeringData.materials.getOrElse(matAIndex) { EngineeringData.materials[0] }
                    val matB = EngineeringData.materials.getOrElse(matBIndex) { EngineeringData.materials[1] }

                    EngineeringCard(
                        borderColor = PurpleAccent.copy(alpha = 0.5f),
                        backgroundColor = CardBackground
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Material Property Comparison",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimary
                            )
                            Spacer(modifier = Modifier.height(14.dp))

                            // Selectors
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text("Material A", style = MaterialTheme.typography.labelSmall, color = TechCyan)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    MaterialPickerDropdown(
                                        selectedMaterial = matA,
                                        materials = EngineeringData.materials,
                                        onSelected = { matAIndex = EngineeringData.materials.indexOf(it) }
                                    )
                                }
                                Column(modifier = Modifier.weight(1f)) {
                                    Text("Material B", style = MaterialTheme.typography.labelSmall, color = EngineeringOrange)
                                    Spacer(modifier = Modifier.height(4.dp))
                                    MaterialPickerDropdown(
                                        selectedMaterial = matB,
                                        materials = EngineeringData.materials,
                                        onSelected = { matBIndex = EngineeringData.materials.indexOf(it) }
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Comparison Property Rows
                            PropertyCompareRow(label = "Category", valA = matA.category, valB = matB.category)
                            PropertyCompareRow(label = "Density", valA = matA.density, valB = matB.density)
                            PropertyCompareRow(label = "Yield Strength", valA = matA.yieldStrength, valB = matB.yieldStrength)
                            PropertyCompareRow(label = "Thermal Cond.", valA = matA.thermalConductivity, valB = matB.thermalConductivity)
                            PropertyCompareRow(label = "Electrical Cond.", valA = matA.electricalConductivity, valB = matB.electricalConductivity)

                            Spacer(modifier = Modifier.height(14.dp))

                            // Strengths Comparison
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(TechCyan.copy(alpha = 0.1f))
                                        .border(1.dp, TechCyan.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                                        .padding(8.dp)
                                ) {
                                    Column {
                                        Text("${matA.name} Pros", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = TechCyan)
                                        matA.advantages.take(2).forEach {
                                            Text("• $it", style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                                        }
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(EngineeringOrange.copy(alpha = 0.1f))
                                        .border(1.dp, EngineeringOrange.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                                        .padding(8.dp)
                                ) {
                                    Column {
                                        Text("${matB.name} Pros", style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold, color = EngineeringOrange)
                                        matB.advantages.take(2).forEach {
                                            Text("• $it", style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                // Catalog View
                item {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Search materials, properties, applications...", color = TextTertiary) },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TechCyan) },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("materials_search_input"),
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
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(categories) { cat ->
                            val isSelected = selectedCategoryFilter == cat
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isSelected) TechCyan else SurfaceVariantDark)
                                    .border(1.dp, if (isSelected) TechCyan else BorderDark, RoundedCornerShape(8.dp))
                                    .clickable { selectedCategoryFilter = cat }
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = cat,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) DeepNavy else TextSecondary
                                )
                            }
                        }
                    }
                }

                // Material Cards List
                items(filteredMaterials) { material ->
                    val isExpanded = expandedMaterialId == material.id
                    MaterialCard(
                        material = material,
                        isExpanded = isExpanded,
                        onToggleExpand = {
                            expandedMaterialId = if (isExpanded) null else material.id
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MaterialCard(
    material: MaterialItem,
    isExpanded: Boolean,
    onToggleExpand: () -> Unit
) {
    EngineeringCard(
        borderColor = if (isExpanded) TechCyan.copy(alpha = 0.5f) else BorderDark,
        backgroundColor = if (isExpanded) SurfaceVariantDark else CardBackground,
        onClick = onToggleExpand,
        modifier = Modifier.testTag("mat_card_${material.id}")
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
                    TechBadge(text = material.category, color = SuccessGreen)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = material.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = if (isExpanded) TechCyan else TextTertiary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 3 Property Pills Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                PropertyPill("Density", material.density, Modifier.weight(1f))
                PropertyPill("Strength", material.yieldStrength.take(15), Modifier.weight(1.2f))
                PropertyPill("Thermal", material.thermalConductivity, Modifier.weight(1f))
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(top = 14.dp)) {
                    // Advantages & Disadvantages
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Key Advantages", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = SuccessGreen)
                            Spacer(modifier = Modifier.height(4.dp))
                            material.advantages.forEach { adv ->
                                Text("✓ $adv", style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                            }
                        }

                        Column(modifier = Modifier.weight(1f)) {
                            Text("Tradeoffs & Limits", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = WarningYellow)
                            Spacer(modifier = Modifier.height(4.dp))
                            material.disadvantages.forEach { dis ->
                                Text("✗ $dis", style = MaterialTheme.typography.bodySmall, color = TextPrimary)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Common Applications
                    Text("Common Engineering Applications", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = TechCyan)
                    Spacer(modifier = Modifier.height(6.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        material.commonUses.forEach { app ->
                            TechBadge(text = app, color = ElectricBlue)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PropertyPill(label: String, value: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(SurfaceElevated)
            .border(1.dp, BorderDark, RoundedCornerShape(8.dp))
            .padding(horizontal = 6.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, style = MaterialTheme.typography.labelSmall, color = TextSecondary, fontSize = 10.sp)
            Text(text = value, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = TechCyan, fontSize = 11.sp)
        }
    }
}

@Composable
fun PropertyCompareRow(label: String, valA: String, valB: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = valA, style = MaterialTheme.typography.bodyMedium, color = TechCyan, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Text(text = label, style = MaterialTheme.typography.labelSmall, color = TextSecondary, modifier = Modifier.padding(horizontal = 4.dp))
        Text(text = valB, style = MaterialTheme.typography.bodyMedium, color = EngineeringOrange, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.End)
    }
}

@Composable
fun MaterialPickerDropdown(
    selectedMaterial: MaterialItem,
    materials: List<MaterialItem>,
    onSelected: (MaterialItem) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(SurfaceElevated)
                .border(1.dp, BorderDark, RoundedCornerShape(8.dp))
                .clickable { expanded = true }
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedMaterial.name,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    maxLines = 1
                )
                Text("▼", style = MaterialTheme.typography.labelSmall, color = TechCyan)
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(SurfaceElevated)
        ) {
            materials.forEach { mat ->
                DropdownMenuItem(
                    text = { Text(mat.name, color = if (mat == selectedMaterial) TechCyan else TextPrimary) },
                    onClick = {
                        onSelected(mat)
                        expanded = false
                    }
                )
            }
        }
    }
}
