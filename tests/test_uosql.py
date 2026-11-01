import pytest
from gapi_uosql import UOSQLEngine, GAPIAITools

def test_entity_creation_and_find():
    engine = UOSQLEngine()
    query = 'Human("Levi", [role="Lead", status="active"]);'
    res = engine.execute(query)
    assert res[0]["action"] == "created_entity"
    assert res[0]["node"]["id"] == "Levi"

    find_res = engine.execute('FIND Human WHERE role="Lead";')
    assert len(find_res[0]["results"]) == 1
    assert find_res[0]["results"][0]["id"] == "Levi"

def test_full_gapi_chain_connection_and_traverse():
    engine = UOSQLEngine()
    
    # Connect full chain matching Levi Reyes' post:
    # Human <-> Organization <-> Project <-> Workflow <-> Repository <-> AIModel <-> DigitalTwin
    connect_script = '''
    CONNECT Human("Levi") 
      -> Organization("GAPI-Org") 
      -> Project("UniversalGraph") 
      -> Workflow("AutoDeploy") 
      -> Repository("Amoghhosamane/ANTLRparse") 
      -> AIModel("Gemini-Flash") 
      -> DigitalTwin("ProductionClusterTwin");
    '''
    res = engine.execute(connect_script)
    assert res[0]["action"] == "connected"
    assert len(res[0]["edges"]) == 6

    # Test Traversal
    traverse_query = '''
    TRAVERSE Human("Levi") 
      -> Organization 
      -> Project 
      -> Workflow 
      -> Repository 
      -> AIModel;
    '''
    trav_res = engine.execute(traverse_query)
    paths = trav_res[0]["paths"]
    assert len(paths) == 1
    path_nodes = paths[0]
    assert len(path_nodes) == 6
    assert path_nodes[0]["kind"] == "Human"
    assert path_nodes[0]["id"] == "Levi"
    assert path_nodes[-1]["kind"] == "AIModel"
    assert path_nodes[-1]["id"] == "Gemini-Flash"

def test_ai_tools_dispatch():
    engine = UOSQLEngine()
    tools = GAPIAITools(engine)

    # Tool connect call
    conn_json = tools.call_tool("gapi_connect", {
        "statement": 'CONNECT Repository("Amoghhosamane/ANTLRparse") -> AIModel("UOSQL-Agent");'
    })
    assert "connected" in conn_json

    # Tool query call
    query_json = tools.call_tool("gapi_query", {
        "query": 'TRAVERSE Repository("Amoghhosamane/ANTLRparse") -> AIModel;'
    })
    assert "UOSQL-Agent" in query_json

