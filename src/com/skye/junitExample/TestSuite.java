package com.skye.junitExample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {
	private List<Test> tests = new ArrayList<Test>();;

	public TestSuite() {
	}

	public TestSuite(Class<?> clz) {
		// 找出每個test開頭的方法
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			if (Modifier.isPublic(method.getModifiers())
					&& method.getName().startsWith("test")) {
				Constructor<?> constructor = null;
				try {
					constructor = clz.getConstructor();
					// 建立TestCase實例
					TestCase testCase = (TestCase) constructor.newInstance();
					// 設定要呼叫的testXXX()方法
					testCase.setName(method.getName());
					// 加入測試
					add(testCase);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public void add(Test test) {
		tests.add(test);
	}

	public void add(Class<?> clz) {
		tests.add(new TestSuite(clz));
	}

	@Override
	public void run() {
		for (Test test : tests) {
			test.run();
		}
	}
}
