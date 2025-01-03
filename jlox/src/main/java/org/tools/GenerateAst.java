package org.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.err.println("Usage: generate_ast <output_dir>");
            System.exit(64);
        }
        String outputDir = args[0];
        defineAst(outputDir, "Expr", Arrays.asList(
                "Binary : Expr left,Token operator,Expr right",
                "Grouping : Expr expression",
                "Literal : Object Value",
                "Unary : Token operator,Expr right"
        ));
    }

    private static void defineAst(String outputDir, String baseName, List<String> types) throws IOException {
        String path = outputDir + "/" + baseName + ".java";
        PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8);

        writer.println("package org.lox;");
        writer.println();
        writer.println("import java.util.List;");
        writer.println();
        writer.println("abstract class " + baseName + " {");
        writer.println();
        writer.println("abstract <R> R accept(Visitor<R> visitor);");
        defineVisitor(writer, baseName, types);

        for (String type : types) {
           String className = type.split(":")[0].trim();
           String fields = type.split(":")[1].trim();
           defineTypes(writer, baseName, className, fields);
        }


        writer.println("}");
        writer.close();
    }

    private static void defineVisitor(PrintWriter writer, String baseName, List<String> types) {
        writer.println("interface Visitor<R> { ");
        for(String type : types) {
            String typeName = type.split(" ")[0].trim();
            writer.println("R visit" + typeName + baseName + "(" + typeName + " " + baseName.toLowerCase() + ");");
        }
        writer.println("}");
    }

    private static void defineTypes(PrintWriter writer, String baseName, String className, String fields) {
        writer.println("static class " + className + " extends " + baseName + " {");
        defineConstructor(writer, className, fields);
        for(String field : fields.split(",")) {
            String typeField = field.split(" ")[0].trim();
            String fieldName = field.split(" ")[1].trim();
            writer.println("final " + typeField + " " + fieldName + ";");
        }

        writer.println("@Override");
        writer.println("<R> R accept(Visitor<R> visitor) {");
        writer.println("return visitor.visit" + className + baseName + "(this);");
        writer.println("}");
    }

    private static void defineConstructor(PrintWriter writer, String className, String fields) {
        writer.println(className + " ( " +  fields + ") { ");
        for(String field : fields.split(",")) {
            String fieldName = field.split(" ")[1].trim();
            writer.println("this." + fieldName + " = " + fieldName + ";");
        }
        writer.println("}");
    }
}
