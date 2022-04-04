package edu.mooncoder.controllers.managers;

import edu.mooncoder.model.containers.*;
import edu.mooncoder.model.wrappers.Class;
import edu.mooncoder.model.wrappers.Comment;
import edu.mooncoder.model.wrappers.Error;
import edu.mooncoder.model.wrappers.Method;
import edu.mooncoder.model.wrappers.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparedReportBuilder {
    private double score = 0;
    private double cantComments = 0;
    private double cantVariables = 0;
    private double cantMethods = 0;
    private double cantClasses = 0;
    private double repeatedComments = 0;
    private double repeatedVariables = 0;
    private double repeatedMethods = 0;
    private double repeatedClasses = 0;

    private List<Comment> comments1;
    private List<Comment> comments2;

    private List<Variable> variables1;
    private List<Variable> variables2;

    private List<Method> methods1;
    private List<Method> methods2;

    private List<Class> classes1;
    private List<Class> classes2;

    private List<Comment> getComments() {
        List<Comment> tmp = CommentsHolder.clean();
        cantComments += tmp.size();
        return tmp;
    }

    private List<Variable> getVariables() {
        List<Variable> tmp = VariablesHolder.clean();
        cantVariables += tmp.size();
        return tmp;
    }

    private List<Method> getMethods() {
        List<Method> tmp = MethodsHolder.clean();
        cantMethods += tmp.size();
        return tmp;
    }

    private List<Class> getClasses() {
        List<Class> tmp = ClassesHolder.clean();
        cantClasses += tmp.size();
        return tmp;
    }

    private void setScore(Map<String, Object> table) {
        if (cantComments != 0) score += repeatedComments / cantComments * 0.25;
        if (cantVariables != 0) score += repeatedVariables / cantVariables * 0.25;
        if (cantMethods != 0) score += repeatedMethods / cantMethods * 0.25;
        if (cantClasses != 0) score += repeatedClasses / cantClasses * 0.25;

        table.put("Score", String.format("%.2f", score));
    }

    private void setComments(Map<String, Object> table) {
        List<Map<String, Object>> repeatedList = new ArrayList<>();
        List<Comment> commentsUsedList = new ArrayList<>();

        for (Comment comment1 : comments1) {
            if (commentsUsedList.contains(comment1)) {
                Map<String, Object> tmpMap = new HashMap<>();
                tmpMap.put("Texto", comment1.comment());

                repeatedList.add(tmpMap);
                repeatedComments++;

                continue;
            }
            int tmpRepeated = 0;
            for (Comment comment2 : comments2) {
                if (comment1.equals(comment2)) {
                    tmpRepeated++;
                }
            }
            if (tmpRepeated != 0) {
                Map<String, Object> tmpMap = new HashMap<>();
                tmpMap.put("Texto", comment1.comment());

                repeatedComments += tmpRepeated + 1;
                repeatedList.add(tmpMap);
                commentsUsedList.add(comment1);
            }
        }

        table.put("Comentarios", repeatedList);
    }

    private void setVariables(Map<String, Object> table) {
        List<Map<String, Object>> repeatedList = new ArrayList<>();
        List<Variable> variablesUsedList = new ArrayList<>();

        for (Variable var1 : variables1) {
            int tmpRepeated = 0;
            for (Variable var2 : variables2) {
                if (var1.equals(var2)) {
                    var1.setScope(var2.getScope());
                    tmpRepeated++;
                }
            }
            if (tmpRepeated != 0) {
                Map<String, Object> tmpMap = new HashMap<>();
                tmpMap.put("Nombre", var1.getName());
                tmpMap.put("Tipo", var1.getType());
                tmpMap.put("Funcion", var1.getScope());

                repeatedVariables++;
                if (!variablesUsedList.contains(var1)) {
                    repeatedVariables += tmpRepeated;
                }
                repeatedList.add(tmpMap);
                variablesUsedList.add(var1);
            }
        }

        table.put("Variables", repeatedList);
    }

    private void setMethods(Map<String, Object> table) {
        List<Map<String, Object>> repeatedList = new ArrayList<>();
        List<Method> methodsUsedList = new ArrayList<>();

        for (Method method1 : methods1) {
            if (methodsUsedList.contains(method1)) {
                repeatedMethods++;
                continue;
            }
            int tmpRepeated = 0;
            for (Method method2 : methods2) {
                if (method1.equals(method2)) {
                    tmpRepeated++;
                }
            }
            if (tmpRepeated != 0) {
                Map<String, Object> tmpMap = new HashMap<>();
                tmpMap.put("Nombre", method1.name());
                tmpMap.put("Tipo", method1.type());
                tmpMap.put("Parametros", method1.parameters().length);

                repeatedMethods += tmpRepeated + 1;
                repeatedList.add(tmpMap);
                methodsUsedList.add(method1);
            }
        }

        table.put("Metodos", repeatedList);
    }

    private void setClasses(Map<String, Object> table) {
        List<Map<String, Object>> repeatedList = new ArrayList<>();
        List<Class> classUsedList = new ArrayList<>();

        for (Class class1 : classes1) {
            if (classUsedList.contains(class1)) {
                repeatedClasses++;
                continue;
            }
            int tmpRepeated = 0;
            for (Class class2 : classes2) {
                if (class1.equals(class2)) {
                    tmpRepeated++;
                }
            }
            if (tmpRepeated != 0) {
                Map<String, Object> tmpMap = new HashMap<>();
                tmpMap.put("Nombre", class1.name());

                repeatedClasses += tmpRepeated + 1;
                repeatedList.add(tmpMap);
                classUsedList.add(class1);
            }
        }

        table.put("Clases", repeatedList);
    }

    private void setErrors(List<Map<String, Object>> errores) {
        for (Error error : ErrorsHolder.clean()) {
            Map<String, Object> errorMap = new HashMap<>();

            errorMap.put("Projecto", error.project());
            errorMap.put("Archivo", error.filename());
            errorMap.put("Columna", error.column());
            errorMap.put("Mensage", error.message());
            errorMap.put("Linea", error.line());
            errorMap.put("Tipo", error.type().getMessage());

            errores.add(errorMap);
        }
    }

    public void closeFirstProject() {
        comments1 = getComments();
        variables1 = getVariables();
        methods1 = getMethods();
        classes1 = getClasses();
        ErrorsHolder.changeProject();
    }

    public void closeSecondProject() {
        comments2 = getComments();
        variables2 = getVariables();
        methods2 = getMethods();
        classes2 = getClasses();
    }

    public Map<String, Object> getReportTable() {
        Map<String, Object> table = new HashMap<>();
        setComments(table);
        setVariables(table);
        setMethods(table);
        setClasses(table);
        setScore(table);

        return table;
    }

    public List<Map<String, Object>> getErrorsArray() {
        List<Map<String, Object>> list = new ArrayList<>();
        setErrors(list);
        return list;
    }

    public boolean hasErrors() {
        return ErrorsHolder.hasErrors();
    }
}
