# GAPI & UOSQL: Universal Knowledge Graph & AI Orchestration Engine

[![Python 3.10+](https://img.shields.io/badge/Python-3.10%2B-blue.svg)](https://www.python.org/)
[![Java 21+](https://img.shields.io/badge/Java-21%2B-orange.svg)](https://www.oracle.com/java/)
[![ANTLR 4.13.2](https://img.shields.io/badge/ANTLR-4.13.2-red.svg)](https://www.antlr.org/)
[![Status](https://img.shields.io/badge/Status-Active%20Prototype-brightgreen.svg)]()

> **"Universal Knowledge Graph Layer: Behind UOSQL resides a graph-like model where every connection becomes searchable."**  
> — Inspired by [Levi Reyes](https://www.linkedin.com/in/levi-reyes-1530b6297/) & built on parsing techniques from [Amoghhosamane/ANTLRparse](https://github.com/Amoghhosamane/ANTLRparse).

---

## 📖 What Does This Project Do?

Modern software engineering and AI systems are fragmented into isolated silos:
- Code resides in Git repositories.
- Workflows live in CI/CD runners and task queues.
- Model weights and inference configurations exist across model hubs.
- Telemetry lives in Digital Twin / IoT monitors.
- Human ownership is scattered across Jira, Slack, and organizational registries.

When an **autonomous AI Agent** or **engineer** asks:
> *"Which workflow automates the digital twin linked to the repository maintained by Levi's team?"*

...standard databases struggle to join across these heterogeneous domains without fragile, ad-hoc glue code.

### The Solution: GAPI + UOSQL
**GAPI** (Universal Orchestration Database) provides a **Universal Knowledge Graph Layer** queried through **UOSQL** (*Universal Orchestration and Schema Query Language*).

It establishes a strongly-typed 7-tier continuous ontology:

$$\mathbf{Human} \longleftrightarrow \mathbf{Organization} \longleftrightarrow \mathbf{Project} \longleftrightarrow \mathbf{Workflow} \longleftrightarrow \mathbf{Repository} \longleftrightarrow \mathbf{AI\ Model} \longleftrightarrow \mathbf{Digital\ Twin}$$

Every relationship is:
1. **Searchable & Traversible**: Hop through 1 to 7 layers with simple declarative syntax.
2. **AI-Agent Ready**: Provides structured function-calling tools (Gemini, Claude, GPT, MCP) so LLMs navigate company infrastructure deterministically rather than hallucinating paths.
3. **Dual Implemented**: Available in **Python (Lark)** for AI tools and **Java (ANTLR4)** for high-throughput enterprise backends.

---

## 🏛️ Architecture Overview

```
                               ┌────────────────────────────────────────────────┐
                               │   AI Agents (Gemini, Claude, GPT) / Developers │
                               └───────────────────────┬────────────────────────┘
                                                       │  UOSQL Query / Tool Call
                                                       ▼
                         ┌─────────────────────────────────────────────────────────────┐
                         │                    UOSQL Query Parsers                      │
                         │   • Python Engine (Lark grammar.lark)                       │
                         │   • Java Engine   (ANTLR4 UOSQL.g4)                         │
                         └─────────────────────────────┬───────────────────────────────┘
                                                       │ AST / Execution Plan
                                                       ▼
                         ┌─────────────────────────────────────────────────────────────┐
                         │               GAPIGraphStore Engine                         │
                         │   • In-Memory / NetworkX / SQLite Adjacency                 │
                         │   • Multi-Hop Graph Traversal Index                         │
                         │   • Property Filters (WHERE condition)                      │
                         └─────────────────────────────┬───────────────────────────────┘
                                                       │
                 ┌───────────────────┬─────────────────┼───────────────────┬──────────────────┐
                 ▼                   ▼                 ▼                   ▼                  ▼
          ┌─────────────┐     ┌─────────────┐   ┌─────────────┐     ┌─────────────┐    ┌─────────────┐
          │    Human    │ ──▶ │Organization │──▶│   Project   │ ──▶ │  Workflow   │──▶ │ Repository  │ ...
          └─────────────┘     └─────────────┘   └─────────────┘     └─────────────┘    └─────────────┘
```

---

## 🔤 UOSQL Language Primer

UOSQL provides an expressive syntax designed for graph wiring, path discovery, and entity retrieval.

### 1. Connecting Graph Entities (`CONNECT`)
Wire full multi-tier relationships with inline attributes:
```sql
CONNECT Human("Levi Reyes") [role="Lead Architect", status="Active"]
     -> Organization("GAPI Enterprise") [tier="Global"]
     -> Project("UOSQL-Orchestrator") [domain="Multi-Agent Systems"]
     -> Workflow("Continuous-KG-Sync") [frequency="realtime"]
     -> Repository("Amoghhosamane/ANTLRparse") [language="ANTLR/Java"]
     -> AIModel("Gemini-Flash") [latency_ms=100, modality="multimodal"]
     -> DigitalTwin("EdgeRoboticsTwin") [status="synced", telemetry_fps=60];
```

### 2. Multi-Hop Graph Traversal (`TRAVERSE`)
Traverse across hops deterministically:
```sql
TRAVERSE Human("Levi Reyes")
      -> Organization
      -> Project
      -> Workflow
      -> Repository
      -> AIModel;
```
*Result:* Returns the exact ordered path from Human all the way to the AI Model.

### 3. Entity Discovery & Filtering (`FIND`)
Search for any entity by kind and metadata:
```sql
FIND AIModel WHERE modality="multimodal" AND latency_ms <= 150;
```

---

## 🤖 AI Agent & LLM Function Calling

The engine provides a ready-to-use tool interface (`GAPIAITools`) compatible with Gemini, Anthropic Claude, and OpenAI tool-calling specifications:

- **`gapi_query`**: Allows the agent to run UOSQL traversal queries to answer questions about organizational tech stacks.
- **`gapi_connect`**: Allows agents to register new artifacts (e.g. newly deployed workflows or fine-tuned models) into the universal graph.
- **`gapi_export_graph`**: Exports the graph for global context reasoning and visualization.

---

## 📂 Repository Layout

```
gapi/
├── antlr-4.13.2-complete.jar        # Official ANTLR 4.13.2 runtime jar
│
├── java_engine/                     # Java Implementation (Enterprise ANTLR4)
│   ├── src/gapi/uosql/
│   │   ├── UOSQL.g4                 # ANTLR4 Context-Free Grammar
│   │   ├── EntityNode.java          # Entity representation
│   │   ├── GAPIGraphStore.java      # Adjacency multi-hop graph store
│   │   ├── UOSQLExecutionVisitor.java # Visitor converting AST into graph operations
│   │   └── Main.java                # Java runnable entrypoint
│   └── bin/                         # Compiled .class files
│
├── gapi_uosql/                      # Python Implementation (Fast AI / Tooling)
│   ├── grammar.lark                 # EBNF Grammar specification for Lark
│   ├── models.py                    # Pydantic entity and edge models
│   ├── store.py                     # NetworkX graph store & pathfinder
│   ├── engine.py                    # AST transformer & execution runtime
│   └── ai_tools.py                  # AI Agent function-calling & MCP schemas
│
├── tests/
│   └── test_uosql.py                # Pytest test suite (100% pass)
│
├── examples/
│   └── demo.py                      # Python end-to-end traversal & AI dispatch demo
│
└── requirements.txt                 # Python dependencies
```

---

## 🚀 Quick Start Guide

### Prerequisites
- **Python 3.10+**
- **Java JDK 21+** (e.g. OpenJDK or Oracle JDK 23)

### 1. Java Engine (ANTLR4)

```powershell
# Generate ANTLR visitor and compile Java sources:
java -jar antlr-4.13.2-complete.jar -visitor -package gapi.uosql java_engine\src\gapi\uosql\UOSQL.g4
javac -cp ".;antlr-4.13.2-complete.jar" -d java_engine\bin java_engine\src\gapi\uosql\*.java

# Run Java Demo:
java -cp "java_engine\bin;antlr-4.13.2-complete.jar" gapi.uosql.Main
```

### 2. Python Engine (Lark + AI Tools)

```powershell
# Install dependencies:
py -m pip install -r requirements.txt

# Run Unit Tests:
py -m pytest tests

# Run Interactive Demo:
$env:PYTHONPATH="."
py examples\demo.py
```

---

## 🔬 Sample Output (Python & Java)

```text
========================================================================
 GAPI Universal Knowledge Graph Engine
 Narrative: Human <-> Org <-> Project <-> Workflow <-> Repo <-> Model <-> Twin
========================================================================

[Step 1] Initializing Universal Knowledge Graph via UOSQL:
Executed: connected with 6 graph connections.

[Step 2] Executing Traversal Query:
[Human] Levi Reyes -> [Organization] GAPI Enterprise -> [Project] UOSQL Orchestrator 
  -> [Workflow] Continuous Intelligence -> [Repository] Amoghhosamane/ANTLRparse -> [AIModel] Gemini-Flash

[Step 3] AI Agent Tool-Call (Simulated Gemini / Agentic Tool Dispatch):
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
```

---

## 📜 Roadmap & Next Steps
- [x] Context-free grammar definition for UOSQL (`.g4` and `.lark`).
- [x] Multi-hop graph storage and path traversal.
- [x] LLM function calling dispatch layer for autonomous agents.
- [ ] Persistent graph storage backing (Neo4j / DuckDB / SQLite).
- [ ] Direct Model Context Protocol (MCP) server packaging.
- [ ] Web-based visual graph explorer using Cytoscape or D3.
#   G A P I - U O S Q L - E n g i n e  
 