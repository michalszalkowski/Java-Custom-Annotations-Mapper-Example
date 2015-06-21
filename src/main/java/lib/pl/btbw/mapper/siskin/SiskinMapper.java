package lib.pl.btbw.mapper.siskin;

import lib.pl.btbw.mapper.siskin.annotation.SetListProperty;
import lib.pl.btbw.mapper.siskin.annotation.SetObjectProperty;
import lib.pl.btbw.mapper.siskin.annotation.SetStringProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SiskinMapper {

	public Object asObj(Map<String, Object> map, Object obj) {

		Class<?> aClass = obj.getClass();
		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			setStringProperty(obj, map, method);
			setObjectProperty(obj, map, method);
			setListProperty(obj, map, method);
		}

		return obj;
	}

	private void setStringProperty(Object obj, Map<String, Object> map, Method method) {

		SetStringProperty annotation = method.getAnnotation(SetStringProperty.class);

		if (annotation != null) {
			String key = annotation.name();
			Object val = map.get(key);
			methodInvoke(obj, val, method);
		}
	}

	private void setObjectProperty(Object obj, Map<String, Object> map, Method method) {

		SetObjectProperty annotation = method.getAnnotation(SetObjectProperty.class);

		if (annotation != null) {
			String key = annotation.name();
			Map<String, Object> val = (Map<String, Object>) map.get(key);

			Object o = getParam(method);
			methodInvoke(obj, asObj(val, o), method);
		}
	}

	private void setListProperty(Object obj, Map<String, Object> map, Method method) {

		SetListProperty annotation = method.getAnnotation(SetListProperty.class);

		if (annotation != null) {
			String key = annotation.name();
			Class type = annotation.type();

			List<Map<String, Object>> values = (List<Map<String, Object>>) map.get(key);

			List list = new ArrayList();
			for (Map<String, Object> val : values) {
				list.add(asObj(val, getObjFromClass(type)));
			}
			methodInvoke(obj, list, method);
		}
	}

	private Object getParam(Method method) {
		Class<?>[] pType = method.getParameterTypes();
		for (Class<?> aClass : pType) {
			return getObjFromClass(aClass);
		}
		return null;
	}

	private Object getObjFromClass(Class type) {
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void methodInvoke(Object obj, Object val, Method method) {
		try {
			method.invoke(obj, new Object[]{val});
		} catch (IllegalAccessException | InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
	}
}
