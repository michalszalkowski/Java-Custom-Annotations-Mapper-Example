package lib.pl.btbw.mapper.sparrow;

import lib.pl.btbw.mapper.sparrow.annotation.GetListProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetObjectProperty;
import lib.pl.btbw.mapper.sparrow.annotation.GetStringProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparrowMapper {

	public Map<String, Object> asMap(Object obj) {
		return objToMap(obj);
	}

	private Map<String, Object> objToMap(Object obj) {

		Map<String, Object> map = new HashMap<>();

		Class<?> aClass = obj.getClass();

		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			getStringProperty(obj, map, method);
			getObjectProperty(obj, map, method);
			getListProperty(obj, map, method);
		}

		return map;
	}

	private void getStringProperty(Object obj, Map<String, Object> map, Method method) {

		GetStringProperty annotation = method.getAnnotation(GetStringProperty.class);

		if (annotation != null) {

			String key = annotation.name();
			Object value = methodInvoke(obj, method);

			map.put(key, value);
		}
	}

	private void getObjectProperty(Object obj, Map<String, Object> map, Method method) {

		GetObjectProperty annotation = method.getAnnotation(GetObjectProperty.class);

		if (annotation != null) {

			Object subObj = methodInvoke(obj, method);
			if (subObj != null) {

				String name = annotation.name();
				Map<String, Object> value = objToMap(subObj);

				map.put(name, value);
			}
		}

	}

	private void getListProperty(Object obj, Map<String, Object> map, Method method) {

		GetListProperty annotation = method.getAnnotation(GetListProperty.class);

		if (annotation != null) {

			List subObj = (ArrayList) methodInvoke(obj, method);
			if (subObj != null) {

				String name = annotation.name();
				List values = new ArrayList();

				for (Object item : subObj) {
					values.add(objToMap(item));
				}
				map.put(name, values);
			}
		}

	}

	private Object methodInvoke(Object obj, Method method) {
		try {
			return method.invoke(obj);
		} catch (IllegalAccessException | InvocationTargetException e) {
			return e.getMessage();
		}
	}

}
