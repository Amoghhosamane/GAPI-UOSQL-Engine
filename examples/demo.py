"""
Interactive demonstration of GAPI Knowledge Graph Layer & UOSQL.
Connects entities based on the Levi Reyes specification:
Human <-> Organization <-> Project <-> Workflow <-> Repository <-> AIModel <-> DigitalTwin
"""
from gapi_uosql import UOSQLEngine, GAPIAITools
import json

def run_demo():
    print("=" * 70)
    print(" GAPI: Universal Knowledge Graph & UOSQL Engine Demo")
    print("=" * 70)

    engine = UOSQLEngine()
    tools = GAPIAITools(engine)

    # 1. Define entities & connection chain
    setup_script = """
    CONNECT Human("mogh") [role="Architect"]
         -> Organization("GAPI Enterprise") [tier="Global"]
         -> Project("UOSQL Orchestrator") [domain="Multi-Agent Systems"]
         -> Workflow("Continuous Intelligence") [trigger="event"]
         -> Repository("Amoghhosamane/ANTLRparse") [language="ANTLR/Python"]
         -> AIModel("Gemini-Flash") [latency_ms=120, modality="multimodal"]
         -> DigitalTwin("EdgeRoboticsTwin") [status="synced", telemetry_fps=60];
    """

    print("\n[Step 1] Initializing GAPI Universal Knowledge Graph via UOSQL:")
    res = engine.execute(setup_script)
    print(f"Executed: {res[0]['action']} with {len(res[0]['edges'])} graph connections.")

    # 2. Querying graph with UOSQL
    print("\n[Step 2] Executing Traversal Query:")
    traverse_query = """
    TRAVERSE Human("Levi Reyes")
      -> Organization
      -> Project
      -> Workflow
      -> Repository
      -> AIModel;
    """
    results = engine.execute(traverse_query)
    path = results[0]["paths"][0]
    for idx, node in enumerate(path):
        arrow = " -> " if idx < len(path) - 1 else ""
        print(f"[{node['kind']}] {node['id']}{arrow}", end="")
    print("\n")

    # 3. AI Agent Tool Simulation
    print("[Step 3] AI Agent Tool-Call (Simulated Gemini / Agentic Tool Dispatch):")
    ai_tool_response = tools.call_tool("gapi_query", {
        "query": 'FIND AIModel WHERE modality="multimodal";'
    })
    print("Agent Query Result:")
    print(ai_tool_response)

    print("\n[Step 4] Exporting Knowledge Graph Structure:")
    graph_dict = json.loads(tools.call_tool("gapi_export_graph", {}))
    print(f"Total Graph Entities: {len(graph_dict['nodes'])}")
    print(f"Total Graph Relations: {len(graph_dict['edges'])}")
    print("=" * 70)

if __name__ == "__main__":
    run_demo()
