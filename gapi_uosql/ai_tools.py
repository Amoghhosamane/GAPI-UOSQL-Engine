"""
AI Tool and MCP interface for GAPI Knowledge Graph.
Enables LLMs to query and navigate the GAPI graph deterministically.
"""
import json
from typing import Dict, Any, List, Optional
from .engine import UOSQLEngine
from .store import GAPIGraphStore

class GAPIAITools:
    def __init__(self, engine: Optional[UOSQLEngine] = None):
        self.engine = engine or UOSQLEngine()

    def get_tool_definitions(self) -> List[Dict[str, Any]]:
        """Return OpenAI / Anthropic / Gemini function calling definitions."""
        return [
            {
                "name": "gapi_query",
                "description": (
                    "Execute a GAPI Universal Knowledge Graph query using UOSQL syntax. "
                    "Supports entity traversal across Human <-> Organization <-> Project "
                    "<-> Workflow <-> Repository <-> AIModel <-> DigitalTwin."
                ),
                "parameters": {
                    "type": "object",
                    "properties": {
                        "query": {
                            "type": "string",
                            "description": "UOSQL statement e.g. TRAVERSE Human('Levi') -> Organization -> Project -> AIModel;"
                        }
                    },
                    "required": ["query"]
                }
            },
            {
                "name": "gapi_connect",
                "description": "Connect entities in the GAPI Knowledge Graph.",
                "parameters": {
                    "type": "object",
                    "properties": {
                        "statement": {
                            "type": "string",
                            "description": "CONNECT statement e.g. CONNECT Human('Alice') -> Project('Athena');"
                        }
                    },
                    "required": ["statement"]
                }
            },
            {
                "name": "gapi_export_graph",
                "description": "Export the current knowledge graph state as JSON for reasoning or visualization.",
                "parameters": {
                    "type": "object",
                    "properties": {}
                }
            }
        ]

    def call_tool(self, name: str, arguments: Dict[str, Any]) -> str:
        """Dispatch tool call."""
        if name == "gapi_query":
            res = self.engine.execute(arguments["query"])
            return json.dumps(res, indent=2)
        elif name == "gapi_connect":
            res = self.engine.execute(arguments["statement"])
            return json.dumps(res, indent=2)
        elif name == "gapi_export_graph":
            return json.dumps(self.engine.store.to_dict(), indent=2)
        raise ValueError(f"Unknown tool: {name}")

