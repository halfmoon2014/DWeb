package com.lilanz;

import javax.script.ScriptEngineManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class NashornTest {
	public String get(String par) {
		Object str = null;

		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		StringBuffer code = new StringBuffer();
		try {
			String filename = "E:/gitrepos/DWeb/test.js";
			LineNumberReader reader = new LineNumberReader(new FileReader(filename));
			String temp = null;
			while ((temp = reader.readLine()) != null) {
				code.append(temp).append("\n");
			}

			nashorn.eval(code.toString());
			Invocable invocable = (Invocable) nashorn;

			str = invocable.invokeFunction("test", par);
			System.out.println(str);
			System.out.println(str.getClass());
			// String name = "Runoob";
			// Integer result = null;
			// nashorn.eval("print('" + sb.length() + "')");
			// result = (Integer) nashorn.eval("10 + 2");

		} catch (ScriptException e) {
			str = "ScriptException" + e.getMessage();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			str = "FileNotFoundException" + e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			str = "IOException" + e.getMessage();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			str = "NoSuchMethodException";
		}
		return str.toString();
	}
}
