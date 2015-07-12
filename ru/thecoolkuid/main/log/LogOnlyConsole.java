package ru.thecoolkuid.main.log;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Отправляет данные в консоль без записи.
 * @author coolkuid
 *
 */
public class LogOnlyConsole {
	/**
	 * Отправляет в консоль текст типа "[ДАТА][INFO] Ваш текст".
	 * @param text	Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static Date d = new Date();
	public static SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	public static void printINFO(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[INFO]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа"[ДАТА][ERROR] Ваш Текст" красным текстом.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printERROR(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[ERROR]" + text;
		System.err.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][WARN] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printWARNING(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[WARN]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @param TAG ТЭГ, который будет выведен во 2 скобках.
	 * @throws Exception
	 */
	public static void printCUSTOMTAG(String text, String TAG) throws Exception{
		String pr = "["+f.format(d)+"]"+"["+TAG+"]" + text;
		System.out.println(pr);
	}
	/**
	 *Отправляет в консоль текст типа "[ДАТА][DEBUG] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printDEBUG(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[DEBUG]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа"[ДАТА][ВАШ ТЕКСТ/INFO] Ваш Текст".
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printINFO(String TAG,String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"["+TAG+"/INFO]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/ERROR] Ваш Текст" красным текстом.
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printERROR(String TAG,String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"["+TAG+"/ERROR]" + text;
		System.err.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/WARN] Ваш Текст".
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printWARNING(String TAG,String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"["+TAG+"/WARN]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/DEBUG] Ваш Текст".
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printDEBUG(String TAG,String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"["+TAG+"/DEBUG]" + text;
		System.out.println(pr);
	}
}
