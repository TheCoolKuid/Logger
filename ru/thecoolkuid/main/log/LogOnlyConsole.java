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
	 * @
	 */
	public static Date d = new Date();
	public static SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	public static void printINFO(String text) {
		String pr = "["+f.format(d)+"]"+"[INFO]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа"[ДАТА][ERROR] Ваш Текст" красным текстом.
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printERROR(String text) {
		String pr = "["+f.format(d)+"]"+"[ERROR]" + text;
		System.err.println(pr);
		Thread t = new Thread(new Runnable(){
			@Override
		    public void run() {
		if(SendByEmail.sendEmailDuringError){
			SendByEmail.SendLogByEmail("Произогла ошибка в вашей программе. Время ошибки " + f.format(d), "Содержимое ошибки:" +pr + "\n Версия Java: " + System.getProperty("java.version") + "\n Версия ОС: " + System.getProperty("os.name") + "\n Имя пользователя : " + System.getProperty("user.name"), SendByEmail.EMAILOUT, SendByEmail.EMAILTO, null, false);
		}}});
		t.start();
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][WARN] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printWARNING(String text) {
		String pr = "["+f.format(d)+"]"+"[WARN]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @param TAG ТЭГ, который будет выведен во 2 скобках.
	 * @
	 */
	public static void printCUSTOMTAG(String text, String TAG) {
		String pr = "["+f.format(d)+"]"+"["+TAG+"]" + text;
		System.out.println(pr);
	}
	/**
	 *Отправляет в консоль текст типа "[ДАТА][DEBUG] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printDEBUG(String text) {
		String pr = "["+f.format(d)+"]"+"[DEBUG]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа"[ДАТА][ВАШ ТЕКСТ/INFO] Ваш Текст".
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printINFO(String TAG,String text) {
		String pr = "["+f.format(d)+"]"+"["+TAG+"/INFO]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/ERROR] Ваш Текст" красным текстом.
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printERROR(String TAG,String text) {
		String pr = "["+f.format(d)+"]"+"["+TAG+"/ERROR]" + text;
		System.err.println(pr);
		Thread t = new Thread(new Runnable(){
			@Override
		    public void run() {
		if(SendByEmail.sendEmailDuringError){
			SendByEmail.SendLogByEmail("Произогла ошибка в вашей программе. Время ошибки " + f.format(d), "Содержимое ошибки:" +pr + "\n Версия Java: " + System.getProperty("java.version") + "\n Версия ОС: " + System.getProperty("os.name") + "\n Имя пользователя : " + System.getProperty("user.name"), SendByEmail.EMAILOUT, SendByEmail.EMAILTO, null, false);
		}}});
		t.start();
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/WARN] Ваш Текст".
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printWARNING(String TAG,String text) {
		String pr = "["+f.format(d)+"]"+"["+TAG+"/WARN]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/DEBUG] Ваш Текст".
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @
	 */
	public static void printDEBUG(String TAG,String text) {
		String pr = "["+f.format(d)+"]"+"["+TAG+"/DEBUG]" + text;
		System.out.println(pr);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/DEBUG] Ваш Текст".
	 * Также отправляет "[ДАТА][ВАШ ТЕКСТ/DEBUG] Содержимое StackTrace".
	 * @param text Ваш текст.
	 * @param e	Exception.
	 */
	public static void printERROR(String text, Exception e) {
		String pr = "["+f.format(d)+"]"+"[ERROR]" + text;
		String x = "["+f.format(d)+"]"+"[ERROR]" + e.toString();
		System.err.println(pr);
		System.err.println(x);
		Thread t = new Thread(new Runnable(){
			@Override
		    public void run() {
		if(SendByEmail.sendEmailDuringError){
			SendByEmail.SendLogByEmail("Произогла ошибка в вашей программе. Время ошибки " + f.format(d), "Содержимое ошибки:" +pr + "\nStackTrace : "+ e.toString() +"\n Версия Java: " + System.getProperty("java.version") + "\n Версия ОС: " + System.getProperty("os.name") + "\n Имя пользователя : " + System.getProperty("user.name"), SendByEmail.EMAILOUT, SendByEmail.EMAILTO, null, false);
		}}});
		t.start();
		}
}
