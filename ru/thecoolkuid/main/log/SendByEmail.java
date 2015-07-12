package ru.thecoolkuid.main.log;

import java.io.File;
/**
 * Отправка писем. Реализованно с помошью библеотеки Javax.Mail.
 * @author coolkuid
 *
 */
public class SendByEmail {
	
	private static ru.thecoolkuid.main.send.SendEmail send;
	protected static String EMAIL, PASS, SMTPHostName;
	public static String EMAILTO, EMAILOUT;
	public static boolean sendEmailDuringError;
	protected static boolean Auth, StartTLS;
	protected static int port;
	/**
	 * Отправка сообщения
	 * @param Subject Тема Сообщения.
	 * @param text Содержимое сообщения.
	 * @param outEmail Адрес отправителя.
	 * @param toEmail Адрес получателя.
	 * @param file файл, который необходимо прикрепить.
	 */
	public static void SendLogByEmail(String Subject, String text, String outEmail, String toEmail, File file, boolean useAttachment){
		send = new ru.thecoolkuid.main.send.SendEmail(EMAIL, PASS, Auth, StartTLS , SMTPHostName, port);
		send.send(Subject, text, outEmail, toEmail, file, useAttachment);
	}
	 /**
	  * Устанавливает параметры почтового сервера и аккаунта.
	  * !!Вызывать до того, как будут использованны методы с отправкой писем а также до sendEmailDuringError!!
	  * @param email Ваш Email адрес.
	  * @param pass	Ваш пароль.
	  * @param auth	Аутентификация.
	  * @param startTLS	Использование StartTLS.
	  * @param SMTPHostname	Адрес SMTP сервера.
	  * @param port	Порт, по которому отвечает SMTP сервер
	  */
	public static void SetEmailProterty(String email, String pass, boolean auth, boolean startTLS, String SMTPhostname, int Port){
		EMAIL = email;
		PASS = pass;
		Auth = auth;
		StartTLS = startTLS;
		SMTPHostName = SMTPhostname;
		port = Port;
	}
	/**
	 * Отправка сообшений об ошибках, при выхове метода LogWithPrint.printERROR.
	 * !!Вызывать до использования метода LogWithPrint.printERROR!!
	 * @param x  Параметр включения
	 * @param emailTO адрес получателя.
	 * @param emailOUT адрес отправителя.
	 * @return
	 */
	public static boolean sendEmailDuringError(boolean x, String emailTO, String emailOUT){
		sendEmailDuringError = x;
		EMAILTO = emailTO;
		EMAILOUT = emailOUT;
		return true;
	}
	/**
	 * Отправка Log файда на указанный email.
	 * @param toEmail адрес получателя.
	 */
	public static void sendLog(String toEmail){
		send = new ru.thecoolkuid.main.send.SendEmail(EMAIL, PASS, Auth, StartTLS , SMTPHostName, port);
		send.send(LogWithPrint.file.getName(), "", "", toEmail, LogWithPrint.file, true);
	}
}
