package com.lilanz;

import java.io.FileReader;
import java.io.LineNumberReader;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

public class TestJs {	

	public String getTest(String str) {
		String result="default";
		
		Context ct = Context.enter();
		Scriptable scope = ct.initStandardObjects();
		String filename =  "E:/gitrepos/DWeb/test.js";
		
		try {
			LineNumberReader reader = new LineNumberReader(new FileReader(filename));

			String temp = null;
			StringBuffer sb = new StringBuffer();
			while ((temp = reader.readLine()) != null) {
				sb.append(temp).append("\n");
			}
			ct.evaluateString(scope, sb.toString(), null, 1, null);
			Object obj = ct.evaluateString(scope, "test();", null, 1, null);
			result=obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			result=e.getMessage();
		} finally {
			ct.exit();
		}
		return result;
	}
}
