# GAPI & UOSQL
### Universal Knowledge Graph & AI Orchestration Engine

[![Python 3.10+](https://img.shields.io/badge/Python-3.10%2B-blue.svg)](https://www.python.org/)
[![Java 21+](https://img.shields.io/badge/Java-21%2B-orange.svg)](https://www.oracle.com/java/)
[![ANTLR 4.13.2](https://img.shields.io/badge/ANTLR-4.13.2-red.svg)](https://www.antlr.org/)
[![Status](https://img.shields.io/badge/Status-Active%20Prototype-brightgreen.svg)]()

> **A universal knowledge graph where every connection becomes searchable.**
>
> Inspired by [Levi Reyes](https://www.linkedin.com/in/levi-reyes-1530b6297/) and built on parsing techniques from [Amoghhosamane/ANTLRparse](https://github.com/Amoghhosamane/ANTLRparse).

---

## Overview

Modern software ecosystems are distributed across disconnected systems:

- Source code lives in Git repositories.
- Automation and business logic run through workflows and CI/CD pipelines.
- AI models and inference configurations exist across model hubs.
- Digital Twin and IoT systems generate telemetry.
- Team ownership and organizational information are scattered across project management and communication platforms.

Connecting these systems often requires custom integrations, complex queries, and fragile application-level logic.

Consider the following question:

> Which workflow automates the Digital Twin associated with the repository maintained by Levi's team?

Traditional relational queries can become difficult to maintain when relationships span multiple heterogeneous domains.

**GAPI and UOSQL aim to solve this problem through a unified, graph-oriented data model and a declarative query language.**

## What is GAPI?

**GAPI (Universal Orchestration Database)** is a knowledge graph and orchestration layer designed to represent relationships between people, organizations, projects, workflows, repositories, AI models, and Digital Twins.

It provides a unified structure in which entities and their relationships can be connected, discovered, traversed, and queried.

## What is UOSQL?

**UOSQL (Universal Orchestration and Schema Query Language)** is a declarative query language designed to interact with the GAPI graph.

It supports three primary operations:

- `CONNECT` — Create entities and establish relationships.
- `TRAVERSE` — Navigate multi-hop relationships across the graph.
- `FIND` — Discover entities using types and property-based filters.

The project currently provides two implementations:

| Implementation | Technology | Intended use |
|---|---|---|
| Python Engine | Python, Lark, NetworkX | AI tooling, experimentation, and agent integrations |
| Java Engine | Java 21, ANTLR 4 | JVM-based applications and backend integration |

---

## Architecture

GAPI uses a seven-tier ontology to organize connected infrastructure:

```text
Human
  │
  ▼
Organization
  │
  ▼
Project
  │
  ▼
Workflow
  │
  ▼
Repository
  │
  ▼
AI Model
  │
  ▼
Digital Twin
```

Each entity is represented as a typed node, while relationships form traversable graph edges.

### High-level architecture

```text
        AI Agents / Developers
       Gemini | Claude | GPT
                 │
                 │ UOSQL Query / Tool Call
                 ▼
       ┌───────────────────────┐
       │    UOSQL Parsers     │
       │                       │
       │ Python: Lark          │
       │ Java: ANTLR4          │
       └───────────┬───────────┘
                   │
                   ▼
       ┌───────────────────────┐
       │   AST / Execution     │
       │       Runtime         │
       └───────────┬───────────┘
                   │
                   ▼
       ┌───────────────────────┐
       │   GAPI Graph Store    │
       │                       │
       │ Entity Management     │
       │ Relationship Index    │
       │ Graph Traversal       │
       │ Property Filtering    │
       └───────────┬───────────┘
                   │
                   ▼
          Universal Knowledge Graph
                   │
       ┌───────────┼───────────┐
       ▼           ▼           ▼
     Human       Project     Workflow
       │           │           │
       ▼           ▼           ▼
     Org        Repository   AI Model
                               │
                               ▼
                          Digital Twin
```

### Core capabilities

1. **Multi-hop traversal:** Navigate connected entities across multiple ontology layers.
2. **Typed relationships:** Maintain structured relationships between different entity categories.
3. **Property-based discovery:** Filter entities using metadata and comparison operators.
4. **AI-agent integration:** Expose graph operations through structured tool-calling interfaces.
5. **Dual-language implementation:** Use Python for AI-oriented tooling and Java for JVM-based integration.

---

## UOSQL Language Primer

### 1. CONNECT — Create graph relationships

The `CONNECT` operation establishes a chain of connected entities with optional metadata.

```sql
CONNECT Human("Levi Reyes") [role="Lead Architect", status="Active"]
    -> Organization("GAPI Enterprise") [tier="Global"]
    -> Project("UOSQL-Orchestrator") [domain="Multi-Agent Systems"]
    -> Workflow("Continuous-KG-Sync") [frequency="realtime"]
    -> Repository("Amoghhosamane/ANTLRparse") [language="ANTLR/Java"]
    -> AIModel("Gemini-Flash") [latency_ms=100, modality="multimodal"]
    -> DigitalTwin("EdgeRoboticsTwin") [status="synced", telemetry_fps=60];
```

This creates a connected entity chain containing six relationships across seven entity types.

### 2. TRAVERSE — Navigate connected entities

The `TRAVERSE` operation discovers paths through the graph.

```sql
TRAVERSE Human("Levi Reyes")
    -> Organization
    -> Project
    -> Workflow
    -> Repository
    -> AIModel;
```

**Expected result:** An ordered path containing the matching entities from the starting Human node to the AIModel node.

### 3. FIND — Discover entities using filters

The `FIND` operation retrieves entities based on their type and metadata.

```sql
FIND AIModel
WHERE modality = "multimodal"
AND latency_ms <= 150;
```

This query searches for AI models that support multimodal input and have a recorded latency of 150 ms or less.

---

## AI Agent Integration

GAPI includes an AI tool interface called `GAPIAITools`, designed to expose graph operations to LLM-based agents.

The interface is intended to support structured function-calling workflows with models and frameworks such as:

- OpenAI GPT
- Anthropic Claude
- Google Gemini
- Model Context Protocol (MCP)-compatible clients

### Available operations

| Tool | Description |
|---|---|
| `gapi_query` | Execute UOSQL queries to retrieve and traverse graph data. |
| `gapi_connect` | Register new entities and relationships in the graph. |
| `gapi_export_graph` | Export graph data for visualization and external processing. |

### Example workflow

```text
User Question
     │
     ▼
AI Agent
     │
     ▼
GAPI Tool Call
     │
     ▼
UOSQL Query
     │
     ▼
Graph Traversal
     │
     ▼
Structured Result
     │
     ▼
AI Agent Response
```

Instead of asking an LLM to infer infrastructure relationships from unstructured context, the agent can retrieve structured graph results through explicit queries.

---

## Repository Structure

```text
gapi/
│
├── antlr-4.13.2-complete.jar
│
├── java_engine/
│   ├── src/
│   │   └── gapi/
│   │       └── uosql/
│   │           ├── UOSQL.g4
│   │           ├── EntityNode.java
│   │           ├── GAPIGraphStore.java
│   │           ├── UOSQLExecutionVisitor.java
│   │           └── Main.java
│   │
│   └── bin/
│
├── gapi_uosql/
│   ├── grammar.lark
│   ├── models.py
│   ├── store.py
│   ├── engine.py
│   └── ai_tools.py
│
├── tests/
│   └── test_uosql.py
│
├── examples/
│   └── demo.py
│
└── requirements.txt
```

### Component responsibilities

| Component | Responsibility |
|---|---|
| `UOSQL.g4` | ANTLR grammar definition for the Java implementation |
| `EntityNode.java` | Java entity representation |
| `GAPIGraphStore.java` | Java graph storage and traversal |
| `UOSQLExecutionVisitor.java` | Converts parsed queries into graph operations |
| `grammar.lark` | Python UOSQL grammar |
| `models.py` | Pydantic entity and relationship models |
| `store.py` | NetworkX graph storage and pathfinding |
| `engine.py` | Query parsing, AST transformation, and execution |
| `ai_tools.py` | AI-agent tool definitions and dispatch |
| `test_uosql.py` | Automated Python tests |
| `demo.py` | End-to-end demonstration |

---

## Getting Started

### Prerequisites

Install the following:

- Python 3.10 or newer
- Java JDK 21 or newer
- Git
- pip

### 1. Clone the repository

```bash
git clone https://github.com/Amoghhosamane/gapi.git
cd gapi
```

Replace the repository URL if the project is hosted elsewhere.

### 2. Run the Python implementation

Install dependencies:

```bash
py -m pip install -r requirements.txt
```

Run the test suite:

```bash
py -m pytest tests
```

Run the interactive demonstration:

```powershell
$env:PYTHONPATH="."
py examples\demo.py
```

### 3. Run the Java implementation

Generate the ANTLR visitor and parser:

```powershell
java -jar antlr-4.13.2-complete.jar -visitor -package gapi.uosql java_engine\src\gapi\uosql\UOSQL.g4
```

Compile the Java sources:

```powershell
javac -cp ".;antlr-4.13.2-complete.jar" -d java_engine\bin java_engine\src\gapi\uosql\*.java
```

Run the Java demonstration:

```powershell
java -cp "java_engine\bin;antlr-4.13.2-complete.jar" gapi.uosql.Main
```

**Note:** The commands above use Windows PowerShell classpath separators. On Linux and macOS, replace `;` with `:` in Java classpaths.

---

## Example Output

The following illustrates the intended end-to-end workflow:

```text
========================================================================
 GAPI Universal Knowledge Graph Engine
========================================================================

[Step 1] Initializing Universal Knowledge Graph

Executed: connected with 6 graph connections.

[Step 2] Executing Traversal Query

[Human] Levi Reyes
    ->
[Organization] GAPI Enterprise
    ->
[Project] UOSQL Orchestrator
    ->
[Workflow] Continuous Intelligence
    ->
[Repository] Amoghhosamane/ANTLRparse
    ->
[AIModel] Gemini-Flash

[Step 3] AI Agent Tool Dispatch

Agent Query Result:

[
  {
    "action": "find",
    "results": [
      {
        "kind": "AIModel",
        "id": "Gemini-Flash",
        "properties": {
          "latency_ms": 120,
          "modality": "multimodal"
        }
      }
    ]
  }
]

========================================================================
 Execution completed
========================================================================
```

*Output is illustrative; actual results depend on the graph data and implementation.*

---

## Roadmap

- [x] Define UOSQL grammar using Lark and ANTLR4.
- [x] Implement graph entity and relationship representations.
- [x] Implement multi-hop graph traversal.
- [x] Implement property-based entity discovery.
- [x] Develop an LLM function-calling interface.
- [ ] Add persistent graph storage using Neo4j, DuckDB, or SQLite.
- [ ] Package the engine as a standalone MCP server.
- [ ] Build a web-based graph explorer using Cytoscape.js or D3.js.
- [ ] Add graph query optimization and indexing.
- [ ] Add performance benchmarks for Python and Java implementations.
- [ ] Expand integration tests across both implementations.

---

## Technology Stack

| Layer | Technologies |
|---|---|
| Python Runtime | Python 3.10+, Lark |
| Java Runtime | Java 21+, ANTLR 4.13.2 |
| Data Models | Pydantic |
| Graph Processing | NetworkX |
| Testing | Pytest |
| AI Integration | OpenAI, Anthropic, Gemini tool-calling interfaces |
| Future Storage | Neo4j, SQLite, DuckDB |
| Future Visualization | Cytoscape.js, D3.js |

---

## Project Status

<em>Active Prototype</em>

GAPI and UOSQL are currently in the prototype stage. The project focuses on validating the language design, graph representation, traversal model, and AI-agent integration approach.

Persistent storage, standalone MCP packaging, graph visualization, and performance benchmarking are planned development areas.

---

## Contributing

Contributions, ideas, and technical discussions are welcome.

1. Fork the repository.
2. Create a feature branch.
3. Implement and test your changes.
4. Submit a pull request with a clear description.

---

## License

Add your preferred open-source license before publishing the repository.

---

**GAPI & UOSQL — Connecting people, projects, workflows, repositories, AI models, and digital infrastructure through one queryable knowledge graph.**
