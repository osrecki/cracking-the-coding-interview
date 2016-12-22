package me.osrecki.prog.java.ctci;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:  Dinko Osrecki
 * Date:    21/12/2016
 */
public class TestHelper {
  public static <T> List<T> testMethodsResults(Class klass, String methodName, Object... params) {
    List<Method> methods = testMethods(klass, methodName);
    List<T> results = new ArrayList<>(methods.size());

    try {
      for(Method method : methods) {
        T result = (T) method.invoke(null, params);
        results.add(result);
      }
    } catch(IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }

    return results;
  }

  private static List<Method> testMethods(Class klass, String methodName) {
    List<Method> declaredMethods = Arrays.asList(klass.getMethods());

    return declaredMethods.stream()
        .filter(method -> method.getName().startsWith(methodName))
        .collect(Collectors.toList());
  }

  public static String printMatrix(int[][] matrix) {
    return Arrays.stream(matrix).map(row ->
        Arrays.stream(row).mapToObj(Integer::toString).collect(Collectors.joining(", "))
    ).collect(Collectors.joining("; "));
  }

  public static int[][] duplicateMatrix(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0)
      throw new IllegalArgumentException("Matrix has invalid dimensions.");

    int m = matrix.length;
    int[][] clone = new int[m][];

    for(int i = 0; i < m; i++) {
      int n = matrix[i].length;
      clone[i] = new int[n];

      System.arraycopy(matrix[i], 0, clone[i], 0, n);
    }

    return clone;
  }
}
