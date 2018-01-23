package Dynamic_Programming.Print_Subsequence;

import tools.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	//优化后的，省空间：每一步涂掉再还原即可
	public static void process(char[] chs, int i) {
		if (i == chs.length) {  //字符到底了，要越界 abc
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);  //每次都走本分支，要当前的字符i，判断下一个
		char tmp = chs[i];  //把该位置拿出来存起来，改成0
		chs[i] = 0;
		process(chs, i + 1);  //继续下一步，打印ab
		chs[i] = tmp;  //再把c填回去
	}

	// 主方法，以下是原版的
	public static void func(String str)
	{
		char[] chs = str.toCharArray();
		process1(chs, 0, new ArrayList<Character>());  //新链表，一开始是空的
	}

	//未优化的
	public static void process1(char[] chs, int i, List<Character> res)
	// res是之前收到的结果
	{
		if(i==chs.length)  //到末尾了，就打印收集的结果
			printList(res);
		List<Character> resKeep = copyList(res);  //保留当前字符
		resKeep.add(chs[i]);
		process1(chs, i, resKeep);   //要

		List<Character> resNo = copyList(res);  //保留当前字符
		process1(chs, i+1, resNo);   //不要
	}

	public static void printList(List<Character> res)
	// 打印list里
	{
	 // ...;
	}

	public static List<Character> copyList(List<Character> list)
	{
		return null;
	}

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
