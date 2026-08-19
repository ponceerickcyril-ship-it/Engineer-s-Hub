package com.example.data

data class EngineeringField(
    val id: String,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val mainResponsibilities: List<String>,
    val commonTechnologies: List<String>,
    val exampleCareers: List<String>,
    val realWorldExamples: List<String>,
    val badgeColorHex: Long = 0xFF3A86FF,
    val keyHighlight: String = ""
)

enum class ConceptCategory(val displayName: String, val colorHex: Long) {
    PHYSICS_MECHANICS("Physics & Mechanics", 0xFFFF7B00),
    ELECTRICITY("Electricity & Circuits", 0xFF00E5FF),
    THERMODYNAMICS("Thermodynamics", 0xFFEF4444),
    MATERIALS("Materials Science", 0xFF10B981)
}

data class EngineeringConcept(
    val id: String,
    val name: String,
    val category: ConceptCategory,
    val definition: String,
    val formula: String? = null,
    val units: String? = null,
    val simpleExplanation: String,
    val example: String,
    val engineeringApplication: String,
    val keyInsight: String = ""
)

enum class FormulaCategory(val displayName: String, val colorHex: Long) {
    MECHANICS("Mechanics", 0xFFFF7B00),
    ELECTRICITY("Electricity", 0xFF00E5FF),
    THERMODYNAMICS("Thermodynamics", 0xFFEF4444),
    FLUIDS("Fluid Mechanics", 0xFF3A86FF),
    MATERIALS("Materials", 0xFF10B981),
    GEOMETRY_MATH("Geometry & Math", 0xFF8B5CF6)
}

data class FormulaItem(
    val id: String,
    val name: String,
    val category: FormulaCategory,
    val equation: String,
    val variableMeanings: List<Pair<String, String>>,
    val siUnits: String,
    val whenUsed: String,
    val simpleExample: String,
    val calculationStep: String,
    val calculatorType: CalculatorType? = null
)

enum class CalculatorType(val title: String, val category: String, val formulaShort: String) {
    OHMS_LAW("Ohm's Law", "Electricity", "V = I × R"),
    ELECTRICAL_POWER("Electrical Power", "Electricity", "P = V × I"),
    FORCE("Newton's Second Law (Force)", "Mechanics", "F = m × a"),
    WORK("Mechanical Work", "Mechanics", "W = F × d"),
    POWER("Mechanical Power", "Mechanics", "P = W / t"),
    DENSITY("Material Density", "Materials", "ρ = m / V"),
    PRESSURE("Fluid / Solid Pressure", "Fluids & Mechanics", "P = F / A"),
    KINETIC_ENERGY("Kinetic Energy", "Energy", "KE = ½ m v²"),
    POTENTIAL_ENERGY("Gravitational Potential Energy", "Energy", "PE = m × g × h"),
    MOMENTUM("Linear Momentum", "Mechanics", "p = m × v"),
    TORQUE("Mechanical Torque", "Mechanics", "τ = F × r × sin(θ)"),
    HEAT_ENERGY("Specific Heat Transfer", "Thermodynamics", "Q = m × c × ΔT"),
    STRESS_STRAIN("Tensile Stress & Strain", "Materials", "σ = F/A, ε = ΔL/L₀"),
    FLOW_RATE("Volumetric Flow Rate", "Fluids", "Q = A × v")
}

data class MaterialItem(
    val id: String,
    val name: String,
    val category: String,
    val density: String, // e.g. "7,850 kg/m³"
    val densityValue: Double, // kg/m³ for comparison
    val yieldStrength: String, // e.g. "250 - 500 MPa"
    val strengthValue: Double, // MPa for comparison
    val electricalConductivity: String, // e.g. "Low / Insulator" or "5.96 × 10⁷ S/m"
    val thermalConductivity: String, // e.g. "50 W/m·K"
    val thermalValue: Double, // W/m·K
    val advantages: List<String>,
    val disadvantages: List<String>,
    val commonUses: List<String>,
    val colorAccentHex: Long = 0xFF10B981
)

data class DiagramHotspot(
    val id: String,
    val title: String,
    val description: String,
    val relativeX: Float, // 0f to 1f
    val relativeY: Float  // 0f to 1f
)

data class RealWorldSystem(
    val id: String,
    val title: String,
    val subtitle: String,
    val iconCategory: String,
    val engineeringFields: List<String>,
    val whatEngineersDo: String,
    val scientificPrinciples: List<String>,
    val materialsAndComponents: List<String>,
    val whyItMatters: String,
    val keyMetric: String,
    val hotspots: List<DiagramHotspot> = emptyList()
)

data class LessonSection(
    val heading: String,
    val body: String,
    val keyPoints: List<String> = emptyList()
)

enum class LessonLevel(val label: String, val colorHex: Long) {
    BEGINNER("Beginner", 0xFF10B981),
    INTERMEDIATE("Intermediate", 0xFF3A86FF),
    ADVANCED("Advanced", 0xFFFF7B00)
}

data class LearningLesson(
    val id: String,
    val title: String,
    val level: LessonLevel,
    val readTime: String,
    val category: String,
    val summary: String,
    val sections: List<LessonSection>,
    val keyTakeaway: String
)

data class QuizQuestion(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val field: String
)

data class GlossaryTerm(
    val id: String,
    val term: String,
    val category: String,
    val definition: String,
    val relatedFormulaOrConcept: String = ""
)

data class ProjectIdea(
    val id: String,
    val title: String,
    val field: String,
    val difficulty: String, // Easy, Medium, Challenging
    val estimatedTime: String,
    val objective: String,
    val basicMaterials: List<String>,
    val scientificPrinciple: String,
    val steps: List<String>,
    val expectedResult: String,
    val realWorldConnection: String
)

data class WorkedProblem(
    val id: String,
    val title: String,
    val topic: String,
    val problemStatement: String,
    val steps: List<String>
)

enum class UnitType(val displayName: String) {
    LENGTH("Length"),
    MASS("Mass"),
    FORCE("Force"),
    PRESSURE("Pressure"),
    ENERGY("Energy"),
    POWER("Power"),
    TEMPERATURE("Temperature")
}

data class UnitItem(
    val symbol: String,
    val name: String,
    val toBaseMultiplier: Double // Multiplier to convert to SI base unit
)
