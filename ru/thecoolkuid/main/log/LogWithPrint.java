package ru.thecoolkuid.main.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Выводит сообщения с консоль, с последующей записью в файл с именем "ДЕНЬ-МЕСЯЦ-ГОД.LogName.log"
 * LogName указывается методом LogWithPrint.LogName;
 * @author coolkuid
 *
 */
public class LogWithPrint {
	public static Date d = new Date();
	public static SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
	public static SimpleDateFormat f1 = new SimpleDateFormat("dd-MM-yyyy");
	public static File file;
	public static String LogName;
	
	/**
	 * Отправляет в консоль текст типа "[ДАТА][INFO] Ваш текст".
	 * @param text	Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printINFO(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[INFO]" + text;
		System.out.println(pr);
		printinfile(pr,LogName);
	}
	/**
	 * Отправляет в консоль текст типа"[ДАТА][ERROR] Ваш Текст" красным текстом.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printERROR(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[ERROR]" + text;
		String x =  "Текст Ошибки: " + pr + "\n Версия Java: " + System.getProperty("java.version") + "\n Версия ОС: " + System.getProperty("os.name") + "\n Имя пользователя : " + System.getProperty("user.name");
		System.err.println(pr);
		printinfile(pr,LogName);
		printinfile(x,LogName);
		if(SendByEmail.sendEmailDuringError){
			SendByEmail.SendLogByEmail("Произогла ошибка в вашей программе. Время ошибки " + f.format(d), x, SendByEmail.EMAILOUT, SendByEmail.EMAILTO, LogWithPrint.file, true);
		}if(SendByFTP.sendDuringError){
			SendByFTP.FTPUpload("", file);
		}
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][WARN] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printWARNING(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[WARN]" + text;
		System.out.println(pr);
		printinfile(pr,LogName);
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
		printinfile(pr,LogName);
	}
	/**
	 *Отправляет в консоль текст типа "[ДАТА][DEBUG] Ваш Текст".
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printDEBUG(String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"[DEBUG]" + text;
		System.out.println(pr);
		printinfile(pr,LogName);
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
		printinfile(pr,LogName);
	}
	/**
	 * Отправляет в консоль текст типа "[ДАТА][ВАШ ТЕКСТ/ERROR] Ваш Текст" красным текстом.
	 * @param TAG Дополнительный тэг.
	 * @param text Текст, который необходимо вывести.
	 * @throws Exception
	 */
	public static void printERROR(String TAG,String text) throws Exception{
		String pr = "["+f.format(d)+"]"+"["+TAG+"/ERROR]" + text;
		String x =  "Текст Ошибки: " + pr + "\n Версия Java: " + System.getProperty("java.version") + "\n Версия ОС: " + System.getProperty("os.name") + "\n Имя пользователя : " + System.getProperty("user.name");
		System.err.println(pr);
		printinfile(pr,LogName);
		printinfile(x,LogName);
		if(SendByEmail.sendEmailDuringError){
			SendByEmail.SendLogByEmail("Произошла ошибка в вашей программе. Время ошибки  " + f.format(d), x, SendByEmail.EMAILOUT, SendByEmail.EMAILTO, LogWithPrint.file, true);
		}if(SendByFTP.sendDuringError){
			SendByFTP.FTPUpload("", file);
		}
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
		printinfile(pr,LogName);
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
		printinfile(pr,LogName);
	}
	public static void printERROR(String text, Exception e) throws Exception{
		String pr = "["+f.format(d)+"]"+"[ERROR]" + text;
		String ex = "["+f.format(d)+"]"+"[ERROR]" + e.toString();
		String x ="Текст Ошибки: " + pr + "\nStackTrace:  "+ e.toString() +
				"\nВерсия Java: " + System.getProperty("java.version") + "\nВерсия ОС: " + System.getProperty("os.name") + "\nИмя пользователя : " + System.getProperty("user.name");
		System.err.println(pr);
		System.err.println(ex);
		printinfile(pr,LogName);
		printinfile(ex,LogName);
		printinfile(x,LogName);
		if(SendByEmail.sendEmailDuringError){
			SendByEmail.SendLogByEmail("Произошла ошибка в вашей программе. Время Ошибки " + f.format(d), x, SendByEmail.EMAILOUT, SendByEmail.EMAILTO, LogWithPrint.file, true);
		}if(SendByFTP.sendDuringError){
			SendByFTP.FTPUpload("", file);
		}
	}
	public static void printinfile(String text, String logName) throws Exception{
		file = new File(f1.format(d)+"."+logName+".log");
		file.createNewFile();
		PrintWriter x = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file , true)), true);
		x.println(text);
		x.close();
	}
	/**
	 * Указывает переменную LogName. Рекомендую генерировать переменную для каждого клиента отдельно.
	 * @param  Содержимое переменной.
	 * @return
	 */
	public static String setLogName(String x){
		LogName = x;
		return x;
	}
}
