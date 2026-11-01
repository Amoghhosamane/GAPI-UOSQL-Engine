package gapi.uosql;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println(" GAPI Universal Knowledge Graph Engine (Java + ANTLR4)");
        System.out.println(" Narrative: Human <-> Org <-> Project <-> Workflow <-> Repo <-> Model <-> Twin");
        System.out.println("========================================================================\n");

        GAPIGraphStore store = new GAPIGraphStore();
        UOSQLExecutionVisitor visitor = new UOSQLExecutionVisitor(store);

        String uosqlScript = """
            Human("Levi Reyes", [role="Lead Architect", status="Active"]);
            
            CONNECT Human("Levi Reyes") [role="Architect"]
                 -> Organization("GAPI-Core") [domain="Universal Orchestration"]
                 -> Project("UOSQL-Engine") [type="MultiAgent"]
                 -> Workflow("Continuous-KG-Sync") [frequency="realtime"]
                 -> Repository("Amoghhosamane/ANTLRparse") [language="Java/ANTLR"]
                 -> AIModel("Gemini-Flash") [latency_ms=100]
                 -> DigitalTwin("ProductionClusterTwin") [status="synced"];
            
            TRAVERSE Human("Levi Reyes")
                 -> Organization
                 -> Project
                 -> Workflow
                 -> Repository
                 -> AIModel;

            FIND AIModel;
        """;

        System.out.println("Executing UOSQL Script:\n----------------------");
        System.out.println(uosqlScript);
        System.out.println("---------------------- Execution Output ----------------------");

        UOSQLLexer lexer = new UOSQLLexer(CharStreams.fromString(uosqlScript));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        UOSQLParser parser = new UOSQLParser(tokens);

        UOSQLParser.UosqlProgramContext program = parser.uosqlProgram();
        for (UOSQLParser.StatementContext stmt : program.statement()) {
            visitor.visit(stmt);
        }

        System.out.println("\nTotal Entities in Knowledge Graph: " + store.getNodes().size());
        System.out.println("========================================================================");
    }
}

