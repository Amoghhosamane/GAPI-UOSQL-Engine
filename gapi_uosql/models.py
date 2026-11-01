"""
GAPI Core Models for Knowledge Graph Layer.
Entities: Human <-> Organization <-> Project <-> Workflow <-> Repository <-> AIModel <-> DigitalTwin
"""
from typing import Dict, Any, Optional
from pydantic import BaseModel, Field

class EntityNode(BaseModel):
    kind: str
    id: str
    properties: Dict[str, Any] = Field(default_factory=dict)

    @property
    def key(self) -> str:
        return f"{self.kind}:{self.id}"

class GraphEdge(BaseModel):
    source: str
    target: str
    relationship: str = "CONNECTED_TO"
    properties: Dict[str, Any] = Field(default_factory=dict)

