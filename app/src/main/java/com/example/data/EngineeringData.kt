package com.example.data

object EngineeringData {

    // 1. Engineering Fields
    val fields: List<EngineeringField> = listOf(
        EngineeringField(
            id = "civil",
            title = "Civil Engineering",
            shortDescription = "Design and construction of critical public infrastructure, bridges, buildings, roads, and dams.",
            fullDescription = "Civil engineering is one of the oldest engineering disciplines. It focuses on the planning, design, structural analysis, construction, and maintenance of both naturally built environments and physical public works. Civil engineers ensure that human communities have clean water supply, safe transportation arteries, resilient earthquake-proof buildings, flood prevention channels, and sustainable public transit.",
            mainResponsibilities = listOf(
                "Perform structural stress, wind, and seismic load analyses",
                "Design transportation networks, bridges, highways, and tunnels",
                "Manage environmental water resources, treatment, and flood mitigation",
                "Supervise on-site geotechnical surveying and soil load testing",
                "Enforce strict building codes and municipal safety standards"
            ),
            commonTechnologies = listOf(
                "AutoCAD & Civil 3D",
                "Finite Element Analysis (FEA / SAP2000)",
                "GIS (Geographic Information Systems)",
                "Building Information Modeling (BIM / Revit)",
                "Geotechnical Soil Testing Penetrometers"
            ),
            exampleCareers = listOf(
                "Structural Engineer",
                "Geotechnical Engineer",
                "Transportation Planner",
                "Water Resources Engineer",
                "Construction Project Manager"
            ),
            realWorldExamples = listOf(
                "Akashi Kaikyo Suspension Bridge (Japan)",
                "Hoover Dam (USA)",
                "Burj Khalifa structural load core (UAE)",
                "Channel Tunnel (UK - France)"
            ),
            badgeColorHex = 0xFF3A86FF,
            keyHighlight = "Over 70% of modern city infrastructure relies directly on civil engineering integrity."
        ),
        EngineeringField(
            id = "mechanical",
            title = "Mechanical Engineering",
            shortDescription = "Machines, thermodynamic cycles, engines, kinematics, robotics, and advanced manufacturing.",
            fullDescription = "Mechanical engineering applies physical principles of forces, energy, mechanics, materials, and thermodynamics to design, analyze, manufacture, and maintain mechanical systems. From micro-scale MEMS gearboxes and surgical tools to massive industrial gas turbines and hybrid electric powertrains, mechanical engineers drive physical motion and energy conversion.",
            mainResponsibilities = listOf(
                "Design machine mechanisms, linkages, powertrains, and transmissions",
                "Conduct thermal management, CFD fluid flow, and heat transfer simulations",
                "Select durable alloys, composites, and polymers for dynamic stress",
                "Optimize automated CNC machining, 3D printing, and robotics assembly lines",
                "Analyze fatigue life, vibration resonance, and mechanical failure modes"
            ),
            commonTechnologies = listOf(
                "SolidWorks / CATIA 3D CAD",
                "ANSYS CFD (Computational Fluid Dynamics)",
                "MATLAB & Simulink Dynamics",
                "CNC Multi-axis Machining & GD&T",
                "Thermal Imaging & Laser Vibrometers"
            ),
            exampleCareers = listOf(
                "Automotive Systems Engineer",
                "HVAC & Thermal Systems Engineer",
                "Robotics & Automation Specialist",
                "Aerospace Propulsion Designer",
                "Manufacturing Tooling Engineer"
            ),
            realWorldExamples = listOf(
                "Formula 1 Hybrid Turbo V6 Powertrains",
                "General Electric 9HA Gas Turbine",
                "Mars Perseverance Rover Mobility Bogie",
                "High-Speed Maglev Suspension Mechanisms"
            ),
            badgeColorHex = 0xFFFF7B00,
            keyHighlight = "Combines solid mechanics, fluid dynamics, and thermodynamics into real physical motion."
        ),
        EngineeringField(
            id = "electrical",
            title = "Electrical Engineering",
            shortDescription = "Generation, high-voltage transmission, electrical machinery, motors, and power grids.",
            fullDescription = "Electrical engineering powers our electrified civilization. It encompasses the study, design, and implementation of equipment, devices, and systems that use electricity, electromagnetism, and high-power electronics. Electrical engineers manage utility-scale power grids, renewable wind/solar integration, high-voltage transformers, and high-efficiency induction motors.",
            mainResponsibilities = listOf(
                "Design high-voltage substations, transmission lines, and protective relays",
                "Model synchronous generators, AC/DC converters, and electric vehicle inverters",
                "Integrate renewable solar photovoltaic and wind turbine farms into grids",
                "Implement power factor correction and electromagnetic interference (EMI) shielding",
                "Ensure grid frequency stability and smart grid distributed balancing"
            ),
            commonTechnologies = listOf(
                "ETAP & PowerWorld Grid Simulation",
                "MATLAB SimPowerSystems",
                "High-Voltage Oscilloscopes & Power Quality Analyzers",
                "SCADA Utility Control Systems",
                "Solid-State IGBT / SiC Power Modules"
            ),
            exampleCareers = listOf(
                "Power Systems & Grid Engineer",
                "Substation Design Engineer",
                "Electric Drivetrain Specialist",
                "Renewable Energy Project Engineer",
                "High-Voltage Instrumentation Engineer"
            ),
            realWorldExamples = listOf(
                "Three Gorges Dam Ultra-High-Voltage DC Lines",
                "Megawatt Battery Energy Storage Systems (BESS)",
                "Electric Vehicle 800V Drivetrain Inverters",
                "Superconducting Magnetic Energy Storage"
            ),
            badgeColorHex = 0xFF00E5FF,
            keyHighlight = "Powers billions of homes and industries with reliable 50/60Hz AC and high-efficiency DC power."
        ),
        EngineeringField(
            id = "electronics",
            title = "Electronics Engineering",
            shortDescription = "Microcircuits, semiconductors, RF communications, sensors, and embedded signal processors.",
            fullDescription = "Electronics engineering focuses on low-voltage, high-frequency circuits and the nonlinear semiconductor devices that manipulate electrical current for information processing, sensing, and wireless communication. Electronics engineers create the printed circuit boards (PCBs), RF transceivers, amplifiers, and sensor interfaces that power smartphones, medical monitors, and satellites.",
            mainResponsibilities = listOf(
                "Design multi-layer Printed Circuit Boards (PCBs) with impedance matching",
                "Develop analog filters, operational amplifiers, and ADC/DAC converters",
                "Tune RF antennas, Bluetooth, Wi-Fi 7, and 5G millimeter-wave circuits",
                "Interface microcontrollers with optical, MEMS, and acoustic sensors",
                "Perform signal integrity, EMI compliance, and thermal dissipation testing"
            ),
            commonTechnologies = listOf(
                "Altium Designer & KiCad PCB",
                "SPICE (LTspice / PSpice) Circuit Simulators",
                "Spectrum Analyzers & Logic Analyzers",
                "ARM Cortex-M Embedded C/C++",
                "Vector Network Analyzers (VNA)"
            ),
            exampleCareers = listOf(
                "PCB Hardware Design Engineer",
                "RF & Antenna Engineer",
                "Analog IC Circuit Designer",
                "Embedded Firmware Developer",
                "Sensor Integration Specialist"
            ),
            realWorldExamples = listOf(
                "5G Beamforming Phased-Array Antennas",
                "Smartwatch Optical Heart Rate Sensors",
                "Automotive LiDAR and Radar Transceivers",
                "CubeSat Satellite Communication Transponders"
            ),
            badgeColorHex = 0xFF00B4D8,
            keyHighlight = "Bridges the physical world to the digital realm via precision silicon and radio frequency signals."
        ),
        EngineeringField(
            id = "chemical",
            title = "Chemical Engineering",
            shortDescription = "Chemical reactions, large-scale industrial processing, refining, green fuels, and biomaterials.",
            fullDescription = "Chemical engineering translates laboratory molecular chemistry into cost-effective, sustainable, industrial-scale manufacturing processes. Chemical engineers design distillation columns, continuous chemical reactors, heat exchanger networks, and separation systems to produce clean drinking water, pharmaceuticals, fertilizers, polymers, and synthetic renewable fuels.",
            mainResponsibilities = listOf(
                "Design continuous catalytic reactors, distillation towers, and crystallization units",
                "Model mass and energy conservation balances in complex reaction networks",
                "Develop carbon capture and industrial emissions scrubbers",
                "Optimize biochemical fermentation for insulin and monoclonal antibodies",
                "Implement Process Safety Management (HAZOP) and toxic containment protocols"
            ),
            commonTechnologies = listOf(
                "Aspen Plus & HYSYS Process Simulators",
                "Gas Chromatography & Mass Spectrometry",
                "Continuous Flow Catalytic Reactors",
                "Membrane Bioreactors & Reverse Osmosis",
                "Industrial PLC Process Controllers"
            ),
            exampleCareers = listOf(
                "Process Design Engineer",
                "Petrochemical & Refining Engineer",
                "Biopharmaceutical Scale-Up Scientist",
                "Polymer & Plastics Engineer",
                "Environmental Compliance Specialist"
            ),
            realWorldExamples = listOf(
                "Haber-Bosch Ammonia Synthesis (Feeds half the global population)",
                "Lithium-ion Battery Cathode Refining",
                "Seawater Desalination Plants",
                "Biodegradable PLA Polymer Synthesis"
            ),
            badgeColorHex = 0xFFEF4444,
            keyHighlight = "Transforms raw molecules into vital commodities, life-saving medicines, and sustainable fuels."
        ),
        EngineeringField(
            id = "computer",
            title = "Computer Engineering",
            shortDescription = "Microprocessor architecture, SoC silicon, hardware-software co-design, and real-time computing.",
            fullDescription = "Computer engineering sits directly at the intersection of electrical engineering and computer science. Computer engineers design microprocessors, GPU shader cores, System-on-Chips (SoCs), FPGA logic, and low-level firmware that enable computers, mobile phones, neural network accelerators, and real-time mission-critical avionics.",
            mainResponsibilities = listOf(
                "Design logic circuits and digital microarchitectures using HDL (Verilog/VHDL)",
                "Optimize pipelined CPUs, cache memory hierarchies, and bus protocols (PCIe/AXI)",
                "Synthesize FPGA accelerators for real-time edge artificial intelligence",
                "Write low-level bootloaders, device drivers, and real-time operating systems (RTOS)",
                "Verify silicon design timing constraints and quantum tunneling leakage"
            ),
            commonTechnologies = listOf(
                "Verilog / SystemVerilog & VHDL",
                "Synopsys & Cadence EDA Silicon Tools",
                "Xilinx / Altera FPGA Vivado Toolchains",
                "RISC-V and ARM Architecture ISAs",
                "FreeRTOS & Embedded Linux Kernels"
            ),
            exampleCareers = listOf(
                "Silicon Architecture Engineer",
                "FPGA Logic Design Engineer",
                "Embedded Systems Developer",
                "Hardware Verification Engineer",
                "AI Hardware Acceleration Engineer"
            ),
            realWorldExamples = listOf(
                "Apple M-Series & Qualcomm Snapdragon SoCs",
                "NVIDIA Tensor Core AI Accelerators",
                "Tesla Full Self-Driving Neural Hardware",
                "Spacecraft Rad-Hardened Flight Computers"
            ),
            badgeColorHex = 0xFF8B5CF6,
            keyHighlight = "Creates the silicon brains and embedded logic running billions of computing devices."
        ),
        EngineeringField(
            id = "environmental",
            title = "Environmental Engineering",
            shortDescription = "Water purification, air pollution control, waste management, circular economy, and ecological restoration.",
            fullDescription = "Environmental engineering integrates principles of engineering, chemistry, biology, and ecology to devise sustainable solutions for environmental sanitation, global greenhouse gas abatement, hazardous waste remediation, and ecosystem revitalization. They ensure municipal drinking water safety and protect biodiversity.",
            mainResponsibilities = listOf(
                "Design multi-stage wastewater treatment and advanced UV oxidation plants",
                "Engineer air scrubbing systems for industrial SOx, NOx, and particulate capture",
                "Model watershed hydrologic flows and pollutant plume migration in aquifers",
                "Design sanitary landfills with composite geomembrane leachate containment",
                "Conduct life cycle carbon assessments (LCA) for industrial operations"
            ),
            commonTechnologies = listOf(
                "EPA SWMM Hydrologic Modeling",
                "Membrane Bioreactors (MBR)",
                "Wet Electrostatic Precipitators",
                "Gas Chromatography Plume Trackers",
                "Bio-filtration and Constructed Wetlands"
            ),
            exampleCareers = listOf(
                "Water Treatment Process Engineer",
                "Air Quality Specialist",
                "Hazardous Waste Remediation Manager",
                "Sustainability Consultant",
                "Ecosystem Restoration Planner"
            ),
            realWorldExamples = listOf(
                "Singapore NEWater Advanced Reclamation System",
                "Direct Air CO2 Capture & Sequestration Facilities",
                "Municipal Landfill Methane-to-Electricity Plants",
                "Thames Tideway Super Sewer Tunnel (London)"
            ),
            badgeColorHex = 0xFF10B981,
            keyHighlight = "Protects public health and planetary ecosystems through science-based sustainability."
        ),
        EngineeringField(
            id = "aerospace",
            title = "Aerospace Engineering",
            shortDescription = "Aviation, supersonic aerodynamics, orbital rocketry, satellite systems, and space exploration.",
            fullDescription = "Aerospace engineering encompasses the primary field of engineering concerned with the research, design, development, construction, testing, and science and technology of aircraft (Aeronautical) and spacecraft (Astronautical). Aerospace engineers tackle extreme thermodynamic environments, hypersonic airflow, weight reduction, and orbital orbital mechanics.",
            mainResponsibilities = listOf(
                "Calculate compressible aerodynamic drag, supersonic shock waves, and airfoil lift",
                "Design lightweight carbon-composite airframes and cryogenic rocket fuel tanks",
                "Model orbital orbital mechanics, Hohmann transfer orbits, and re-entry thermal loads",
                "Integrate fly-by-wire flight control laws and autonomous navigation avionics",
                "Perform wind tunnel pressure mapping and jet engine acoustic vibration tests"
            ),
            commonTechnologies = listOf(
                "NASA OpenVSP & CFL3D Flow Solvers",
                "Composite Autoclaves & Carbon Fiber Weaves",
                "Liquid Rocket Turbopumps & Regenerative Cooling",
                "Inertial Measurement Units (Ring Laser Gyros)",
                "Spacecraft Thermal Vacuum Chambers"
            ),
            exampleCareers = listOf(
                "Aerodynamics & CFD Engineer",
                "Propulsion Systems Specialist",
                "Guidance, Navigation & Control (GNC) Engineer",
                "Structural Stress Analyst",
                "Space Mission Trajectory Planner"
            ),
            realWorldExamples = listOf(
                "SpaceX Falcon 9 Reusable Rocket Booster",
                "Boeing 787 Dreamliner Composite Airframe",
                "James Webb Space Telescope Cryogenic Sunshield",
                "Lockheed SR-71 Blackbird Mach 3+ Inlets"
            ),
            badgeColorHex = 0xFF00E5FF,
            keyHighlight = "Conquers atmospheric flight and propels humanity across planetary orbits."
        ),
        EngineeringField(
            id = "industrial",
            title = "Industrial Engineering",
            shortDescription = "Process optimization, lean manufacturing, supply chain logistics, quality engineering, and ergonomics.",
            fullDescription = "Industrial engineering is concerned with the optimization of complex processes, systems, or organizations by developing, improving, and implementing integrated systems of people, money, knowledge, information, equipment, energy, and materials. Industrial engineers eliminate bottlenecks, reduce waste (Lean/Six Sigma), and maximize operational throughput.",
            mainResponsibilities = listOf(
                "Conduct time-and-motion studies and value stream mapping to eliminate process waste",
                "Design ergonomic factory assembly workstations to prevent operator injury",
                "Model dynamic stochastic queuing systems and supply chain logistics networks",
                "Implement Statistical Process Control (SPC) for Six Sigma zero-defect manufacturing",
                "Optimize warehouse robotic sorting routes and automated inventory replenishment"
            ),
            commonTechnologies = listOf(
                "Arena & AnyLogic Discrete-Event Simulation",
                "Lean Six Sigma DMAIC Methodology",
                "Statistical Process Control (SPC / Minitab)",
                "Automated Guided Vehicle (AGV) Fleet Routing",
                "ERP Systems (SAP / Enterprise Resource Planning)"
            ),
            exampleCareers = listOf(
                "Supply Chain Optimization Engineer",
                "Continuous Improvement / Lean Manager",
                "Quality Assurance & Reliability Engineer",
                "Operations Research Analyst",
                "Human Factors & Ergonomics Engineer"
            ),
            realWorldExamples = listOf(
                "Toyota Production System (Just-in-Time)",
                "Amazon Fulfillment Center Kiva Robotics",
                "Hospital Emergency Department Flow Optimization",
                "Global Air Cargo Route Network Scheduling"
            ),
            badgeColorHex = 0xFFF59E0B,
            keyHighlight = "Maximizes efficiency, human safety, and economic value across massive industrial operations."
        ),
        EngineeringField(
            id = "biomedical",
            title = "Biomedical Engineering",
            shortDescription = "Medical devices, artificial organs, biomechanics, neural prosthetics, and diagnostic imaging.",
            fullDescription = "Biomedical engineering bridges engineering principles with biological sciences and medical practice to advance human health care. Biomedical engineers develop artificial heart valves, MRI/CT scanners, robotic surgical instruments, biocompatible orthopedic implants, and neural prostheses that interface directly with the human nervous system.",
            mainResponsibilities = listOf(
                "Design biocompatible titanium/ceramic hip implants and bioresorbable stents",
                "Develop medical imaging signal processing algorithms for MRI and Ultrasound",
                "Create closed-loop robotic surgical arms with sub-millimeter haptic feedback",
                "Model cardiovascular fluid dynamics through stenosed arterial grafts",
                "Ensure rigorous ISO 13485 and FDA medical device biocompatibility compliance"
            ),
            commonTechnologies = listOf(
                "Bio-CAD & Micro-CT Anatomical Modeling",
                "Electrocardiogram (ECG/EEG) Signal Amplifiers",
                "Biocompatible Titanium 3D Sintering",
                "Microfluidic Lab-on-a-Chip Diagnostic Chips",
                "Bioreactor Cell Culturing Chambers"
            ),
            exampleCareers = listOf(
                "Medical Device Design Engineer",
                "Biomechanics & Orthopedics Specialist",
                "Clinical Systems Engineer",
                "Neural Interface Researcher",
                "Biomaterials Development Scientist"
            ),
            realWorldExamples = listOf(
                "Da Vinci Robotic Surgical System",
                "Implantable Cardiac Pacemakers & Defibrillators",
                "Bionic Myoelectric Prosthetic Limbs",
                "Continuous Glucose Monitors (CGM) with Auto-Insulin Pumps"
            ),
            badgeColorHex = 0xFFEC4899,
            keyHighlight = "Directly saves lives by applying rigorous engineering to human biology and medicine."
        )
    )

    // 2. Engineering Concepts
    val concepts: List<EngineeringConcept> = listOf(
        // Physics & Mechanics
        EngineeringConcept(
            id = "force",
            name = "Force",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "A push or pull upon an object resulting from its interaction with another object.",
            formula = "F = m × a",
            units = "Newton (N) [1 N = 1 kg·m/s²]",
            simpleExplanation = "Imagine pushing a shopping cart. The harder you push (force) and the lighter it is (mass), the quicker it speeds up (acceleration). Without an unbalanced force, moving objects keep moving and resting objects stay still.",
            example = "Accelerating a 1,200 kg car at 2.5 m/s² requires an engine driving force of 3,000 N.",
            engineeringApplication = "Structural engineers calculate wind and seismic forces on skyscrapers to ensure steel frames do not buckle.",
            keyInsight = "Forces always occur in equal and opposite pairs (Newton's 3rd Law)."
        ),
        EngineeringConcept(
            id = "velocity",
            name = "Velocity",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The rate of change of displacement with respect to time, including both speed and direction.",
            formula = "v = Δx / Δt",
            units = "Meters per second (m/s) or km/h",
            simpleExplanation = "Speed tells you how fast you are moving (e.g. 60 mph), but velocity also tells you which direction you are traveling (e.g. 60 mph North). Direction matters immensely in engineering!",
            example = "A drone flying 500 meters East in 25 seconds has a velocity of 20 m/s East.",
            engineeringApplication = "Fluid engineers track fluid velocity profiles in pipelines to prevent turbulent erosion and cavitation.",
            keyInsight = "A car turning a circular corner at constant speed still accelerates because its velocity direction changes."
        ),
        EngineeringConcept(
            id = "acceleration",
            name = "Acceleration",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The rate at which an object changes its velocity over time.",
            formula = "a = (v_f - v_i) / t",
            units = "Meters per second squared (m/s²)",
            simpleExplanation = "Acceleration is how rapidly your speed or direction changes. When you slam the gas pedal or hit the brakes, you feel your body pressed into or away from the seat—that feeling is acceleration.",
            example = "An electric car going from 0 to 28 m/s (100 km/h) in 3.5 seconds experiences 8.0 m/s² average acceleration.",
            engineeringApplication = "Roller coaster engineers limit centripetal acceleration to 4G to prevent passenger blackout and neck strain.",
            keyInsight = "Deceleration is simply negative acceleration in the chosen coordinate frame."
        ),
        EngineeringConcept(
            id = "work",
            name = "Work",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The measure of energy transfer that occurs when an object is moved over a distance by an external force.",
            formula = "W = F × d × cos(θ)",
            units = "Joule (J) [1 J = 1 N·m]",
            simpleExplanation = "Holding a heavy 50 kg barbell above your head feels exhausting, but in physics you do zero mechanical work unless the barbell actually moves through a distance in the direction of the force.",
            example = "Lifting a 200 N motor vertically upward by 3 meters does W = 200 × 3 = 600 Joules of work.",
            engineeringApplication = "Crane designers size hydraulic actuators based on total work required to lift cargo containers at container ports.",
            keyInsight = "Work equals the area under the Force vs. Displacement curve."
        ),
        EngineeringConcept(
            id = "energy",
            name = "Energy",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The quantitative property that must be transferred to a body to perform work or produce heat.",
            formula = "E_total = KE + PE + Internal Energy",
            units = "Joule (J) [1 kWh = 3.6 × 10⁶ J]",
            simpleExplanation = "Energy is the currency of the universe. It cannot be created or destroyed, only converted from one form (like chemical energy in gasoline or potential energy in a reservoir) into another (like kinetic motion or electrical power).",
            example = "Hydroelectric dams convert gravitational potential energy (water high up) into kinetic energy of spinning turbines, then electrical energy.",
            engineeringApplication = "Renewable energy engineers optimize round-trip energy efficiency in pumped-hydro and battery storage systems.",
            keyInsight = "Conservation of Energy is the single most fundamental law across all engineering domains."
        ),
        EngineeringConcept(
            id = "power",
            name = "Power",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The rate at which work is performed or energy is converted per unit of time.",
            formula = "P = W / t",
            units = "Watt (W) [1 W = 1 J/s; 1 Horsepower ≈ 746 W]",
            simpleExplanation = "Two cranes can lift the same 10-ton beam (doing identical work), but the crane that lifts it in 10 seconds has 6 times the power of the one taking 60 seconds.",
            example = "A winch doing 12,000 J of work in 4 seconds delivers 3,000 Watts (3 kW) of power.",
            engineeringApplication = "Automotive and aerospace engineers balance peak power output against cooling system weight and fuel consumption.",
            keyInsight = "Power is work divided by time, or force multiplied by velocity (P = F × v)."
        ),
        EngineeringConcept(
            id = "momentum",
            name = "Momentum",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The product of the mass and velocity of an object, representing its quantity of motion.",
            formula = "p = m × v",
            units = "Kilogram meter per second (kg·m/s)",
            simpleExplanation = "A heavy freight train moving at 5 mph has massive momentum because of its huge mass; a tiny bullet also has high momentum because of its extreme velocity. Both are very hard to stop.",
            example = "A 1,500 kg truck driving at 20 m/s has a linear momentum of 30,000 kg·m/s.",
            engineeringApplication = "Crash safety engineers design crumple zones to lengthen the collision impact time, drastically reducing peak impact force (Impulse = Δp = F × Δt).",
            keyInsight = "In any closed collision without external forces, total momentum before equals total momentum after."
        ),
        EngineeringConcept(
            id = "torque",
            name = "Torque",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "A rotational force that tends to cause rotation about an axis or pivot point.",
            formula = "τ = F × r × sin(θ)",
            units = "Newton-meter (N·m)",
            simpleExplanation = "Trying to loosen a rusted bolt with a short wrench is hard, but using a long wrench makes it easy. The longer lever arm multiplies your rotational twisting effect (torque).",
            example = "Applying 150 N perpendicular to a 0.4 meter wrench generates τ = 150 × 0.4 = 60 N·m of torque.",
            engineeringApplication = "Gearbox designers match engine torque to wheel torque so heavy trucks can climb steep grades carrying heavy freight.",
            keyInsight = "Torque is the rotational equivalent of linear force."
        ),
        EngineeringConcept(
            id = "pressure",
            name = "Pressure",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "The continuous physical force exerted per unit area perpendicularly on a surface.",
            formula = "P = F / A",
            units = "Pascal (Pa) [1 Pa = 1 N/m²; 1 bar = 100,000 Pa]",
            simpleExplanation = "Standing on soft snow in regular boots makes you sink because your weight is concentrated on a small area. Snowshoes spread the exact same force over a huge area, reducing pressure so you stay on top.",
            example = "A 500 N force distributed across an area of 0.02 m² produces a pressure of 25,000 Pa (25 kPa).",
            engineeringApplication = "Hydraulic brakes use Pascal's principle (pressure in a fluid is transmitted equally everywhere) to let your foot easily stop a 2-ton vehicle.",
            keyInsight = "Atmospheric pressure at sea level is approximately 101,325 Pa (1 atm or 14.7 psi)."
        ),
        EngineeringConcept(
            id = "stress_strain",
            name = "Stress & Strain",
            category = ConceptCategory.PHYSICS_MECHANICS,
            definition = "Stress is internal force per cross-sectional area (σ = F/A). Strain is fractional deformation (ε = ΔL/L₀).",
            formula = "σ = E × ε (Hooke's Law)",
            units = "Stress in Pascal (MPa), Strain is dimensionless",
            simpleExplanation = "When you stretch a rubber band, the pulling force divided by rubber thickness is stress; the percentage it stretches is strain. If you pull too hard past its yield point, it snaps permanently.",
            example = "A steel cable under 50 kN tension with a 200 mm² cross-section experiences a stress of 250 MPa.",
            engineeringApplication = "Civil engineers ensure structural columns never exceed allowable working stress under maximum building occupancy.",
            keyInsight = "Young's Modulus (E) is the slope of the stress-strain curve, measuring material stiffness."
        ),

        // Electricity Concepts
        EngineeringConcept(
            id = "voltage",
            name = "Voltage (Electric Potential)",
            category = ConceptCategory.ELECTRICITY,
            definition = "The electric potential difference between two points, representing the work needed to move a unit charge.",
            formula = "V = W / Q  or  V = I × R",
            units = "Volt (V) [1 V = 1 Joule / Coulomb]",
            simpleExplanation = "Think of voltage like water pressure in a garden hose. High water pressure pushes water through narrow pipes; high voltage pushes electrons through resistive wires.",
            example = "A standard AA alkaline battery maintains 1.5 V between its positive and negative terminals.",
            engineeringApplication = "Power companies step voltage up to 500,000 V for cross-country transmission because high voltage dramatically lowers current, reducing heat losses in cables.",
            keyInsight = "Voltage is always measured BETWEEN two points (differential), never at a single isolated point."
        ),
        EngineeringConcept(
            id = "current",
            name = "Electric Current",
            category = ConceptCategory.ELECTRICITY,
            definition = "The rate of flow of electric charge through a conductor per unit of time.",
            formula = "I = Q / t  or  I = V / R",
            units = "Ampere (A) [1 A = 1 Coulomb/second = 6.24 × 10¹⁸ electrons/sec]",
            simpleExplanation = "If voltage is the water pressure, current is the actual volume of water flowing through the pipe per second. More electrons passing through each second means higher current.",
            example = "A 60 W light bulb on a 120 V household circuit draws I = 60 / 120 = 0.5 Amperes of current.",
            engineeringApplication = "Circuit breaker designers size breakers (e.g. 15A, 20A) to automatically trip before excessive current overheats wires and causes house fires.",
            keyInsight = "Current always takes every available path in inverse proportion to resistance."
        ),
        EngineeringConcept(
            id = "resistance",
            name = "Electrical Resistance",
            category = ConceptCategory.ELECTRICITY,
            definition = "A measure of the opposition to the flow of electric current in a conductor.",
            formula = "R = ρ × (L / A)",
            units = "Ohm (Ω)",
            simpleExplanation = "Like a kink in a hose or gravel inside a pipe restricting water flow, resistance opposes electron movement, converting electrical energy into heat.",
            example = "An electric space heater heating element with 12 Ω resistance connected to 120 V draws 10 A and produces 1,200 W of warmth.",
            engineeringApplication = "Electronics engineers use precise surface-mount resistors to set exact bias voltages for sensitive microchips and audio amplifiers.",
            keyInsight = "Thicker wires have less resistance; longer wires have more resistance."
        ),
        EngineeringConcept(
            id = "ohms_law",
            name = "Ohm's Law",
            category = ConceptCategory.ELECTRICITY,
            definition = "Current through a conductor between two points is directly proportional to voltage and inversely proportional to resistance.",
            formula = "V = I × R   (I = V/R, R = V/I)",
            units = "V in Volts, I in Amps, R in Ohms",
            simpleExplanation = "If you double the voltage, you double the current. If you double the resistance, you cut the current in half. It is the cornerstone equation of electrical design.",
            example = "Connecting a 100 Ω resistor across a 5 V USB supply produces I = 5 / 100 = 0.05 A (50 mA).",
            engineeringApplication = "Used millions of times daily in calculating pull-up resistors, LED current-limiting resistors, and power supply regulation.",
            keyInsight = "Only holds for linear (ohmic) materials where resistance is independent of applied voltage."
        ),
        EngineeringConcept(
            id = "circuits_series_parallel",
            name = "Series vs. Parallel Circuits",
            category = ConceptCategory.ELECTRICITY,
            definition = "In series, components share the same current (R_total = R1 + R2). In parallel, components share the same voltage (1/R_total = 1/R1 + 1/R2).",
            formula = "Series: R_eq = Σ R_i  |  Parallel: 1/R_eq = Σ (1/R_i)",
            units = "Ohms (Ω)",
            simpleExplanation = "In old Christmas lights wired in series, if one bulb burned out, the entire string went dark. Modern home outlets are wired in parallel, so turning off your toaster does not turn off your TV!",
            example = "Two 10 Ω resistors in series make 20 Ω. In parallel, they make 5 Ω.",
            engineeringApplication = "Battery packs in electric cars combine cells in series to achieve high voltage (400V - 800V) and in parallel to achieve massive capacity (Amp-hours).",
            keyInsight = "Current is identical everywhere in a series loop; voltage is identical across all parallel branches."
        ),
        EngineeringConcept(
            id = "kirchhoffs_laws",
            name = "Kirchhoff's Circuit Laws",
            category = ConceptCategory.ELECTRICITY,
            definition = "KCL: Total current entering a junction equals current leaving (Σ I = 0). KVL: Sum of voltage drops around any closed loop is zero (Σ V = 0).",
            formula = "KCL: Σ I_in = Σ I_out  |  KVL: Σ V_loop = 0",
            units = "Amps for KCL, Volts for KVL",
            simpleExplanation = "KCL means electrons can't magically pile up or disappear at a wire junction (Conservation of Charge). KVL means energy gained from batteries equals energy lost across components around a loop.",
            example = "If 5 A enters a wire junction and 3 A leaves through one wire, exactly 2 A must leave through the other.",
            engineeringApplication = "All circuit simulation software (like SPICE) uses matrix implementations of Kirchhoff's Laws to solve multi-million node microchip circuits.",
            keyInsight = "Direct manifestations of Conservation of Charge and Conservation of Energy in electrical circuits."
        ),
        EngineeringConcept(
            id = "electromagnetic_induction",
            name = "Electromagnetic Induction",
            category = ConceptCategory.ELECTRICITY,
            definition = "The generation of an electromotive force (voltage) across an electrical conductor in a changing magnetic field.",
            formula = "EMF = -N × (dΦ_B / dt)  (Faraday's Law)",
            units = "Volts (V)",
            simpleExplanation = "When you spin a coil of wire near a magnet, the moving magnetic field forces electrons through the wire, generating electricity. This is how almost all power on Earth is generated!",
            example = "Hydroelectric turbines, wind turbines, and coal generators all spin wire coils inside magnetic fields to create AC grid power.",
            engineeringApplication = "Transformers use electromagnetic induction to step voltages up or down with over 98% efficiency without any moving parts.",
            keyInsight = "The negative sign (Lenz's Law) states that induced current opposes the change in magnetic flux that produced it."
        ),

        // Thermodynamics Concepts
        EngineeringConcept(
            id = "temperature_heat",
            name = "Temperature vs. Heat",
            category = ConceptCategory.THERMODYNAMICS,
            definition = "Temperature is the average kinetic energy of molecules (°C or K). Heat is the thermal energy transferred due to temperature difference (J).",
            formula = "Q = m × c × ΔT",
            units = "Temperature in Kelvin (K) or °C; Heat in Joules (J)",
            simpleExplanation = "A tiny spark from a sparkler can be at 1,000°C (high temperature) but contains very little heat energy and won't warm a room. A huge swimming pool at 25°C has lower temperature but holds enormous heat energy.",
            example = "Heating 2 kg of water by 20°C requires Q = 2 × 4184 × 20 = 167,360 J of heat energy.",
            engineeringApplication = "Cooling tower engineers calculate heat rejection rates from nuclear and gas power plants into the atmosphere.",
            keyInsight = "Heat always flows spontaneously from higher temperature to lower temperature (2nd Law of Thermodynamics)."
        ),
        EngineeringConcept(
            id = "heat_transfer",
            name = "Conduction, Convection & Radiation",
            category = ConceptCategory.THERMODYNAMICS,
            definition = "Conduction transfers heat through direct contact; Convection transfers heat via moving fluids; Radiation transfers heat via electromagnetic waves.",
            formula = "Conduction: q = -k·A·(dT/dx) | Radiation: P = ε·σ·A·T⁴",
            units = "Heat flux in Watts (W) or W/m²",
            simpleExplanation = "Touching a hot metal pan burns you via conduction. Boiling water circulating in a pot is convection. Feeling the warm sun on your face through the vacuum of space is radiation.",
            example = "A double-pane window uses an argon gas gap to suppress conduction and a reflective low-e coating to block infrared radiation.",
            engineeringApplication = "Spacecraft thermal engineers use reflective gold mylar insulation blankets to protect satellites from extreme 200°C orbital radiation swings.",
            keyInsight = "Radiation requires no medium and can travel through the vacuum of outer space."
        ),
        EngineeringConcept(
            id = "thermal_efficiency",
            name = "Thermal Efficiency & Carnot Limit",
            category = ConceptCategory.THERMODYNAMICS,
            definition = "The ratio of useful mechanical work produced to total thermal energy input, bounded by the theoretical Carnot limit.",
            formula = "η = W_out / Q_in  |  η_Carnot = 1 - (T_cold / T_hot)",
            units = "Percentage (%) or fraction (0.0 to 1.0)",
            simpleExplanation = "No heat engine can ever turn 100% of heat into work; some heat MUST always be rejected to a cold reservoir. The bigger the temperature difference, the higher the maximum possible efficiency.",
            example = "A combined-cycle gas turbine operating between 1500°C (1773 K) and 30°C (303 K) has a theoretical Carnot limit of 1 - (303/1773) = 82.9%, achieving ~62% in reality.",
            engineeringApplication = "Power plant engineers operate boilers at extreme temperatures and pressures to maximize fuel efficiency and reduce carbon emissions.",
            keyInsight = "The Second Law of Thermodynamics proves perpetual motion machines of the second kind are physically impossible."
        ),

        // Materials Concepts
        EngineeringConcept(
            id = "density_mat",
            name = "Density",
            category = ConceptCategory.MATERIALS,
            definition = "The mass of a substance per unit of volume, indicating how tightly packed its atoms are.",
            formula = "ρ = m / V",
            units = "kg/m³ or g/cm³ [Water = 1,000 kg/m³ = 1.0 g/cm³]",
            simpleExplanation = "A block of styrofoam and a block of lead of identical size have vastly different weights because lead has a much higher density.",
            example = "Aluminum has a density of 2,700 kg/m³, while steel is ~7,850 kg/m³—nearly 3 times heavier!",
            engineeringApplication = "Aerospace engineers choose lightweight titanium and carbon fiber to reduce aircraft weight, directly cutting fuel burn.",
            keyInsight = "Objects float in a fluid if their average density is less than the fluid's density."
        ),
        EngineeringConcept(
            id = "elasticity_ductility",
            name = "Elasticity & Ductility",
            category = ConceptCategory.MATERIALS,
            definition = "Elasticity is the ability to return to original shape after unloading. Ductility is the ability to deform plastically without fracturing.",
            formula = "Elastic Limit & % Elongation = (L_final - L_0) / L_0 × 100%",
            units = "Modulus in GPa, Ductility in %",
            simpleExplanation = "A rubber band is highly elastic (springs back). Copper is ductile (can be stretched into long thin electrical wires without snapping). Chalk is brittle (breaks with zero warning when bent).",
            example = "Structural steel can elongate over 20% before breaking, giving engineers visible warning before building collapse.",
            engineeringApplication = "Earthquake-resistant buildings are designed with ductile steel reinforcement so joints bend safely during tremors rather than shattering.",
            keyInsight = "Brittle materials (like glass or ceramics) fail catastrophically without noticeable prior deformation."
        ),
        EngineeringConcept(
            id = "conductivity",
            name = "Electrical & Thermal Conductivity",
            category = ConceptCategory.MATERIALS,
            definition = "The intrinsic property of a material measuring its ease in conducting electric charge (σ) or heat (k).",
            formula = "Electrical: σ = 1 / ρ_resistivity | Thermal: k in W/(m·K)",
            units = "Electrical: Siemens/meter (S/m); Thermal: W/(m·K)",
            simpleExplanation = "Metals like copper and silver have a sea of free electrons, making them fantastic conductors of both electricity and heat. Plastics and ceramics trap electrons, making them excellent insulators.",
            example = "Copper has high thermal conductivity (400 W/m·K) and electrical conductivity (5.96 × 10⁷ S/m), making it ideal for heatsinks and wiring.",
            engineeringApplication = "CPU heatsinks use copper heat pipes combined with aluminum fins to rapidly conduct heat away from silicon processor dies.",
            keyInsight = "The Wiedemann-Franz Law shows that good electrical conductors are almost always good thermal conductors."
        )
    )

    // 3. Formula Library
    val formulas: List<FormulaItem> = listOf(
        FormulaItem(
            id = "f_ohms_law",
            name = "Ohm's Law",
            category = FormulaCategory.ELECTRICITY,
            equation = "V = I × R",
            variableMeanings = listOf(
                "V" to "Voltage / Electrical Potential (Volts, V)",
                "I" to "Electric Current (Amperes, A)",
                "R" to "Electrical Resistance (Ohms, Ω)"
            ),
            siUnits = "Volts (V)",
            whenUsed = "Determining voltage, current, or resistance in any DC circuit or resistive AC load.",
            simpleExample = "Find voltage when a current of 2.5 A flows through a 40 Ω heating coil.",
            calculationStep = "V = I × R = (2.5 A) × (40 Ω) = 100 V",
            calculatorType = CalculatorType.OHMS_LAW
        ),
        FormulaItem(
            id = "f_elec_power",
            name = "Electrical Power (Joule's Law)",
            category = FormulaCategory.ELECTRICITY,
            equation = "P = V × I = I² × R = V² / R",
            variableMeanings = listOf(
                "P" to "Electrical Power (Watts, W)",
                "V" to "Voltage (Volts, V)",
                "I" to "Current (Amperes, A)",
                "R" to "Resistance (Ohms, Ω)"
            ),
            siUnits = "Watts (W) [1 W = 1 J/s]",
            whenUsed = "Sizing power supplies, calculating battery drain, and determining thermal heat dissipation.",
            simpleExample = "Calculate power consumed by an appliance drawing 8 A at 120 V.",
            calculationStep = "P = V × I = 120 V × 8 A = 960 W (0.96 kW)",
            calculatorType = CalculatorType.ELECTRICAL_POWER
        ),
        FormulaItem(
            id = "f_force",
            name = "Newton's Second Law of Motion",
            category = FormulaCategory.MECHANICS,
            equation = "F = m × a",
            variableMeanings = listOf(
                "F" to "Net Force vector (Newtons, N)",
                "m" to "Mass of the object (Kilograms, kg)",
                "a" to "Acceleration vector (Meters per second squared, m/s²)"
            ),
            siUnits = "Newtons (N) [1 N = 1 kg·m/s²]",
            whenUsed = "Calculating required thrust, braking forces, structural dynamics, and projectile motion.",
            simpleExample = "Determine force needed to accelerate a 1,500 kg electric vehicle at 4 m/s².",
            calculationStep = "F = m × a = 1,500 kg × 4 m/s² = 6,000 N (6 kN)",
            calculatorType = CalculatorType.FORCE
        ),
        FormulaItem(
            id = "f_work",
            name = "Mechanical Work",
            category = FormulaCategory.MECHANICS,
            equation = "W = F × d × cos(θ)",
            variableMeanings = listOf(
                "W" to "Work done (Joules, J)",
                "F" to "Applied Force magnitude (Newtons, N)",
                "d" to "Displacement distance (Meters, m)",
                "θ" to "Angle between force and displacement vectors (degrees)"
            ),
            siUnits = "Joules (J) [1 J = 1 N·m]",
            whenUsed = "Calculating energy transferred by elevators, winches, piston strokes, and vehicle towing.",
            simpleExample = "A hoist applies 800 N vertically to lift an engine block 2.5 m straight up (θ = 0°).",
            calculationStep = "W = F × d × cos(0°) = 800 N × 2.5 m × 1.0 = 2,000 Joules (2 kJ)",
            calculatorType = CalculatorType.WORK
        ),
        FormulaItem(
            id = "f_power_mech",
            name = "Mechanical Power",
            category = FormulaCategory.MECHANICS,
            equation = "P = W / t = F × v",
            variableMeanings = listOf(
                "P" to "Power rate (Watts, W)",
                "W" to "Work performed (Joules, J)",
                "t" to "Elapsed time (Seconds, s)",
                "v" to "Velocity along force direction (m/s)"
            ),
            siUnits = "Watts (W) [745.7 W = 1 Horsepower]",
            whenUsed = "Selecting motor horsepower, sizing industrial generators, and rating engine output.",
            simpleExample = "An industrial crane lifts a 5,000 J load in 2 seconds.",
            calculationStep = "P = W / t = 5,000 J / 2 s = 2,500 W (2.5 kW ≈ 3.35 hp)",
            calculatorType = CalculatorType.POWER
        ),
        FormulaItem(
            id = "f_density",
            name = "Density Formula",
            category = FormulaCategory.MATERIALS,
            equation = "ρ = m / V",
            variableMeanings = listOf(
                "ρ" to "Density (kg/m³)",
                "m" to "Mass of material sample (kg)",
                "V" to "Volume occupied (m³)"
            ),
            siUnits = "Kilograms per cubic meter (kg/m³)",
            whenUsed = "Identifying materials, calculating buoyancy, ship stability, and payload weight.",
            simpleExample = "A cast metal block has a mass of 54 kg and occupies 0.02 m³.",
            calculationStep = "ρ = m / V = 54 kg / 0.02 m³ = 2,700 kg/m³ (Identified as Aluminum)",
            calculatorType = CalculatorType.DENSITY
        ),
        FormulaItem(
            id = "f_pressure",
            name = "Pressure Formula",
            category = FormulaCategory.FLUIDS,
            equation = "P = F / A",
            variableMeanings = listOf(
                "P" to "Pressure exerted (Pascals, Pa)",
                "F" to "Normal perpendicular force (Newtons, N)",
                "A" to "Contact Surface Area (Square meters, m²)"
            ),
            siUnits = "Pascals (Pa) [1 bar = 100,000 Pa; 1 MPa = 10⁶ Pa]",
            whenUsed = "Designing hydraulic pistons, pressure vessels, pneumatic valves, and building footings.",
            simpleExample = "A hydraulic cylinder applies 45,000 N over a piston face of 0.015 m².",
            calculationStep = "P = F / A = 45,000 N / 0.015 m² = 3,000,000 Pa (3.0 MPa / 30 bar)",
            calculatorType = CalculatorType.PRESSURE
        ),
        FormulaItem(
            id = "f_kinetic_energy",
            name = "Kinetic Energy",
            category = FormulaCategory.MECHANICS,
            equation = "KE = ½ × m × v²",
            variableMeanings = listOf(
                "KE" to "Kinetic Energy of moving mass (Joules, J)",
                "m" to "Mass of moving body (Kilograms, kg)",
                "v" to "Speed of body (Meters per second, m/s)"
            ),
            siUnits = "Joules (J)",
            whenUsed = "Brake stopping distance analysis, impact crash dynamics, and flywheel energy storage.",
            simpleExample = "Find kinetic energy of a 1,200 kg car traveling at 25 m/s (90 km/h).",
            calculationStep = "KE = 0.5 × 1,200 kg × (25 m/s)² = 0.5 × 1,200 × 625 = 375,000 Joules (375 kJ)",
            calculatorType = CalculatorType.KINETIC_ENERGY
        ),
        FormulaItem(
            id = "f_potential_energy",
            name = "Gravitational Potential Energy",
            category = FormulaCategory.MECHANICS,
            equation = "PE = m × g × h",
            variableMeanings = listOf(
                "PE" to "Potential Energy stored (Joules, J)",
                "m" to "Mass of elevated body (Kilograms, kg)",
                "g" to "Gravitational acceleration constant (9.81 m/s² on Earth)",
                "h" to "Height above reference elevation (Meters, m)"
            ),
            siUnits = "Joules (J)",
            whenUsed = "Hydroelectric dam energy calculations, roller coaster design, and pile driver mechanics.",
            simpleExample = "Water in an elevated reservoir (500 kg) sits 40 meters above a turbine.",
            calculationStep = "PE = m × g × h = 500 kg × 9.81 m/s² × 40 m = 196,200 Joules (196.2 kJ)",
            calculatorType = CalculatorType.POTENTIAL_ENERGY
        ),
        FormulaItem(
            id = "f_momentum",
            name = "Linear Momentum",
            category = FormulaCategory.MECHANICS,
            equation = "p = m × v",
            variableMeanings = listOf(
                "p" to "Linear momentum (kg·m/s)",
                "m" to "Mass of object (kg)",
                "v" to "Velocity of object (m/s)"
            ),
            siUnits = "kg·m/s (or N·s)",
            whenUsed = "Calculating rocket propulsion reaction thrust, billiard collisions, and recoil forces.",
            simpleExample = "Find momentum of an 800 kg racing cart moving at 30 m/s.",
            calculationStep = "p = m × v = 800 kg × 30 m/s = 24,000 kg·m/s",
            calculatorType = CalculatorType.MOMENTUM
        ),
        FormulaItem(
            id = "f_torque",
            name = "Torque (Moment of Force)",
            category = FormulaCategory.MECHANICS,
            equation = "τ = F × r × sin(θ)",
            variableMeanings = listOf(
                "τ" to "Torque produced (Newton-meters, N·m)",
                "F" to "Applied Force (Newtons, N)",
                "r" to "Radial lever arm distance from pivot (Meters, m)",
                "θ" to "Angle between force and lever arm (degrees)"
            ),
            siUnits = "Newton-meters (N·m)",
            whenUsed = "Shaft torque ratings, electric motor specifications, robotic arm joint actuators.",
            simpleExample = "A mechanic pulls with 200 N at 90° on a 0.5 m breaker bar.",
            calculationStep = "τ = F × r × sin(90°) = 200 N × 0.5 m × 1.0 = 100 N·m",
            calculatorType = CalculatorType.TORQUE
        ),
        FormulaItem(
            id = "f_heat_energy",
            name = "Sensible Heat Equation",
            category = FormulaCategory.THERMODYNAMICS,
            equation = "Q = m × c × ΔT",
            variableMeanings = listOf(
                "Q" to "Heat energy transferred (Joules, J)",
                "m" to "Mass of heated substance (kg)",
                "c" to "Specific Heat Capacity (J/(kg·°C)) [Water = 4184 J/(kg·°C)]",
                "ΔT" to "Temperature change (T_final - T_initial) (°C or K)"
            ),
            siUnits = "Joules (J)",
            whenUsed = "HVAC heat exchanger sizing, industrial furnace heating, electronics thermal budgets.",
            simpleExample = "Heat 5 kg of water from 20°C to 80°C (ΔT = 60°C).",
            calculationStep = "Q = m × c × ΔT = 5 kg × 4,184 J/(kg·°C) × 60°C = 1,255,200 Joules (1.255 MJ)",
            calculatorType = CalculatorType.HEAT_ENERGY
        ),
        FormulaItem(
            id = "f_stress_strain",
            name = "Engineering Stress & Strain (Hooke's Law)",
            category = FormulaCategory.MATERIALS,
            equation = "σ = F / A,   ε = ΔL / L₀,   E = σ / ε",
            variableMeanings = listOf(
                "σ" to "Normal Stress (Pascals or MPa)",
                "F" to "Axial Tension/Compression Force (N)",
                "A" to "Original cross-sectional area (m²)",
                "ε" to "Engineering Strain (dimensionless ratio)",
                "E" to "Young's Elastic Modulus (GPa)"
            ),
            siUnits = "Stress in MPa, Strain is unitless, Modulus in GPa",
            whenUsed = "Structural beam sizing, aircraft wing skin thickness, bridge truss tension checks.",
            simpleExample = "A 100 kN force acts on a steel bar with 500 mm² (0.0005 m²) area.",
            calculationStep = "σ = F / A = 100,000 N / 0.0005 m² = 200,000,000 Pa = 200 MPa",
            calculatorType = CalculatorType.STRESS_STRAIN
        ),
        FormulaItem(
            id = "f_flow_rate",
            name = "Volumetric Fluid Flow Rate",
            category = FormulaCategory.FLUIDS,
            equation = "Q = A × v = V / t",
            variableMeanings = listOf(
                "Q" to "Volumetric Flow Rate (m³/s or Liters/s)",
                "A" to "Pipe cross-sectional area (m² = π × r²)",
                "v" to "Mean fluid velocity (m/s)"
            ),
            siUnits = "Cubic meters per second (m³/s) [1 m³/s = 1,000 L/s]",
            whenUsed = "Water distribution pipelines, HVAC airflow duct sizing, fuel injection delivery.",
            simpleExample = "Water flows at 2.0 m/s through a circular pipe with area A = 0.05 m².",
            calculationStep = "Q = A × v = 0.05 m² × 2.0 m/s = 0.10 m³/s = 100 Liters/second",
            calculatorType = CalculatorType.FLOW_RATE
        ),
        FormulaItem(
            id = "f_bernoulli",
            name = "Bernoulli's Equation",
            category = FormulaCategory.FLUIDS,
            equation = "P + ½ ρ v² + ρ g h = constant",
            variableMeanings = listOf(
                "P" to "Static fluid pressure (Pa)",
                "ρ" to "Fluid density (kg/m³)",
                "v" to "Fluid velocity (m/s)",
                "g" to "Gravitational acceleration (9.81 m/s²)",
                "h" to "Elevation height (m)"
            ),
            siUnits = "Pascals (Pa) or Total Pressure Head",
            whenUsed = "Venturi flow meters, aircraft wing lift dynamics, carburetor fuel suction, water pipes.",
            simpleExample = "As air speeds up over the curved top of an airfoil, pressure drops, generating aerodynamic lift.",
            calculationStep = "P_top + ½ρ(v_top)² = P_bottom + ½ρ(v_bottom)²  =>  ΔP creates net upward Lift force.",
            calculatorType = null
        ),
        FormulaItem(
            id = "f_carnot_efficiency",
            name = "Carnot Maximum Thermal Efficiency",
            category = FormulaCategory.THERMODYNAMICS,
            equation = "η_max = 1 - (T_cold / T_hot)",
            variableMeanings = listOf(
                "η_max" to "Maximum theoretical thermal efficiency (fraction)",
                "T_cold" to "Absolute temperature of cold heat sink (Kelvin, K)",
                "T_hot" to "Absolute temperature of hot heat source (Kelvin, K)"
            ),
            siUnits = "Percentage (%)",
            whenUsed = "Establishing the absolute thermodynamic upper limit for heat engines, power plants, and refrigerators.",
            simpleExample = "An engine receives heat at 600°C (873 K) and exhausts into ambient air at 25°C (298 K).",
            calculationStep = "η = 1 - (298 K / 873 K) = 1 - 0.341 = 0.659 = 65.9% maximum theoretical efficiency.",
            calculatorType = null
        )
    )

    // 4. Materials Database
    val materials: List<MaterialItem> = listOf(
        MaterialItem(
            id = "mat_steel",
            name = "Structural Steel (A36)",
            category = "Metals & Alloys",
            density = "7,850 kg/m³",
            densityValue = 7850.0,
            yieldStrength = "250 MPa (Tensile: 400-550 MPa)",
            strengthValue = 250.0,
            electricalConductivity = "6.99 × 10⁶ S/m (Moderate)",
            thermalConductivity = "50 W/(m·K)",
            thermalValue = 50.0,
            advantages = listOf(
                "Exceptional tensile and compressive strength",
                "High ductility and toughness before breaking",
                "Easily welded, machined, and recycled globally",
                "Cost-effective for massive structures"
            ),
            disadvantages = listOf(
                "Susceptible to environmental rust and oxidation (corrosion)",
                "High density creates significant self-weight",
                "Loses structural stiffness above 500°C in fires"
            ),
            commonUses = listOf(
                "Skyscraper I-beam frames",
                "Highway bridge girders",
                "Reinforced concrete rebar",
                "Industrial pressure vessels and cranes"
            ),
            colorAccentHex = 0xFF3A86FF
        ),
        MaterialItem(
            id = "mat_aluminum",
            name = "Aluminum Alloy (6061-T6)",
            category = "Metals & Alloys",
            density = "2,700 kg/m³",
            densityValue = 2700.0,
            yieldStrength = "276 MPa (Tensile: 310 MPa)",
            strengthValue = 276.0,
            electricalConductivity = "2.5 × 10⁷ S/m (High)",
            thermalConductivity = "167 W/(m·K)",
            thermalValue = 167.0,
            advantages = listOf(
                "Very lightweight (~1/3 the density of steel)",
                "Natural passivating oxide layer provides corrosion resistance",
                "Excellent thermal and electrical conductivity",
                "Easy to extrude into complex cross-sections"
            ),
            disadvantages = listOf(
                "Lower fatigue endurance limit than steel",
                "More expensive than carbon steel per kilogram",
                "Requires specialized TIG/MIG welding techniques"
            ),
            commonUses = listOf(
                "Aircraft fuselage and wing spars",
                "Bicycle frames and automotive chassis",
                "Electronics heat sinks",
                "Architectural window frames and cladding"
            ),
            colorAccentHex = 0xFF00E5FF
        ),
        MaterialItem(
            id = "mat_copper",
            name = "Pure Copper (C11000 ETP)",
            category = "Metals & Alloys",
            density = "8,940 kg/m³",
            densityValue = 8940.0,
            yieldStrength = "69 - 300 MPa",
            strengthValue = 150.0,
            electricalConductivity = "5.96 × 10⁷ S/m (100% IACS Standard)",
            thermalConductivity = "385 - 400 W/(m·K)",
            thermalValue = 390.0,
            advantages = listOf(
                "Best commercial conductor of electricity and heat",
                "Highly malleable and ductile (drawn into fine gauge wire)",
                "Naturally antimicrobial surface",
                "Outstanding corrosion resistance in water"
            ),
            disadvantages = listOf(
                "Heavy density (8,940 kg/m³)",
                "High raw material market cost",
                "Relatively low yield strength for structural loads"
            ),
            commonUses = listOf(
                "Electrical wiring and building distribution cables",
                "Electric motor armature windings and transformers",
                "Computer CPU/GPU vapor chambers and heatpipes",
                "Potable water plumbing tubes"
            ),
            colorAccentHex = 0xFFFF7B00
        ),
        MaterialItem(
            id = "mat_titanium",
            name = "Titanium Alloy (Ti-6Al-4V Grade 5)",
            category = "Advanced Alloys",
            density = "4,430 kg/m³",
            densityValue = 4430.0,
            yieldStrength = "880 MPa (Tensile: 950 MPa)",
            strengthValue = 880.0,
            electricalConductivity = "5.6 × 10⁵ S/m (Low)",
            thermalConductivity = "6.7 W/(m·K)",
            thermalValue = 6.7,
            advantages = listOf(
                "Highest strength-to-weight ratio among metals",
                "Immune to saltwater, chlorine, and acid corrosion",
                "Fully biocompatible with human bone tissue (osseointegration)",
                "Maintains strength up to 400°C"
            ),
            disadvantages = listOf(
                "Extremely expensive to refine and machine",
                "Poor thermal conductivity traps heat during cutting",
                "Galls easily during sliding friction"
            ),
            commonUses = listOf(
                "Jet engine compressor blades and turbine discs",
                "Orthopedic hip replacements and bone screws",
                "Deep-sea submarine hulls",
                "Formula 1 suspension uprights and fasteners"
            ),
            colorAccentHex = 0xFF8B5CF6
        ),
        MaterialItem(
            id = "mat_concrete",
            name = "Reinforced Concrete",
            category = "Ceramics & Composites",
            density = "2,400 kg/m³",
            densityValue = 2400.0,
            yieldStrength = "Compressive: 30-60 MPa (Tensile: ~3-5 MPa)",
            strengthValue = 40.0,
            electricalConductivity = "10⁻⁶ S/m (Electrical Insulator)",
            thermalConductivity = "1.1 - 1.4 W/(m·K)",
            thermalValue = 1.2,
            advantages = listOf(
                "Exceptional compressive load-bearing capability",
                "Castable on-site into virtually any geometric shape",
                "Inherently fireproof and weather-durable",
                "Globally ubiquitous, inexpensive raw ingredients"
            ),
            disadvantages = listOf(
                "Very weak in direct tension (requires embedded steel rebar)",
                "Heavy mass requires large foundations",
                "Significant carbon footprint during cement clinker production"
            ),
            commonUses = listOf(
                "Bridge piers and dam gravity walls",
                "Building foundations and highway pavements",
                "Tunnels and subterranean retaining walls",
                "Precast structural columns"
            ),
            colorAccentHex = 0xFF94A3B8
        ),
        MaterialItem(
            id = "mat_carbon_fiber",
            name = "Carbon Fiber Reinforced Polymer (CFRP)",
            category = "Advanced Composites",
            density = "1,550 kg/m³",
            densityValue = 1550.0,
            yieldStrength = "Tensile: 1,500 - 2,500 MPa",
            strengthValue = 1800.0,
            electricalConductivity = "10⁴ S/m (Moderate)",
            thermalConductivity = "5 - 10 W/(m·K) (Directional)",
            thermalValue = 7.0,
            advantages = listOf(
                "Incredible tensile strength at half the weight of aluminum",
                "Anisotropic properties tailored along specific stress vectors",
                "Zero risk of rust or chemical oxidation",
                "Extremely low thermal expansion coefficient"
            ),
            disadvantages = listOf(
                "Expensive precursor raw fibers and autoclave curing",
                "Brittle failure with little plastic deformation warning",
                "Difficult to recycle and repair after impact delamination"
            ),
            commonUses = listOf(
                "Commercial aircraft wings (Boeing 787 / Airbus A350)",
                "Supercar monocoque chassis",
                "High-performance wind turbine blades",
                "Space satellite structural trusses"
            ),
            colorAccentHex = 0xFF10B981
        ),
        MaterialItem(
            id = "mat_borosilicate_glass",
            name = "Borosilicate Glass",
            category = "Ceramics & Glasses",
            density = "2,230 kg/m³",
            densityValue = 2230.0,
            yieldStrength = "Compressive: 500 MPa (Tensile: 30 MPa)",
            strengthValue = 30.0,
            electricalConductivity = "10⁻¹² S/m (Superior Insulator)",
            thermalConductivity = "1.2 W/(m·K)",
            thermalValue = 1.2,
            advantages = listOf(
                "Extremely low thermal expansion (does not shatter on thermal shock)",
                "Optically transparent with high refractive index",
                "Chemically inert to almost all industrial acids and solvents",
                "Outstanding high-voltage electrical insulation"
            ),
            disadvantages = listOf(
                "Brittle: low fracture toughness against sharp impact",
                "Low tensile strength compared to metals",
                "Difficult to machine without diamond tooling"
            ),
            commonUses = listOf(
                "Laboratory beakers, flasks, and pipettes (Pyrex)",
                "Solar thermal vacuum collector tubes",
                "High-intensity lighting lamp envelopes",
                "Pharmaceutical vaccine vials"
            ),
            colorAccentHex = 0xFF06B6D4
        ),
        MaterialItem(
            id = "mat_pvc",
            name = "Polyvinyl Chloride (PVC Plastic)",
            category = "Polymers",
            density = "1,380 kg/m³",
            densityValue = 1380.0,
            yieldStrength = "50 - 60 MPa",
            strengthValue = 55.0,
            electricalConductivity = "10⁻¹⁴ S/m (Dielectric Insulator)",
            thermalConductivity = "0.16 W/(m·K)",
            thermalValue = 0.16,
            advantages = listOf(
                "Lightweight, inexpensive, and easily solvent-welded",
                "Complete immunity to municipal water and soil corrosion",
                "Smooth interior surface reduces fluid friction losses",
                "Excellent electrical dielectric strength"
            ),
            disadvantages = listOf(
                "Low maximum operating temperature (softens above 60°C)",
                "Degrades under intense UV sunlight without stabilizers",
                "Emits hazardous chlorine gas if incinerated"
            ),
            commonUses = listOf(
                "Municipal sewer and potable water pipes",
                "Electrical cable conduit shielding",
                "Window profiles and vinyl siding",
                "Medical IV fluid tubing"
            ),
            colorAccentHex = 0xFFEAB308
        )
    )

    // 5. Real World Systems
    val realWorldSystems: List<RealWorldSystem> = listOf(
        RealWorldSystem(
            id = "sys_bridges",
            title = "Modern Cable-Stayed Bridges",
            subtitle = "Civil, Structural & Wind Aerodynamic Engineering",
            iconCategory = "Civil",
            engineeringFields = listOf("Civil Engineering", "Structural Engineering", "Materials Science"),
            whatEngineersDo = "Engineers calculate static dead loads (concrete/steel weight), dynamic live loads (thousands of moving vehicles), wind vortex shedding resonance, and seismic ground accelerations. High-strength steel cable stays transfer deck weight directly into massive reinforced concrete towers resting on bedrock piles.",
            scientificPrinciples = listOf(
                "Vector Equilibrium: Sum of vertical and horizontal forces equals zero",
                "Tension vs. Compression load path routing",
                "Aerodynamic fairing shaping to prevent flutter resonance (Tacoma Narrows mitigation)",
                "Thermal expansion joint allowances"
            ),
            materialsAndComponents = listOf(
                "High-tensile steel wire cable stays (1,860 MPa tensile strength)",
                "High-performance concrete (C60/C80) tower pylons",
                "Aerodynamic steel orthotropic deck boxes",
                "Tuned Mass Dampers inside towers to absorb wind vibrations"
            ),
            whyItMatters = "Allows vital transportation across deep river canyons and ocean bays spanning several kilometers without blocking marine navigation.",
            keyMetric = "Can span open water over 1,000 meters with zero mid-channel piers.",
            hotspots = listOf(
                DiagramHotspot("h1", "Cable Stays (Tension)", "High-tensile steel cables carrying deck weight in pure tension back to the central pylon.", 0.25f, 0.35f),
                DiagramHotspot("h2", "Central Pylon (Compression)", "Reinforced concrete tower carrying massive vertical compressive loads straight down to deep bedrock.", 0.50f, 0.20f),
                DiagramHotspot("h3", "Orthotropic Deck Box", "Streamlined aerodynamic road deck shaped like an airplane wing upside-down to prevent wind flutter.", 0.50f, 0.65f),
                DiagramHotspot("h4", "Deep Foundation Piles", "Large-diameter drilled shafts anchored deep beneath the riverbed to resist scouring and seismic shaking.", 0.50f, 0.90f)
            )
        ),
        RealWorldSystem(
            id = "sys_grid",
            title = "Continental Power Grids & High-Voltage Transmission",
            subtitle = "Electrical Power, Substations & Smart Balancing",
            iconCategory = "Electrical",
            engineeringFields = listOf("Electrical Engineering", "Power Systems", "Computer Engineering"),
            whatEngineersDo = "Electrical engineers synchronize thousands of spinning turbine generators and solar inverters to exact 50Hz/60Hz grid frequency. Step-up transformers boost voltage to 500,000 V to minimize transmission losses across thousands of kilometers, while SCADA automated relays safeguard against cascading blackouts.",
            scientificPrinciples = listOf(
                "Faraday's Law of Induction in utility step-up and step-down transformers",
                "I²R Joule heating reduction via high-voltage, low-current power flow",
                "Three-Phase AC power delivering constant instantaneous power",
                "Reactive power compensation (VARs) and grid inertia management"
            ),
            materialsAndComponents = listOf(
                "Aluminum Conductor Steel-Reinforced (ACSR) high-voltage lines",
                "Gas-Insulated Switchgear (GIS) using SF6 dielectric gas",
                "Phase-Angle Regulating Transformers",
                "High-Voltage Direct Current (HVDC) thyristor converter stations"
            ),
            whyItMatters = "Delivers instantaneous, reliable electricity to hospitals, factories, and homes 24/7 across an entire continent.",
            keyMetric = "Transmission losses kept under 6-8% across a 1,000 km journey.",
            hotspots = listOf(
                DiagramHotspot("g1", "Power Generation", "Hydro, gas, nuclear, and solar generating electricity at 15-25 kV.", 0.15f, 0.50f),
                DiagramHotspot("g2", "Step-Up Substation", "Transformers boost voltage up to 500 kV for long-distance transport.", 0.35f, 0.40f),
                DiagramHotspot("g3", "HV Transmission Lines", "Overhead ACSR lines carrying gigawatts of power with minimal thermal loss.", 0.60f, 0.35f),
                DiagramHotspot("g4", "Distribution & Consumption", "Step-down transformers lower voltage to 120/240 V for safe residential use.", 0.85f, 0.60f)
            )
        ),
        RealWorldSystem(
            id = "sys_aircraft",
            title = "Commercial Jet Airliners & Aerodynamics",
            subtitle = "Aerospace, Jet Propulsion & Fly-by-Wire Avionics",
            iconCategory = "Aerospace",
            engineeringFields = listOf("Aerospace Engineering", "Mechanical Engineering", "Electronics Engineering"),
            whatEngineersDo = "Aerospace engineers shape supercritical airfoils to generate lift while delaying transonic shockwaves. High-bypass turbofan engines burn jet fuel with high thermodynamic efficiency, and redundant triple-channel fly-by-wire computers continuously stabilize flight surfaces.",
            scientificPrinciples = listOf(
                "Bernoulli's Principle & Newton's 3rd Law producing aerodynamic wing lift",
                "Brayton Thermodynamic Cycle in high-bypass turbofan jet engines",
                "Compressible fluid shockwave management via swept wings",
                "Pressurized cabin hoop stress calculations at 38,000 feet"
            ),
            materialsAndComponents = listOf(
                "Carbon Fiber Composite wing skins and fuselage barrels",
                "Single-crystal nickel superalloy turbine blades with ceramic thermal barrier coatings",
                "High-pressure hydraulic flight control actuators",
                "Ring laser gyroscope inertial navigation systems"
            ),
            whyItMatters = "Transports billions of passengers across oceans at 900 km/h with the highest safety record of any transportation mode in human history.",
            keyMetric = "Turbine inlet temperatures exceed 1,600°C—hotter than the melting point of steel!",
            hotspots = listOf(
                DiagramHotspot("a1", "Supercritical Wing", "Curved upper airfoil generating lift and carrying integrated fuel tanks.", 0.50f, 0.40f),
                DiagramHotspot("a2", "High-Bypass Turbofan", "Engine compressing air, mixing with fuel, and providing forward thrust.", 0.35f, 0.60f),
                DiagramHotspot("a3", "Composite Fuselage", "Lightweight pressurized cylindrical cabin maintaining 8,000 ft oxygen levels.", 0.50f, 0.25f),
                DiagramHotspot("a4", "Avionics Cockpit", "Triple-redundant fly-by-wire computers translating pilot inputs to surfaces.", 0.20f, 0.30f)
            )
        ),
        RealWorldSystem(
            id = "sys_smartphone",
            title = "Modern Smartphone Microelectronics",
            subtitle = "Electronics, 3nm Silicon SoCs & Wireless RF",
            iconCategory = "Electronics",
            engineeringFields = listOf("Electronics Engineering", "Computer Engineering", "Materials Science"),
            whatEngineersDo = "Engineers fit 15+ billion transistors into a chip the size of a fingernail, engineer 5G multi-band beamforming antennas, manage lithium-ion battery electrochemistry, and write real-time OS kernels that render 120Hz OLED displays with millisecond touch response.",
            scientificPrinciples = listOf(
                "Quantum tunneling suppression in 3-nanometer FinFET/GAAFET transistors",
                "Electromagnetic wave propagation across 700MHz to 28GHz millimeter waves",
                "Lithium-ion intercalation and Solid Electrolyte Interphase (SEI) stability",
                "OLED organic electroluminescence and capacitive touch sensing"
            ),
            materialsAndComponents = listOf(
                "Silicon wafer SoC with billions of logic gates",
                "Corning Gorilla Glass Ceramic shield",
                "High-density multi-layer Any-Layer HDI Printed Circuit Board",
                "Graphite and copper vapor chamber heat spreaders"
            ),
            whyItMatters = "Puts global supercomputing, high-speed internet, GPS satellite positioning, and studio cameras into everyone's pocket.",
            keyMetric = "Gates on modern processors measure only ~30 to 45 silicon atoms across!",
            hotspots = listOf(
                DiagramHotspot("p1", "OLED Display & Touch", "120Hz display with capacitive indium-tin-oxide sensor grid.", 0.50f, 0.25f),
                DiagramHotspot("p2", "3nm Silicon SoC", "System-on-Chip containing CPU, GPU, NPU Neural Engine, and ISP.", 0.50f, 0.45f),
                DiagramHotspot("p3", "Lithium-Ion Battery", "High-density electrochemical cell providing 15-20 Watt-hours of energy.", 0.50f, 0.70f),
                DiagramHotspot("p4", "5G RF Antenna Array", "Beamforming phased-array antennas integrated into the metal frame.", 0.85f, 0.30f)
            )
        )
    )

    // 6. Interactive Quizzes
    val quizzes: List<QuizQuestion> = listOf(
        QuizQuestion(
            id = 1,
            question = "According to Ohm's Law (V = I × R), what happens to current (I) if voltage (V) is doubled while resistance (R) stays constant?",
            options = listOf(
                "Current doubles",
                "Current is cut in half",
                "Current remains unchanged",
                "Current drops to zero"
            ),
            correctIndex = 0,
            explanation = "Since I = V / R, current is directly proportional to voltage. Doubling the voltage while holding resistance constant doubles the current flowing through the circuit.",
            field = "Electricity"
        ),
        QuizQuestion(
            id = 2,
            question = "Which unit is used to measure force in the International System of Units (SI)?",
            options = listOf(
                "Joule (J)",
                "Watt (W)",
                "Newton (N)",
                "Pascal (Pa)"
            ),
            correctIndex = 2,
            explanation = "Force is measured in Newtons (N), where 1 N is the force required to accelerate 1 kg of mass at 1 m/s² (1 N = 1 kg·m/s²).",
            field = "Physics & Mechanics"
        ),
        QuizQuestion(
            id = 3,
            question = "In a series electrical circuit with three light bulbs, what happens if one bulb burns out (creating an open circuit)?",
            options = listOf(
                "The other two bulbs burn twice as bright",
                "All three bulbs immediately turn off",
                "The circuit's total resistance drops to zero",
                "The remaining bulbs convert to parallel mode"
            ),
            correctIndex = 1,
            explanation = "In a series circuit, there is only one single continuous path for current. If any component breaks the loop, current stops everywhere and all bulbs go out.",
            field = "Electricity"
        ),
        QuizQuestion(
            id = 4,
            question = "What is the primary mechanical engineering reason for adding a gearbox between an engine and car wheels?",
            options = listOf(
                "To increase total mechanical energy output",
                "To trade rotational speed for torque (or vice versa)",
                "To reduce the vehicle's gravitational mass",
                "To eliminate all friction inside the transmission"
            ),
            correctIndex = 1,
            explanation = "Gearboxes do not create energy (conservation of energy). They use gear ratios to multiply torque for hill climbing and acceleration at the expense of RPM, or vice versa for highway cruising.",
            field = "Mechanical Engineering"
        ),
        QuizQuestion(
            id = 5,
            question = "Which engineering material has the highest electrical conductivity at room temperature?",
            options = listOf(
                "Aluminum",
                "Stainless Steel",
                "Copper",
                "Titanium"
            ),
            correctIndex = 2,
            explanation = "Copper has an outstanding electrical conductivity of ~5.96 × 10⁷ S/m (surpassed commercially only by silver), making it the global standard for wiring.",
            field = "Materials Science"
        ),
        QuizQuestion(
            id = 6,
            question = "What fundamental physical law states that energy cannot be created or destroyed, only transformed from one form to another?",
            options = listOf(
                "First Law of Thermodynamics",
                "Bernoulli's Principle",
                "Hooke's Law",
                "Ohm's Law"
            ),
            correctIndex = 0,
            explanation = "The First Law of Thermodynamics is the Law of Conservation of Energy, stating the total energy of an isolated system remains constant over time.",
            field = "Thermodynamics"
        ),
        QuizQuestion(
            id = 7,
            question = "What is the difference between stress and strain in structural mechanics?",
            options = listOf(
                "Stress is deformation (%), while strain is the applied force per area (MPa)",
                "Stress is internal force per unit area (MPa), while strain is fractional deformation (ΔL/L₀)",
                "Stress and strain are identical terms for pressure",
                "Stress only occurs in liquids, while strain only occurs in gases"
            ),
            correctIndex = 1,
            explanation = "Stress (σ = F/A) measures the internal force distributed over an area, whereas strain (ε = ΔL/L₀) measures the resulting fractional elongation or deformation.",
            field = "Materials & Civil"
        ),
        QuizQuestion(
            id = 8,
            question = "Why do power utility companies step electrical voltage up to hundreds of thousands of volts (e.g. 500 kV) for cross-country transmission?",
            options = listOf(
                "Because higher voltage travels at the speed of light while low voltage does not",
                "Because high voltage lowers current for the same power (P=VI), drastically minimizing I²R cable heat losses",
                "To allow thinner insulation around the cables",
                "Because generators naturally output 500,000 V"
            ),
            correctIndex = 1,
            explanation = "Since Power = V × I, stepping voltage up by 100× drops current by 100×. Because power lost to heat in the wires is P_loss = I² × R, dropping current reduces transmission heat losses by 10,000×!",
            field = "Electrical Engineering"
        ),
        QuizQuestion(
            id = 9,
            question = "Which discipline of engineering deals with optimizing factory workflows, supply chains, logistics, and reducing industrial waste?",
            options = listOf(
                "Aerospace Engineering",
                "Industrial Engineering",
                "Biomedical Engineering",
                "Civil Engineering"
            ),
            correctIndex = 1,
            explanation = "Industrial Engineering focuses on continuous improvement, ergonomics, Lean manufacturing, stochastic queuing theory, and supply chain logistics optimization.",
            field = "Engineering Fields"
        ),
        QuizQuestion(
            id = 10,
            question = "If an electric space heater operating on a 120 V household line draws a current of 10 A, what is its power output?",
            options = listOf(
                "12 Watts",
                "120 Watts",
                "1,200 Watts",
                "12,000 Watts"
            ),
            correctIndex = 2,
            explanation = "Using Joule's Law: P = V × I = 120 V × 10 A = 1,200 Watts (1.2 kW).",
            field = "Calculations"
        )
    )

    // 7. Engineering Glossary Terms
    val glossaryTerms: List<GlossaryTerm> = listOf(
        GlossaryTerm("g_accel", "Acceleration", "Mechanics", "The rate of change of velocity with respect to time (m/s²).", "acceleration"),
        GlossaryTerm("g_amp", "Ampere (A)", "Electricity", "The SI unit of electric current, defined as one Coulomb of electrical charge flowing per second.", "current"),
        GlossaryTerm("g_bim", "BIM (Building Information Modeling)", "Civil", "A digital 3D model-based process that gives architecture, engineering, and construction professionals the insight and tools to efficiently plan, design, and manage buildings.", "civil"),
        GlossaryTerm("g_cad", "CAD (Computer-Aided Design)", "General", "Software used by engineers and designers to create precision 2D and 3D drawings and models of physical components.", ""),
        GlossaryTerm("g_capacitance", "Capacitance", "Electricity", "The ability of a system to store an electric charge per unit potential difference (measured in Farads, F).", "electricity"),
        GlossaryTerm("g_cfd", "CFD (Computational Fluid Dynamics)", "Mechanical/Aerospace", "Numerical analysis algorithms and physics simulations used to analyze and solve problems involving fluid flows, gases, and thermal convection.", "aerospace"),
        GlossaryTerm("g_cnc", "CNC Machining", "Manufacturing", "Computer Numerical Control manufacturing process where pre-programmed computer software dictates the automated movement of factory tools and machinery.", "mechanical"),
        GlossaryTerm("g_density", "Density (ρ)", "Materials", "The mass of a substance per unit volume (kg/m³).", "density_mat"),
        GlossaryTerm("g_ductility", "Ductility", "Materials", "A solid material's ability to deform under tensile stress without fracturing (e.g. copper drawn into thin wire).", "elasticity_ductility"),
        GlossaryTerm("g_efficiency", "Efficiency (η)", "Thermodynamics", "The ratio of useful energy or work output to total energy input, always less than 100% in real thermal cycles.", "thermal_efficiency"),
        GlossaryTerm("g_fea", "FEA (Finite Element Analysis)", "Mechanical/Civil", "A computerized numerical method for predicting how a structure reacts to real-world forces, vibration, heat, and fluid flow.", "stress_strain"),
        GlossaryTerm("g_force", "Force (F)", "Mechanics", "An interaction that, when unopposed, changes the motion of an object (measured in Newtons, N).", "force"),
        GlossaryTerm("g_gear_ratio", "Gear Ratio", "Mechanical", "The ratio of the number of teeth between two meshed gears, determining torque multiplication and rotational speed reduction.", "mechanical"),
        GlossaryTerm("g_hertz", "Hertz (Hz)", "Electricity/Physics", "The SI unit of frequency, representing one cycle per second.", "electricity"),
        GlossaryTerm("g_hooke", "Hooke's Law", "Materials", "The law stating that the strain in a solid is proportional to the applied stress within the elastic limit of that material (σ = E·ε).", "stress_strain"),
        GlossaryTerm("g_joule", "Joule (J)", "Physics", "The SI unit of work and energy, equal to the work done by a force of one Newton moving an object through one meter (1 N·m).", "work"),
        GlossaryTerm("g_kinetic", "Kinetic Energy", "Mechanics", "The energy that a body possesses by virtue of being in motion (KE = ½ m v²).", "energy"),
        GlossaryTerm("g_mcu", "Microcontroller (MCU)", "Electronics/Computer", "A compact integrated circuit containing a processor core, memory, and programmable input/output peripherals on a single chip.", "electronics"),
        GlossaryTerm("g_modulus", "Modulus of Elasticity (Young's Modulus)", "Materials", "A mechanical property that measures the tensile stiffness of a solid material (in GPa).", "stress_strain"),
        GlossaryTerm("g_newton", "Newton (N)", "Mechanics", "The SI unit of force equal to the force needed to accelerate 1 kilogram of mass at the rate of 1 m/s².", "force"),
        GlossaryTerm("g_ohm", "Ohm (Ω)", "Electricity", "The SI unit of electrical resistance equal to the resistance between two points when a potential difference of 1 Volt produces a current of 1 Ampere.", "resistance"),
        GlossaryTerm("g_pascal", "Pascal (Pa)", "Fluids/Mechanics", "The SI unit of pressure or internal stress equal to one Newton per square meter (1 N/m²).", "pressure"),
        GlossaryTerm("g_pcb", "PCB (Printed Circuit Board)", "Electronics", "A laminated board with etched copper conductive tracks used to mechanically support and electrically connect electronic components.", "electronics"),
        GlossaryTerm("g_power", "Power (W)", "Physics", "The rate at which work is done or energy is transferred per unit time (Watts, W).", "power"),
        GlossaryTerm("g_pv", "Photovoltaics (PV)", "Energy", "The direct conversion of light into electricity at the atomic level using semiconductor materials like silicon.", "electrical"),
        GlossaryTerm("g_reynolds", "Reynolds Number (Re)", "Fluids", "A dimensionless number used in fluid mechanics to predict whether a fluid flow will be smooth laminar or chaotic turbulent.", "flange"),
        GlossaryTerm("g_scada", "SCADA", "Electrical/Industrial", "Supervisory Control and Data Acquisition: industrial computer systems used to monitor and control utility power grids, water networks, and manufacturing pipelines.", "electrical"),
        GlossaryTerm("g_shear", "Shear Stress", "Civil/Mechanical", "A force tending to cause deformation of a material by slippage along a plane parallel to the imposed stress.", "stress_strain"),
        GlossaryTerm("g_torque", "Torque (τ)", "Mechanics", "A measure of the force that can cause an object to rotate about an axis (N·m).", "torque"),
        GlossaryTerm("g_volt", "Volt (V)", "Electricity", "The SI unit of electromotive force or electrical potential difference, defined as 1 Joule per Coulomb.", "voltage"),
        GlossaryTerm("g_watt", "Watt (W)", "Physics", "The SI unit of power, equivalent to one Joule per second (1 J/s).", "power"),
        GlossaryTerm("g_yield", "Yield Strength", "Materials", "The stress level at which a material transitions from elastic deformation (reversible) to permanent plastic deformation.", "elasticity_ductility")
    )

    // 8. Safe Student Project Ideas
    val projectIdeas: List<ProjectIdea> = listOf(
        ProjectIdea(
            id = "proj_bridge",
            title = "Popsicle Stick Truss Bridge Challenge",
            field = "Civil Engineering",
            difficulty = "Easy / Beginner",
            estimatedTime = "3 - 4 Hours",
            objective = "Design, construct, and destructive-test a model truss bridge using wooden craft sticks and glue to achieve the highest strength-to-weight ratio.",
            basicMaterials = listOf(
                "100 Standard wooden popsicle sticks",
                "Wood glue or hot glue gun",
                "Ruler and graph paper blueprint",
                "Hanging bucket and weights/sand for testing",
                "Digital kitchen scale"
            ),
            scientificPrinciple = "Triangle geometry distributes loads into pure tension (pulling) and compression (pushing) members, eliminating bending moments.",
            steps = listOf(
                "Draft a 2D truss blueprint on graph paper (e.g. Warren, Pratt, or Howe truss).",
                "Lay popsicle sticks directly over the blueprint and glue truss joints firmly.",
                "Build two identical side trusses and connect them with cross-bracing to prevent lateral buckling.",
                "Allow glue to cure completely for 24 hours.",
                "Weigh the bridge, place between two tables, and hang weight from center until failure.",
                "Calculate Strength-to-Weight Ratio = (Failure Load in kg) / (Bridge Mass in kg)."
            ),
            expectedResult = "A well-braced 150-gram wooden truss bridge can easily support over 25 to 50 kg of weight before failure!",
            realWorldConnection = "Directly mirrors how structural engineers design railway steel truss bridges and crane booms."
        ),
        ProjectIdea(
            id = "proj_solar_car",
            title = "Miniature Solar-Powered Buggy",
            field = "Electrical & Mechanical",
            difficulty = "Easy / Medium",
            estimatedTime = "2 - 3 Hours",
            objective = "Build a lightweight motorized vehicle powered entirely by a small photovoltaic solar cell to understand renewable energy conversion.",
            basicMaterials = listOf(
                "Small 3V / 200mA photovoltaic solar panel",
                "Low-voltage coreless DC motor with pinion gear",
                "Lightweight balsa wood or foam core chassis",
                "4 plastic wheels and 2 steel axles",
                "Crown or spur axle gear"
            ),
            scientificPrinciple = "The photovoltaic effect converts sunlight photons into direct electric current (DC), which electromagnetic coils in the motor turn into rotational mechanical torque.",
            steps = listOf(
                "Cut a lightweight chassis rectangle from balsa wood.",
                "Attach axle straw bushings and slide wheels and axle gear into place.",
                "Mount the DC motor so its pinion gear meshes smoothly with the axle gear.",
                "Solder solar panel leads to the DC motor terminals (observing polarity).",
                "Test in direct sunlight and adjust gear alignment for minimal friction."
            ),
            expectedResult = "The vehicle accelerates forward rapidly when exposed to direct sunlight and stops immediately in shade.",
            realWorldConnection = "Demonstrates how solar arrays power the International Space Station and experimental solar aircraft like Solar Impulse."
        ),
        ProjectIdea(
            id = "proj_hydraulic_arm",
            title = "Syringe Hydraulic Robotic Gripper",
            field = "Mechanical & Robotics",
            difficulty = "Medium",
            estimatedTime = "4 - 5 Hours",
            objective = "Construct a multi-jointed mechanical arm that lifts and moves objects using liquid-filled syringes and Pascal's Principle of fluid pressure.",
            basicMaterials = listOf(
                "6 to 8 Plastic medical syringes (10ml and 20ml)",
                "Flexible aquarium clear vinyl tubing",
                "Corrugated cardboard or laser-cut plywood arms",
                "Brass paper fasteners / rivets for pivot joints",
                "Water colored with food dye (for visualization)"
            ),
            scientificPrinciple = "Pascal's Law: Pressure applied to an enclosed incompressible fluid is transmitted undiminished in all directions (P = F₁/A₁ = F₂/A₂), providing mechanical advantage.",
            steps = listOf(
                "Cut linkage arms and build a rotating base and hinged 2-joint arm.",
                "Mount slave syringes along the arm joints with zip ties.",
                "Connect vinyl tubing to syringes and bleed all air bubbles out with colored water.",
                "Attach master control syringes on an operator control panel.",
                "Push and pull control plungers to actuate shoulder, elbow, and gripper clamp."
            ),
            expectedResult = "Smooth, powerful remote movement of the gripper arm capable of lifting small cups and sorting blocks.",
            realWorldConnection = "Replicates the exact hydraulic actuators used in heavy construction excavators, mining equipment, and airplane landing gear."
        ),
        ProjectIdea(
            id = "proj_water_filter",
            title = "Multi-Stage Gravity Water Filtration Column",
            field = "Environmental & Chemical",
            difficulty = "Easy",
            estimatedTime = "1 - 2 Hours",
            objective = "Engineer a multi-layer gravity column that removes suspended particulate contaminants and odors from turbid pond water.",
            basicMaterials = listOf(
                "Clear 2-liter plastic bottle with bottom cut off",
                "Activated carbon granules",
                "Fine washed silica sand",
                "Coarse sand and small aquarium gravel",
                "Cotton balls or coffee filter at the bottle neck",
                "Turbid test water mixed with soil, leaves, and food coloring"
            ),
            scientificPrinciple = "Physical filtration traps large particulates by size exclusion, while porous activated carbon adsorbs organic impurities through chemical molecular bonding.",
            steps = listOf(
                "Invert cut bottle and pack neck with cotton balls.",
                "Add a 3-inch layer of activated charcoal granules.",
                "Add a 3-inch layer of fine sand, followed by coarse sand, then gravel on top.",
                "Pour turbid dirty water slowly into the top of the column.",
                "Collect filtrate in a clean beaker below and measure clarity (turbidity reduction)."
            ),
            expectedResult = "Muddy, murky water emerges clear and odorless as suspended particles are trapped in successively smaller pore spaces.",
            realWorldConnection = "Mirrors the exact multi-barrier filtration process used in municipal drinking water treatment plants worldwide."
        ),
        ProjectIdea(
            id = "proj_nightlight",
            title = "Automatic Dark-Detecting Night Light Circuit",
            field = "Electronics Engineering",
            difficulty = "Easy / Medium",
            estimatedTime = "2 Hours",
            objective = "Build an analog circuit on a breadboard that automatically illuminates an LED when ambient light drops below a threshold using a light-dependent resistor (LDR).",
            basicMaterials = listOf(
                "Solderless breadboard and jumper wires",
                "9V battery and snap connector",
                "NPN Transistor (e.g. 2N2222 or 2N3904)",
                "Photoresistor (LDR)",
                "10kΩ potentiometer or fixed resistor",
                "330Ω current-limiting resistor and Ultra-bright LED"
            ),
            scientificPrinciple = "A voltage divider converts light intensity changes into a changing base voltage. When base-emitter voltage reaches ~0.7V, the transistor turns ON, allowing collector-emitter current to light the LED.",
            steps = listOf(
                "Place the NPN transistor in the breadboard.",
                "Connect the LDR between 9V positive and the transistor Base pin.",
                "Connect the 10kΩ resistor between the Base pin and Ground.",
                "Connect the LED with 330Ω resistor from 9V positive to the Collector pin.",
                "Connect the Emitter pin directly to Ground.",
                "Cover the LDR with your finger to observe the LED turning ON automatically."
            ),
            expectedResult = "The LED remains OFF in bright daylight and automatically turns bright ON when the room goes dark.",
            realWorldConnection = "Fundamental architecture behind municipal streetlights, smartphone ambient light sensors, and automotive automatic headlights."
        )
    )

    // 9. Educational Lessons
    val lessons: List<LearningLesson> = listOf(
        LearningLesson(
            id = "les_what_is_eng",
            title = "Introduction: What is Engineering?",
            level = LessonLevel.BEGINNER,
            readTime = "4 min read",
            category = "Fundamentals",
            summary = "Understand how engineers apply scientific knowledge, mathematical principles, and economic judgment to solve real human challenges.",
            sections = listOf(
                LessonSection(
                    heading = "Science vs. Engineering",
                    body = "Scientists explore the natural universe as it exists, asking 'Why does this happen?' Engineers create things that have never existed before, asking 'How can we use this to solve a real human need?' Where physics discovers electromagnetism, engineers create MRI medical scanners and electric vehicles.",
                    keyPoints = listOf(
                        "Science creates knowledge; engineering creates solutions",
                        "Engineers work under strict real-world constraints (cost, safety, materials, energy, time)"
                    )
                ),
                LessonSection(
                    heading = "The Engineering Design Process",
                    body = "Engineers follow a structured, iterative design loop: Ask (Define the problem) -> Research -> Imagine (Brainstorm ideas) -> Plan (Draft blueprints & calculations) -> Create (Build prototypes) -> Test (Evaluate performance) -> Improve (Iterate and optimize).",
                    keyPoints = listOf(
                        "Failure during testing is treated as valuable data for the next iteration",
                        "Safety and reliability are the non-negotiable core of professional ethics"
                    )
                )
            ),
            keyTakeaway = "Engineering is the art and science of turning theoretical ideas into safe, functional, and economical realities."
        ),
        LearningLesson(
            id = "les_si_units",
            title = "SI Units & Dimensional Consistency",
            level = LessonLevel.BEGINNER,
            readTime = "5 min read",
            category = "Fundamentals",
            summary = "Master the seven fundamental SI base units and how to verify calculation correctness using dimensional unit analysis.",
            sections = listOf(
                LessonSection(
                    heading = "The 7 SI Base Units",
                    body = "Every engineering measurement on Earth is built from seven base units: Meter (m) for length, Kilogram (kg) for mass, Second (s) for time, Ampere (A) for electric current, Kelvin (K) for thermodynamic temperature, Mole (mol) for amount of substance, and Candela (cd) for luminous intensity.",
                    keyPoints = listOf(
                        "Derived units are combinations (e.g. 1 Newton = 1 kg·m/s²)",
                        "Never mix unit systems (e.g. feet with meters) without explicit conversion factors"
                    )
                ),
                LessonSection(
                    heading = "Dimensional Analysis Sanity Check",
                    body = "Whenever you solve an engineering formula, write the units into the equation alongside the numbers. If you are calculating velocity and your final unit ends up as kg/s, you know instantly that your formula has an algebraic error before building any hardware.",
                    keyPoints = listOf(
                        "Units on the left side of the equals sign MUST match units on the right side",
                        "The famous NASA Mars Climate Orbiter loss in 1999 occurred because one team used Imperial pound-force-seconds while another used SI Newton-seconds."
                    )
                )
            ),
            keyTakeaway = "Always track and cancel your units during calculation—dimensional analysis is an engineer's first line of defense."
        ),
        LearningLesson(
            id = "les_free_body",
            title = "Free Body Diagrams & Static Equilibrium",
            level = LessonLevel.INTERMEDIATE,
            readTime = "6 min read",
            category = "Mechanics",
            summary = "Learn how to isolate physical bodies, draw external forces, and apply Newton's equilibrium equations to solve trusses and structures.",
            sections = listOf(
                LessonSection(
                    heading = "Isolating the System",
                    body = "A Free Body Diagram (FBD) is a visual sketch showing an isolated physical object stripped of its surroundings, with every single external force and moment acting on it drawn as a vector arrow with magnitude and direction.",
                    keyPoints = listOf(
                        "Include gravity (weight acting at center of mass)",
                        "Include normal reaction forces at contact points",
                        "Include friction forces parallel to contacting surfaces",
                        "Include tension forces pulling along cables"
                    )
                ),
                LessonSection(
                    heading = "The Static Equilibrium Equations",
                    body = "For any object that is not accelerating (stationary buildings, parked vehicles, holding cranes), Newton's Second Law mandates that the sum of all forces in every Cartesian direction must equal zero, and the sum of all rotational torques must equal zero: Σ F_x = 0,  Σ F_y = 0,  Σ τ = 0.",
                    keyPoints = listOf(
                        "Break angled forces into sine and cosine components",
                        "Pick a convenient pivot point with the most unknown forces when calculating moments to simplify algebra"
                    )
                )
            ),
            keyTakeaway = "If an engineering structure is standing still, all forces and moments must perfectly sum to zero."
        )
    )

    // 10. Unit Converter Data
    val unitCategories: Map<UnitType, List<UnitItem>> = mapOf(
        UnitType.LENGTH to listOf(
            UnitItem("m", "Meters (SI Base)", 1.0),
            UnitItem("mm", "Millimeters", 0.001),
            UnitItem("cm", "Centimeters", 0.01),
            UnitItem("km", "Kilometers", 1000.0),
            UnitItem("in", "Inches", 0.0254),
            UnitItem("ft", "Feet", 0.3048),
            UnitItem("yd", "Yards", 0.9144),
            UnitItem("mi", "Miles", 1609.344)
        ),
        UnitType.MASS to listOf(
            UnitItem("kg", "Kilograms (SI Base)", 1.0),
            UnitItem("mg", "Milligrams", 0.000001),
            UnitItem("g", "Grams", 0.001),
            UnitItem("t", "Metric Tonnes", 1000.0),
            UnitItem("oz", "Ounces", 0.02834952),
            UnitItem("lb", "Pounds (mass)", 0.45359237)
        ),
        UnitType.FORCE to listOf(
            UnitItem("N", "Newtons (SI Base)", 1.0),
            UnitItem("kN", "Kilonewtons", 1000.0),
            UnitItem("lbf", "Pounds Force", 4.44822),
            UnitItem("dyn", "Dynes", 1e-5),
            UnitItem("kgf", "Kilogram Force", 9.80665)
        ),
        UnitType.PRESSURE to listOf(
            UnitItem("Pa", "Pascals (SI Base)", 1.0),
            UnitItem("kPa", "Kilopascals", 1000.0),
            UnitItem("MPa", "Megapascals", 1000000.0),
            UnitItem("bar", "Bar", 100000.0),
            UnitItem("psi", "Pounds / sq inch (psi)", 6894.76),
            UnitItem("atm", "Standard Atmospheres", 101325.0)
        ),
        UnitType.ENERGY to listOf(
            UnitItem("J", "Joules (SI Base)", 1.0),
            UnitItem("kJ", "Kilojoules", 1000.0),
            UnitItem("MJ", "Megajoules", 1000000.0),
            UnitItem("Wh", "Watt-hours", 3600.0),
            UnitItem("kWh", "Kilowatt-hours", 3.6e6),
            UnitItem("cal", "Calories (thermochem)", 4.184),
            UnitItem("kcal", "Kilocalories (dietary)", 4184.0),
            UnitItem("BTU", "British Thermal Units", 1055.06)
        ),
        UnitType.POWER to listOf(
            UnitItem("W", "Watts (SI Base)", 1.0),
            UnitItem("kW", "Kilowatts", 1000.0),
            UnitItem("MW", "Megawatts", 1000000.0),
            UnitItem("hp", "Mechanical Horsepower", 745.7),
            UnitItem("ft·lbf/s", "Foot-pounds / second", 1.355818)
        ),
        UnitType.TEMPERATURE to listOf(
            UnitItem("°C", "Degrees Celsius", 1.0),
            UnitItem("°F", "Degrees Fahrenheit", 1.0),
            UnitItem("K", "Kelvin (SI Base)", 1.0)
        )
    )

    // 11. Worked Problems
    val workedProblems: List<WorkedProblem> = listOf(
        WorkedProblem(
            id = "prob_1",
            title = "Ohm's Law & Resistor Power Dissipation",
            topic = "Electricity",
            problemStatement = "A 24V industrial DC sensor requires 120 mA of current to operate. Calculate the required series dropping resistor value when powered from a 48V rail, and find the minimum power rating of the resistor.",
            steps = listOf(
                "Step 1: Identify given variables: V_supply = 48V, V_sensor = 24V, I = 120 mA = 0.12 A.",
                "Step 2: Determine voltage drop across resistor: V_R = V_supply - V_sensor = 48V - 24V = 24V.",
                "Step 3: Calculate resistance using Ohm's Law: R = V_R / I = 24V / 0.12 A = 200 Ω.",
                "Step 4: Calculate power dissipated in resistor: P = V_R × I = 24V × 0.12 A = 2.88 Watts.",
                "Step 5: Select standard engineering rating with 2x safety factor: Use a 200 Ω, 5W wirewound resistor."
            )
        ),
        WorkedProblem(
            id = "prob_2",
            title = "Structural Steel Rod Tensile Stress & Elongation",
            topic = "Mechanics & Materials",
            problemStatement = "A 2-meter long structural steel rod (E = 200 GPa) with a circular cross-section diameter of 20 mm is subjected to an axial tensile load of 50 kN. Determine the tensile stress and total elongation.",
            steps = listOf(
                "Step 1: Convert units to SI: L₀ = 2.0 m, d = 0.020 m, F = 50,000 N, E = 200 × 10⁹ Pa.",
                "Step 2: Calculate cross-sectional area: A = π × (d/2)² = π × (0.010 m)² = 3.1416 × 10⁻⁴ m².",
                "Step 3: Calculate normal tensile stress: σ = F / A = 50,000 N / (3.1416 × 10⁻⁴ m²) = 159.15 MPa.",
                "Step 4: Verify against yield strength: Structural steel yield strength is ~250 MPa; 159 MPa is safely below yield (Safety Factor = 1.57).",
                "Step 5: Calculate total elastic elongation: ΔL = (F × L₀) / (A × E) = (50,000 × 2.0) / (3.1416 × 10⁻⁴ × 200 × 10⁹) = 0.00159 m = 1.59 mm."
            )
        ),
        WorkedProblem(
            id = "prob_3",
            title = "Hydraulic Lift Piston Mechanical Advantage",
            topic = "Fluid Mechanics",
            problemStatement = "In a car repair workshop hydraulic lift, input force is applied to a small pump piston of diameter 5 cm. It lifts an automobile weighing 1,800 kg resting on a large piston of diameter 30 cm. Find the required input force.",
            steps = listOf(
                "Step 1: Calculate total vehicle weight (output force): F₂ = m × g = 1,800 kg × 9.81 m/s² = 17,658 N.",
                "Step 2: Calculate area ratio of the two pistons: (A₂ / A₁) = (d₂ / d₁)² = (30 cm / 5 cm)² = 6² = 36.",
                "Step 3: Apply Pascal's Law (P₁ = P₂): F₁ / A₁ = F₂ / A₂ => F₁ = F₂ / (A₂ / A₁) = 17,658 N / 36.",
                "Step 4: Solve for input force: F₁ = 490.5 N (~50 kgf).",
                "Step 5: Conclusion: The hydraulic system provides a 36x mechanical advantage, allowing a technician to lift an entire car with moderate manual force."
            )
        )
    )

    fun convertUnits(category: UnitType, fromUnit: UnitItem, toUnit: UnitItem, value: Double): Double {
        if (category == UnitType.TEMPERATURE) {
            // Special temperature conversion
            val celsius = when (fromUnit.symbol) {
                "°C" -> value
                "°F" -> (value - 32.0) * (5.0 / 9.0)
                "K" -> value - 273.15
                else -> value
            }
            return when (toUnit.symbol) {
                "°C" -> celsius
                "°F" -> (celsius * (9.0 / 5.0)) + 32.0
                "K" -> celsius + 273.15
                else -> celsius
            }
        }
        val baseValue = value * fromUnit.toBaseMultiplier
        return baseValue / toUnit.toBaseMultiplier
    }
}
